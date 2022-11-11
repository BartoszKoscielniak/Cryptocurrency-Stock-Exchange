package com.example.cryptoexchange.config;

import com.example.cryptoexchange.jwt.AuthenticationFilter;
import com.example.cryptoexchange.jwt.JwtAuthorizationFilter;
import com.example.cryptoexchange.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static com.example.cryptoexchange.user.UserPermissions.USER_READ;
import static com.example.cryptoexchange.user.UserRole.USER;

@Configuration
@EnableWebSecurity/*TODO: use when using preauthorize annotations in controller */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @Autowired
    public WebSecurityConfig(PasswordEncoder passwordEncoder, UserService userService){
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()//Use in browser apps, disable in non-browser apps
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new AuthenticationFilter(authenticationManager()))
                .addFilterAfter(new JwtAuthorizationFilter(), AuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("index", "/", "/js/**", "/css/**", "/img/**", "/v3/api-docs/**", "/swagger-ui/**").permitAll()//can make index page to be seen by everyone
                .antMatchers("/api/wallet/**").hasRole(USER.name())
                .antMatchers("/api/transactions/**").hasRole(USER.name())
                .antMatchers(HttpMethod.GET,"/api/user/**").hasAuthority(USER_READ.name())
                .anyRequest()
                .authenticated();
                /*.and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .defaultSuccessUrl("/home", true)
                    .usernameParameter("username")
                    .passwordParameter("password")
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))//DELETE when csrf is enabled cuz only POST is available then
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .logoutSuccessUrl("/login");*/
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }
}


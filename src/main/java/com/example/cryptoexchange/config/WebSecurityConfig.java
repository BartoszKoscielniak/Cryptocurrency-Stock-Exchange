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
@EnableWebSecurity/*TODO: use when using preauthorize annotations in controller
@EnableGlobalMethodSecurity(prePostEnabled = true) */
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
                .antMatchers("index", "/", "/js/**", "/css/**", "/img/**").permitAll()//can make index page to be seen by everyone
                .antMatchers("/api/wallet/**").hasRole(USER.name())
                .antMatchers("/api/transactions/**").hasRole(USER.name())
                .antMatchers(HttpMethod.GET,"/api/user/**").hasAuthority(USER_READ.name())
                .anyRequest()
                .authenticated()
/*                .and()
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
                    .logoutSuccessUrl("/login")*/;
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

    /*private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final String[] AUTH_WHITELIST = {
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/api/registration/**",
            "/login*",
            "/login",
            "/api/user/perform_login*",
            "/api/login/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/api/login");

        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/js/**", "/css/**", "/img/**").permitAll();
        http.authorizeRequests().antMatchers("/admin/**").hasRole(UserRole.ADMIN.name());
        http.authorizeRequests().antMatchers("/home*").hasRole(UserRole.USER.name());
        http.authorizeRequests().anyRequest().authenticated();
        http.formLogin().loginPage("/login.html");
        http.formLogin().defaultSuccessUrl("/home.html");
        http.formLogin().failureUrl("/login.html?error=true");
        http.formLogin().successHandler(authenticationSuccessHandler());
        http.formLogin().failureHandler(authenticationFailureHandler());
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
*//*
        .logout()
        .logoutUrl("/perform_logout")
        .deleteCookies("JSESSIONID")
        .invalidateHttpSession(true);
        //.logoutSuccessHandler(logoutSuccesHandler());*//*
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler(){
        System.out.println("SUCCES");
        return new CustomSuccesAuthenticationHandler();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler(){
        System.out.println("FAILURE");
        return new CustomFailureAuthenticationHandler();
    }*/
}


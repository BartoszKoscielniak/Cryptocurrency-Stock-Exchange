package com.example.cryptoexchange.userregistration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/registration")
@AllArgsConstructor
public class UserRegistrationController {

    private final UserRegistrationService userRegistrationService;

    @PostMapping
    public String register(@RequestBody UserRegistrationRequest request){
        return userRegistrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirmToken(@RequestParam("token") String token){
        return userRegistrationService.confirmToken(token);
    }
}

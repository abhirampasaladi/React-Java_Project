package org.project.ew_backend.controller;
import org.project.ew_backend.model.AuthRequestHolder;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {

    private final AuthenticationManager authenticationManager;

    public RestApiController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequestHolder authRequestHolder) {
        String username = authRequestHolder.getUsername();
        String password = authRequestHolder.getPassword();
        try{
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "Login Success";
        }
        catch (Exception error){
            return "Login Failed {error}";
        }
    }

    @GetMapping("/sample")
    public String sample() {
        return "sample";
    }

    @GetMapping("/test")
    public String test() {return "test";}
}

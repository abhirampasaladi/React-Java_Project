package org.project.ew_backend.controller;

import org.project.ew_backend.model.AuthRequestHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RestApiController {

    @PostMapping("/login")
    public String login(@RequestBody AuthRequestHolder authRequestHolder) {
        String username = authRequestHolder.getUsername();
        String password = authRequestHolder.getPassword();
        return "redirect:/login?username=" + username + "&password=" + password;
    }
}

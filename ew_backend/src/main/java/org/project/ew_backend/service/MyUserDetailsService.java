package org.project.ew_backend.service;

import org.project.ew_backend.model.MyUserDetails;
import org.project.ew_backend.model.UserDB;
import org.project.ew_backend.repository.JPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final JPARepo jpaRepo;
    private final Logger logger = Logger.getLogger(MyUserDetailsService.class.getName());
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    @Autowired
    public MyUserDetailsService(JPARepo jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.log(Level.INFO, "Loading user by username: {username} ");
        for (UserDB user : jpaRepo.findAll()) {
            logger.log(Level.INFO, "Found user: {user.getUsername()}");
            if(passwordEncoder.matches(username, user.getUsername())) {
                return new MyUserDetails(user);
            }
        }
        logger.log(Level.SEVERE, "Username {0} not found", username);
        throw new UsernameNotFoundException("Username " + username + " not found");
    }
}

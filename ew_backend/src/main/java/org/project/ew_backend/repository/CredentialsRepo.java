package org.project.ew_backend.repository;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CredentialsRepo {
    private static final Map<String, List<String>> credentialsMap = new HashMap<>();

    CredentialsRepo() {
        credentialsMap.put("admin",Arrays.asList("admin","admin@mail.com","+1 1234567890"));
        credentialsMap.put("user",Arrays.asList("user","user@mail.com","+1 1245789630"));
        credentialsMap.put("pass",Arrays.asList("pass","pass@mail.com","+91 1203659874"));
    }

    public List<String> getCredentials(String username) {
        return credentialsMap.get(username);
    }
}

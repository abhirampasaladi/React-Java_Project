package org.project.ew_backend.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CredentialsRepo {
    private static Map<String, String> credentialsMap = new HashMap<String, String>();

    CredentialsRepo() {
        credentialsMap.put("admin", "admin");
        credentialsMap.put("user", "user");
        credentialsMap.put("pass", "pass");
        credentialsMap.put("admin2", "admin2");
    }

    public void addCredentials(String username, String password) {
        credentialsMap.put(username, password);
    }

    public String getCredentials(String username) {
        return credentialsMap.get(username);
    }
}

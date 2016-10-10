package org.springframework.social.mitreidconnect.api.impl;

import org.springframework.social.mitreidconnect.api.UserInfo;
import org.springframework.social.mitreidconnect.api.UserOperations;
import org.springframework.web.client.RestTemplate;

public class UserTemplate extends AbstractMitreidOperations implements UserOperations {

    private final RestTemplate restTemplate;

    public UserTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
        super(isAuthorizedForUser);
        this.restTemplate = restTemplate;
    }
    
    @Override
    public UserInfo getUserInfo() {
        return restTemplate.getForObject(buildUri("userinfo"), UserInfo.class);
    }
}

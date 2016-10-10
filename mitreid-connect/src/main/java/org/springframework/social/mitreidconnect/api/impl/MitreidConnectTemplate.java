package org.springframework.social.mitreidconnect.api.impl;

import org.springframework.social.mitreidconnect.api.MitreidConnect;
import org.springframework.social.mitreidconnect.api.UserOperations;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;

public class MitreidConnectTemplate extends AbstractOAuth2ApiBinding implements MitreidConnect {

    private UserOperations userOperations;
    
    public MitreidConnectTemplate(String accessToken) {
        super(accessToken);
        initSubApis();
    }

    @Override
    public UserOperations userOperations() {
        return this.userOperations;
    }
    
    private void initSubApis() {
        this.userOperations = new UserTemplate(getRestTemplate(), isAuthorized());
    }

}

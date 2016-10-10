package org.springframework.social.mitreidconnect.connect;

import org.springframework.social.mitreidconnect.api.MitreidConnect;
import org.springframework.social.mitreidconnect.api.impl.MitreidConnectTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

public class MitreidConnectServiceProvider extends AbstractOAuth2ServiceProvider<MitreidConnect> {

    public MitreidConnectServiceProvider(String clientId, String clientSecret) {
        super(new OAuth2Template(clientId, clientSecret,
            "http://localhost:8081/openid-connect-server-webapp/authorize",
            "http://localhost:8081/openid-connect-server-webapp/token"));
    }
    
    @Override
    public MitreidConnect getApi(String accessToken) {
        return new MitreidConnectTemplate(accessToken);
    }

}

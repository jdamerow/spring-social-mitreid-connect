package org.springframework.social.mitreidconnect.connect;

import org.springframework.social.mitreidconnect.api.MitreidConnect;
import org.springframework.social.mitreidconnect.api.impl.MitreidConnectTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

public class MitreidConnectServiceProvider extends AbstractOAuth2ServiceProvider<MitreidConnect> {
    
    private String providerUrl;

    public MitreidConnectServiceProvider(String clientId, String clientSecret, String providerUrl) {
        super(new OAuth2Template(clientId, clientSecret,
            providerUrl + "/authorize",
            providerUrl + "/token"));
        this.providerUrl = providerUrl;
    }
    
    @Override
    public MitreidConnect getApi(String accessToken) {
        return new MitreidConnectTemplate(accessToken, providerUrl);
    }

}

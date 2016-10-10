package org.springframework.social.mitreidconnect.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.mitreidconnect.api.MitreidConnect;

public class MitreidConnectConnectionFactory extends OAuth2ConnectionFactory<MitreidConnect> {

    public MitreidConnectConnectionFactory(String clientId, String clientSecret) {
        super("mitreidconnect", new MitreidConnectServiceProvider(clientId, clientSecret), new MitreidConnectAdapter());
    }

}

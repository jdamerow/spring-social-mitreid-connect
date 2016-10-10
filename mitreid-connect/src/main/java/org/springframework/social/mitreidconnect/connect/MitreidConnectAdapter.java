package org.springframework.social.mitreidconnect.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.mitreidconnect.api.MitreidConnect;
import org.springframework.social.mitreidconnect.api.UserInfo;

public class MitreidConnectAdapter implements ApiAdapter<MitreidConnect> {

    @Override
    public boolean test(MitreidConnect api) {
        try {
            api.userOperations().getUserInfo();
            return true;
        } catch (ApiException e) {
            return false;
        }
    }

    @Override
    public void setConnectionValues(MitreidConnect api, ConnectionValues values) {
        UserInfo profile = api.userOperations().getUserInfo();
        values.setProviderUserId(profile.getSub());
        values.setDisplayName("@" + profile.getName());
        values.setProfileUrl(profile.getWebsite());
        values.setImageUrl(null);
    }

    @Override
    public UserProfile fetchUserProfile(MitreidConnect api) {
        UserInfo profile = api.userOperations().getUserInfo();
        return new UserProfileBuilder().setName(profile.getName())
                .setUsername(profile.getSub()).setEmail(profile.getEmail())
                .setFirstName(profile.getGivenName())
                .setLastName(profile.getFamilyName()).build();
    }

    @Override
    public void updateStatus(MitreidConnect api, String message) {
        // TODO Auto-generated method stub

    }

}

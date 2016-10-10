package org.springframework.social.mitreidconnect.api.impl;

import java.net.URI;

import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

class AbstractMitreidOperations {
	
	private final boolean isUserAuthorized;

	public AbstractMitreidOperations(boolean isUserAuthorized) {
		this.isUserAuthorized = isUserAuthorized;
	}
	
	protected void requireUserAuthorization() {
		if (!isUserAuthorized) {
			throw new MissingAuthorizationException("mitreidconnect");
		}
	}
	
	protected URI buildUri(String path) {
		return buildUri(path, EMPTY_PARAMETERS);
	}
	
	protected URI buildUri(String path, String parameterName, String parameterValue) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set(parameterName, parameterValue);
		return buildUri(path, parameters);
	}
	
	protected URI buildUri(String path, MultiValueMap<String, String> parameters) {
		return URIBuilder.fromUri(API_URL_BASE + path).queryParams(parameters).build();
	}
	
	private static final String API_URL_BASE = "http://localhost:8081/openid-connect-server-webapp/";

	private static final LinkedMultiValueMap<String, String> EMPTY_PARAMETERS = new LinkedMultiValueMap<String, String>();

}
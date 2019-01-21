package org.snowman.keycloak.utils;

import java.security.Principal;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class SecurityUtils {

	private static ObjectMapper objectMapper = new ObjectMapper();
	
	static {
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	}

	public static String getAccessTokenPayload(Principal principal) {
		if (principal instanceof KeycloakPrincipal) {
			KeycloakSecurityContext securityContext = ((KeycloakPrincipal) principal).getKeycloakSecurityContext();
			try {
				return objectMapper.writeValueAsString(securityContext.getToken());
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}

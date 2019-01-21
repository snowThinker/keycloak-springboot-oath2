### Instructions
~~~
1、Create realm in the Keycloak
2、Add client under realm instance
3、Add Role and user under realm instance
~~~

#### application.properties config guide
~~~
# Keycloak Server Address
keycloak.auth-server-url=http://localhost:8080/auth
# Keycloak Realm Name
keycloak.realm=bookstore
# Keycloak Clients Name
keycloak.resource=client1
# Keycloak Client Secret
keycloak.credentials.secret=552b0f67-8f11-48ce-964a-9b4471af88a1
keycloak.use-resource-role-mappings=true
keycloak.principal-attribute=preferred_username

# Client Customized Role
keycloak.security-constraints[0].authRoles[0]=user
#
keycloak.security-constraints[0].securityCollections[0].patterns[0]=/products/*
~~~
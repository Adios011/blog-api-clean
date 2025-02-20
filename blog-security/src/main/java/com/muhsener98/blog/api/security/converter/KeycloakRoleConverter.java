package com.muhsener98.blog.api.security.converter;


import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {


    @Override
    @SuppressWarnings("unchecked")
    public Collection<GrantedAuthority> convert(Jwt source) {
        Map<String,Object>  realmAccess = ((Map<String, Object>) source.getClaims().get("realm_access"));
        if(realmAccess == null || realmAccess.isEmpty())
            return Collections.emptyList();

        return ((List<String>) realmAccess.get("roles")).stream()
                .map(roleName -> "ROLE_" + roleName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }
}

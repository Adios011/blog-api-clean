package com.muhsener98.blog.api.security.adapter;

import com.muhsener98.blog.api.domain.port.security.AuthenticationRequiredException;
import com.muhsener98.blog.api.domain.port.security.SecurityOutputPort;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SpringSecurityAdapter implements SecurityOutputPort {
    @Override
    public boolean hasRole(String role) {
        return getAuthentication().getAuthorities().stream()
                .map(granted -> granted.getAuthority().replaceFirst("ROLE_", ""))
                .anyMatch(role::equalsIgnoreCase);

    }

    @Override
    public UUID currentUserId() {
        return UUID.fromString(getAuthentication().getName());
    }


    private Authentication getAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || (authentication instanceof AnonymousAuthenticationToken))
            throw new AuthenticationRequiredException();

        return authentication;
    }
}

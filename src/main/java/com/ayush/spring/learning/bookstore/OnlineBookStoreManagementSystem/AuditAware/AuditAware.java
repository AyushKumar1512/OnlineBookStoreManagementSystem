package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.AuditAware;

import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Utils.CurrentUser;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAware")
public class AuditAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        String username = CurrentUser.getCurrentUsername();
        return Optional.ofNullable(username);
    }
}

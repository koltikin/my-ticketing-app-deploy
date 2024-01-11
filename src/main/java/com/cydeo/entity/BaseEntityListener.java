package com.cydeo.entity;


import com.cydeo.entity.common.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class BaseEntityListener {

    @PrePersist
    protected void onPrePersist(BaseEntity baseEntity){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        baseEntity.setInsertDateTime(LocalDateTime.now());
        baseEntity.setLastUpdateDateTime(LocalDateTime.now());

        if (authentication != null && !authentication.getName().equals("anonymousUser")){
            Object principal = authentication.getPrincipal();
            baseEntity.setInsertUserId(((UserPrincipal) principal).getId());
            baseEntity.setLastUpdateUserId(((UserPrincipal) principal).getId());
        }
    }
    @PreUpdate
    private void onPreUpdate(BaseEntity baseEntity){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        baseEntity.setLastUpdateDateTime(LocalDateTime.now());

        if (authentication != null && !authentication.getName().equals("anonymousUser")){
            Object principal = authentication.getPrincipal();
            baseEntity.setLastUpdateUserId(((UserPrincipal) principal).getId());
        }
    }


}

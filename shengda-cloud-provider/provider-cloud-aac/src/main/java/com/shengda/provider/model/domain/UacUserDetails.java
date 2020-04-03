package com.shengda.provider.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shengda.vo.RoleVo;
import com.shengda.vo.UserVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author takesi
 * @date 2020-04-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UacUserDetails extends UserVo implements UserDetails {

    private static final long serialVersionUID = 4354033151322184768L;

    private Set<String> permissions;

    private List<RoleVo> roles;

    public UacUserDetails() {
    }

    public UacUserDetails(List<RoleVo> roles) {
        this.roles = roles;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new HashSet<>();
        if (!CollectionUtils.isEmpty(this.getRoles())) {
            this.getRoles().parallelStream().forEach(role -> collection.add(new SimpleGrantedAuthority(role.getCode())));
        }
        return collection;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !super.getIsDel();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return super.getEnabled();
    }
}

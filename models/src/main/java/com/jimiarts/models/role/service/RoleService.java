package com.jimiarts.models.role.service;

import com.jimiarts.models.role.entity.Role;
import com.jimiarts.models.role.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public void createRole(Role role) {
        roleRepository.save(role);
    }

    public Role findRoleByName(String roleName) {
        return roleRepository.findRoleByName(roleName);
    }
}

package com.jimiarts.models.role.service;

import com.jimiarts.models.member.entity.Member;
import com.jimiarts.models.role.entity.Role;
import com.jimiarts.models.role.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public void createRole(Role role) {
        roleRepository.save(role);
    }

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public Role findRoleByName(Role.RoleType roleName) {
        return roleRepository.findRoleByName(roleName.toString());
    }

}

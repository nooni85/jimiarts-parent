package com.jimiarts.models.role.entity;

import com.jimiarts.models.BaseEntity;
import com.jimiarts.models.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity {
    public enum RoleType {
        ADMIN("ADMIN"),
        STAFF("STAFF"),
        SELECTOR("SELECTOR");

        private final String roleType;

        RoleType(String roleType) {
            this.roleType = roleType;
        }

        @Override
        public String toString() {
            return roleType;
        }
    }

    @Id
    @SequenceGenerator(name = "ROLE_SEQ", sequenceName = "ROLE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_SEQ")
    Long id;

    @Column(unique = true)
    String roleName;

    @ManyToMany(mappedBy = "roles")
    List<Member> members;
}


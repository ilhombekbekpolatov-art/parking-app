package com.smart.parking.entity;

import com.smart.parking.entity.constants.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements UserDetails {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String firstname;
        private String lastname;

        @Column(unique = true, nullable = false)
        private String phoneNumber;

        @Column(nullable = false)
        private String password;

        private Boolean isDeleted = false;

        @Enumerated(EnumType.STRING)
        private Role role;

        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
        private List<Token> tokens;

        private Boolean isNonLocked = true;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return role.getAuthorities();
        }

        @Override public String getUsername() { return phoneNumber; }
        @Override public boolean isAccountNonExpired() { return true; }
        @Override public boolean isAccountNonLocked() { return isNonLocked; }
        @Override public boolean isCredentialsNonExpired() { return true; }
        @Override public boolean isEnabled() { return true; }
    }

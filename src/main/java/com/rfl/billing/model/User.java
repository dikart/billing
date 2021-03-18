package com.rfl.billing.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "users_unique_email_idx")})
public class User extends AbstractBaseEntity {

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "inn_kpp")
    private String inn_kpp;

    @Column(name = "password", nullable = false)
    @NotBlank
    private String password;

    @Column(name = "registered", nullable = false)
    @NotNull
    private Date registered = new Date();

    @Column(name = "enabled", nullable = false)
    private boolean enabled = true;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role"}, name = "user_roles_idx")})
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User(Integer id, String name, String email, String password, Role role, Role... roles) {
        this(id, name, email, null, null, null, password, new Date(), true, EnumSet.of(role, roles));
    }

    public User(Integer id, String name, String email, String phone, String address, String inn_kpp, String password,
                Date registered, boolean enabled, Set<Role> roles) {
        super(id);
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.inn_kpp = inn_kpp;
        this.password = password;
        this.registered = registered;
        this.enabled = enabled;
        setRoles(roles);
    }

    public User(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getAddress(), user.getInn_kpp(),
                user.getPassword(), user.getRegistered(), user.isEnabled(), user.getRoles());
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ? EnumSet.noneOf(Role.class) : EnumSet.copyOf(roles);
    }
}

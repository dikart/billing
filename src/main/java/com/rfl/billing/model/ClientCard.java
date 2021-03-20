package com.rfl.billing.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "clients")
@NoArgsConstructor
@Getter
@Setter
public class ClientCard extends AbstractBaseEntity {
    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone", nullable = false)
    @NotBlank
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "comment")
    private String comment;

}

package com.example.userregistration.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @Column
    private String uuid;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;

    @Column
    private String token;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Phone> phones;
}

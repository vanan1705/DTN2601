package com.vti.testing.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)// auto_increment
    private Integer id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "full_name")
    private String fullName;

}

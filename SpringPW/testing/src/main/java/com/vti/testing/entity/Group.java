package com.vti.testing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "`group`")
@NoArgsConstructor
@AllArgsConstructor
public class Group {

    @Id // khoa chinh
    @Column(name = "group_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)// auto_increment
    private Integer id;

    @Column(name = "group_name", nullable = false, unique = true, length = 100)
    private String name;

    @ManyToMany
    @JoinColumn(name = "creator_id")
    private Account creator;

    @Column(columnDefinition = "datetime default CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

}

package com.vti.testing.entity;

import com.vti.testing.enums.PositionName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "position")
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    @Id // khoa chinh
    @Column(name = "position_id")// đang trỏ tới column department_id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// auto_increment
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "position_name", nullable = false) // not null unique, 100 kí tự
    private PositionName name;
}

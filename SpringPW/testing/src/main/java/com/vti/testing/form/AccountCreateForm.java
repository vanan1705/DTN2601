package com.vti.testing.form;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreateForm {

    private String email;
    private String userName;
    private String fullName;
    private Integer departmentId;
    private Integer positionId;
}

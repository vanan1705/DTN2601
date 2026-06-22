package com.vti.testing.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountSearchForm {

    private String email;
    private String userName;
    private String fullName;
    private String departmentName;
    private String positionName;
}

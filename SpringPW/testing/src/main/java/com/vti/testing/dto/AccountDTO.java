package com.vti.testing.dto;

import com.vti.testing.entity.Account;
import com.vti.testing.entity.Department;
import com.vti.testing.entity.Position;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private String email;
    private String userName;
    private String fullName;
    private String departmentName;
    private String positionName;
    private Date createDate;

}

package com.dbh.entity;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Employee {

    private int employeeId;
    private String name;
    private String email;
    private String password;
}
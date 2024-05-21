package com.dbh.service;

import com.dbh.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {

    List<Employee> findAll(int offset, int recordPerPage) throws SQLException;

    boolean save(Employee employee) throws SQLException;

    boolean update(Employee employee) throws SQLException;

    boolean delete(int id) throws SQLException;

    Employee findById(int id) throws SQLException;

    int count() throws SQLException;
}
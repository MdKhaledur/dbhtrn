package com.dbh.dao;

import com.dbh.entity.Employee;

import java.util.List;
import java.sql.SQLException;

public interface EmployeeDAO {

    List<Employee> findAll(int offset, int recordPerPage) throws SQLException;

    boolean save(Employee employee) throws SQLException;

    boolean update(Employee employee) throws SQLException;

    boolean delete(int id) throws SQLException;

    Employee findById(int id) throws SQLException;

    int count() throws SQLException;
}
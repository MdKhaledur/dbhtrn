package com.dbh.service.impl;

import com.dbh.service.EmployeeService;
import com.dbh.dao.EmployeeDAO;
import com.dbh.entity.Employee;

import java.util.List;
import java.sql.SQLException;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll(int offset, int recordPerPage) throws SQLException {
        return employeeDAO.findAll(offset, recordPerPage);
    }

    @Override
    public boolean save(Employee employee) throws SQLException {
        return employeeDAO.save(employee);
    }

    @Override
    public boolean update(Employee employee) throws SQLException {
        return employeeDAO.update(employee);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return employeeDAO.delete(id);
    }

    @Override
    public Employee findById(int id) throws SQLException {
        return employeeDAO.findById(id);
    }

    @Override
    public int count() throws SQLException {
        return employeeDAO.count();
    }
}
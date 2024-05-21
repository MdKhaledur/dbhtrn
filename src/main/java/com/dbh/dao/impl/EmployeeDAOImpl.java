package com.dbh.dao.impl;

import com.dbh.dao.EmployeeDAO;
import com.dbh.entity.Employee;
import com.dbh.utils.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public List<Employee> findAll(int offset, int recordPerPage) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        Connection connection = DatabaseConfig.getconnection();
        String sql = "SELECT * FROM employee ORDER BY  employeeId ASC LIMIT ?,?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, offset);
        pst.setInt(2, recordPerPage);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Employee employee = new Employee();
            employee.setEmployeeId(rs.getInt("employeeId"));
            employee.setName(rs.getString("name"));
            employee.setEmail(rs.getString("email"));
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public boolean save(Employee employee) throws SQLException {
        Connection connection = DatabaseConfig.getconnection();
        String sql = "INSERT INTO employee(name, email, password) VALUES (?,?,?)";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, employee.getName());
        pst.setString(2, employee.getEmail());
        pst.setString(3, employee.getPassword());
        return pst.executeUpdate() > 0;
    }

    @Override
    public boolean update(Employee employee) throws SQLException {
        Connection connection = DatabaseConfig.getconnection();
        String sql = "UPDATE employee SET name=?,email=?,password=? where employeeId=?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, employee.getName());
        pst.setString(2, employee.getEmail());
        pst.setString(3, employee.getPassword());
        pst.setInt(4, employee.getEmployeeId());
        return pst.executeUpdate() > 0;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        Connection connection = DatabaseConfig.getconnection();
        String sql = "DELETE FROM employee WHERE employeeId=?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, id);
        return pst.executeUpdate() > 0;
    }

    @Override
    public Employee findById(int id) throws SQLException {
        Employee employee = null;
        Connection connection = DatabaseConfig.getconnection();
        String sql = "SELECT * FROM employee WHERE employeeId=?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int employeeId = rs.getInt("employeeId");
            String employeeName = rs.getString("name");
            String employeeEmail = rs.getString("email");
            String employeePassword = rs.getString("password");
            employee = new Employee(employeeId, employeeName, employeeEmail, employeePassword);
        }
        return employee;
    }

    @Override
    public int count() throws SQLException {
        int count = 0;
        Connection connection = DatabaseConfig.getconnection();
        String sql = "SELECT COUNT(*) AS total FROM employee";
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            count = rs.getInt("total");
        }
        return count;
    }
}
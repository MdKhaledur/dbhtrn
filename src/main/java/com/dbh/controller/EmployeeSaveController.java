package com.dbh.controller;

import com.dbh.service.EmployeeService;
import com.dbh.service.impl.EmployeeServiceImpl;
import com.dbh.dao.EmployeeDAO;
import com.dbh.dao.impl.EmployeeDAOImpl;
import com.dbh.entity.Employee;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

import java.io.Serial;
import java.io.IOException;

@WebServlet("/save")

public class EmployeeSaveController extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    private EmployeeService employeeService;

    public EmployeeSaveController() {
    }

    @Override
    public void init() throws ServletException {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        this.employeeService = new EmployeeServiceImpl(employeeDAO);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("/pages/save.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            /*String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            Employee employee = new Employee();
            employee.setName(name);
            employee.setEmail(email);
            employee.setPassword(password);*/

            Employee employee = Employee.builder()
                    .name(request.getParameter("name"))
                    .email(request.getParameter("email"))
                    .password(request.getParameter("password"))
                    .build();
            employeeService.save(employee);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        response.sendRedirect("/");
    }
}
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

@WebServlet("/details")

public class EmployeeDetailsController extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    private EmployeeService employeeService;

    public EmployeeDetailsController() {
    }

    @Override
    public void init() throws ServletException {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        this.employeeService = new EmployeeServiceImpl(employeeDAO);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int employeeId = Integer.parseInt(request.getParameter("id"));
            Employee employee = employeeService.findById(employeeId);
            request.setAttribute("employee", employee);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        RequestDispatcher view = request.getRequestDispatcher("/pages/details.jsp");
        view.forward(request, response);
    }
}
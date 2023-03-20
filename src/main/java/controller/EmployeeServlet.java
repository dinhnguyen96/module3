package controller;

import model.Department;
import model.Employee;
import service.DepartmentService;
import service.EmployeeService;
import service.impl.DepartmentServiceImpl;
import service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/employees")
public class EmployeeServlet extends HttpServlet
{

    private EmployeeService employeeService = new EmployeeServiceImpl();

    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null)
        {
            action = "";
        }
        switch (action)
        {
            case "add":
                req.setAttribute("departments", departmentService.findAll());
                req.getRequestDispatcher("addemployee.jsp").forward(req,resp);
                break;
            case "edit":
                Long id = Long.parseLong(req.getParameter("id"));
                Employee employee = employeeService.findById(id);
                req.setAttribute("id", employee.getId());
                req.setAttribute("employeeName", employee.getEmployeeName());
                req.setAttribute("employeeAddress", employee.getEmployeeAddress());
                req.setAttribute("employeeCode", employee.getEmployeeCode());
                req.setAttribute("employeeDepartment", employee.getEmployeeDepartment());
                req.setAttribute("departments", departmentService.findAll());
                req.setAttribute("employeeSalary", employee.getEmployeeSalary());
                req.getRequestDispatcher("editemployee.jsp").forward(req,resp);
                break;
            case "delete":
                Long employeeId = Long.parseLong(req.getParameter("id"));
                employeeService.removeEmployee(employeeId);
                resp.sendRedirect("/employees");
                break;
            default:
                req.setAttribute("employees",employeeService.findAll());
                req.getRequestDispatcher("employees.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null)
        {
            action = "";
        }
        switch (action)
        {
            case "add":
                addEmployee(req,resp);
                resp.sendRedirect("/employees");
                break;
            case "edit":
                editEmployee(req,resp);
                resp.sendRedirect("/employees");
                break;
        }

    }
    public void addEmployee(HttpServletRequest request, HttpServletResponse response)
    {
        String employeeCode = request.getParameter("employeeCode");
        String employeeName = request.getParameter("employeeName");
        String employeeAddress = request.getParameter("employeeAddress");
        double employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));
        Department department = departmentService.findById(Long.parseLong(request.getParameter("department_id")));
        Employee employee = new Employee(employeeCode, employeeName, employeeAddress, employeeSalary, department);
        employeeService.addEmployee(employee);
    }
    public void editEmployee(HttpServletRequest req, HttpServletResponse res) {
        Long id = Long.parseLong(req.getParameter("id"));
        Employee employee = employeeService.findById(id);
        employee.setEmployeeCode(req.getParameter("employeeCode"));
        employee.setEmployeeName(req.getParameter("employeeName"));
        employee.setEmployeeAddress(req.getParameter("employeeAddress"));
        employee.setEmployeeSalary(Double.parseDouble(req.getParameter("employeeSalary")));
        Department department = departmentService.findById(Long.parseLong(req.getParameter("department_id")));
        employee.setEmployeeDepartment(department);
        employeeService.updateEmployee(employee);

    }
}

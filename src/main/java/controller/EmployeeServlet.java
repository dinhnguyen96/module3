package controller;

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
                req.setAttribute("departments", departmentService.findAll());
                req.getRequestDispatcher("addemployee.jsp").forward(req,resp);
                break;
        }

    }
    public void addEmployee(HttpServletRequest request, HttpServletResponse response)
    {
        String action = request.getParameter("action");
        if (action == null)
        {
            action = "";
        }
    }
}

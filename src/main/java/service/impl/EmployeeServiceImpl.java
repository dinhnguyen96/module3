package service.impl;

import connection.ConnectionDatabase;
import model.Department;
import model.Employee;
import service.EmployeeService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService
{

    private Connection connection;
    @Override
    public List<Employee> findAll()
    {
        connection = ConnectionDatabase.getConnection();
        if (connection != null)
        {
            try {
                StringBuilder s = new StringBuilder();
                s.append("select * from employee join department");
                s.append(" ");
                s.append("on department.id = employee.department_id");
                PreparedStatement p = connection.prepareStatement(s.toString());
                List<Employee> employees = new ArrayList<>();
                ResultSet rs = p.executeQuery();
                while (rs.next())
                {
                    Long employee_id = rs.getLong("employee.id");
                    String employeeCode = rs.getString("employeeCode");
                    String employeeName = rs.getString("employeeName");
                    String employeeAddress = rs.getString("employeeAddress");
                    double employeeSalary = rs.getDouble("employeeSalary");

                    Long department_id = rs.getLong("department.id");
                    String departmentName = rs.getString("departmentName");

                    Department department = new Department(department_id, departmentName);
                    Employee employee = new Employee(employee_id, employeeCode, employeeName, employeeAddress, employeeSalary, department);
                    employees.add(employee);
                }
                return employees;

            }
            catch (SQLException e)
            {
                System.out.println("Query Error");
            }
            finally {
                try{
                    connection.close();
                }
                catch (SQLException e)
                {
                    System.out.println("Close Error");
                }
            }
        }

        return null;
    }

    @Override
    public Employee findById(Long id)
    {
        connection = ConnectionDatabase.getConnection();
        if (connection != null)
        {
            try
            {
                StringBuilder s = new StringBuilder();
                s.append("Select * from employee join department");
                s.append(" ");
                s.append("on employee.department_id = department.id");
                s.append(" ");
                s.append("where employee.id = ?");
                PreparedStatement p = connection.prepareStatement(s.toString());
                p.setLong(1, id);
                ResultSet rs = p.executeQuery();
                if (rs.next())
                {
                    String employeeCode = rs.getString("employeeCode");
                    String employeeName = rs.getString("employeeName");
                    String employeeAddress = rs.getString("employeeAddress");
                    double employeeSalary = rs.getDouble("employeeSalary");
                    Long department_id = rs.getLong("department.id");
                    String departmentName = rs.getString("departmentName");
                    Department department = new Department(department_id, departmentName);
                    Employee employee = new Employee(id, employeeCode, employeeName, employeeAddress, employeeSalary, department);

                    return employee;
                }
            }
            catch (SQLException e)
            {
                System.out.println("Query Error");
            }
        }
        return null;
    }

    @Override
    public int addEmployee(Employee e)
    {
        int result = 0;
        connection = ConnectionDatabase.getConnection();
        if (connection != null)
        {
            try
            {
                StringBuilder s = new StringBuilder();
                s.append("insert into employee(employeeCode,employeeName,employeeAddress,employeeSalary,department_id)");
                s.append(" ");
                s.append("values(?,?,?,?,?)");
                PreparedStatement p = connection.prepareStatement(s.toString());
                p.setString(1,e.getEmployeeCode());
                p.setString(2, e.getEmployeeName());
                p.setString(3, e.getEmployeeAddress());
                p.setDouble(4, e.getEmployeeSalary());
                p.setLong(5, e.getEmployeeDepartment().getId());
                result = p.executeUpdate();

            }
            catch (SQLException ex)
            {
                System.out.println("Query Error");
            }
        }
        return result;
    }

    @Override
    public int updateEmployee(Employee e)
    {
        int result = 0;
        connection = ConnectionDatabase.getConnection();
        if (connection != null)
        {
            try
            {
                StringBuilder s = new StringBuilder();
                s.append("update employee set employeeCode = ?, employeeName = ?, employeeAddress = ?, employeeSalary = ?, department_id = ? ");
                s.append(" ");
                s.append("where id = ?");
                PreparedStatement p = connection.prepareStatement(s.toString());
                p.setString(1,e.getEmployeeCode());
                p.setString(2, e.getEmployeeName());
                p.setString(3, e.getEmployeeAddress());
                p.setDouble(4, e.getEmployeeSalary());
                p.setLong(5, e.getEmployeeDepartment().getId());
                p.setLong(6, e.getId());
                result = p.executeUpdate();

            }
            catch (SQLException ex)
            {
                System.out.println("Query Error");
            }
        }
        return result;
    }

    @Override
    public int removeEmployee(Long id)
    {
        int result = 0;
        connection = ConnectionDatabase.getConnection();
        if (connection != null) {
            try
            {
                StringBuilder s = new StringBuilder();
                s.append("delete from employee");
                s.append(" ");
                s.append("where id = ?");
                PreparedStatement p = connection.prepareStatement(s.toString());
                p.setLong(1, id);
                result = p.executeUpdate();

            }
            catch (SQLException ex)
            {
                System.out.println("Query Error");
            }
        }
        return result;
    }

    @Override
    public List<Employee> searchEmployeeByName(String name)
    {
        connection = ConnectionDatabase.getConnection();
        if (connection != null)
        {
            try
            {
                StringBuilder s = new StringBuilder();
                s.append("Select * from employee");
                s.append(" ");
                s.append("where employeeName like '%?'");
                PreparedStatement p = connection.prepareStatement(s.toString());
                p.setString(1, name);
                ResultSet rs = p.executeQuery();
                List<Employee> employees = new ArrayList<>();
                while (rs.next())
                {
                    Long employee_id = rs.getLong("employee.id");
                    String employeeCode = rs.getString("employeeCode");
                    String employeeName = rs.getString("employeeName");
                    String employeeAddress = rs.getString("employeeAddress");
                    double employeeSalary = rs.getDouble("employeeSalary");

                    Long department_id = rs.getLong("department.id");
                    String departmentName = rs.getString("departmentName");

                    Department department = new Department(department_id, departmentName);
                    Employee employee = new Employee(employee_id, employeeCode, employeeName, employeeAddress, employeeSalary, department);
                    employees.add(employee);
                }
                return employees;


            }
            catch (SQLException e)
            {
                System.out.println("Query Error ");
            }
        }
        return null;
    }
}

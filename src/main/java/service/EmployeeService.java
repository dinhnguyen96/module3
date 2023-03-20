package service;

import model.Employee;

import java.util.List;

public interface EmployeeService {


    List<Employee> findAll();

    Employee findById(Long id);

    int addEmployee(Employee e);

    int updateEmployee(Employee e);

    int removeEmployee(Long employeeId);

    List<Employee> searchEmployeeByName(String name);


}

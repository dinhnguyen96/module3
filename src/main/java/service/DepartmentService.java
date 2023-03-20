package service;

import model.Department;

import java.util.List;

public interface DepartmentService {


    List<Department> findAll();

    Department findById(Long id);

}

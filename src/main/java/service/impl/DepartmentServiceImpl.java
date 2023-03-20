package service.impl;

import connection.ConnectionDatabase;
import model.Department;
import service.DepartmentService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    private Connection connection;
    @Override
    public List<Department> findAll()
    {
        connection = ConnectionDatabase.getConnection();
        if (connection != null)
        {
            try
            {
                String sql = "select * from department";
                PreparedStatement p = connection.prepareStatement(sql);
                List<Department> departmentList = new ArrayList<>();
                ResultSet rs = p.executeQuery();
                while (rs.next())
                {
                    Long id = rs.getLong("id");
                    String departmentName = rs.getString("departmentName");
                    Department department = new Department(id, departmentName);
                    departmentList.add(department);
                }
                return departmentList;
            }
            catch (SQLException e)
            {
                System.out.println("Query Error");
            }
        }
        return null;
    }
}

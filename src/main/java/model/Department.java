package model;
public class Department
{
    private Long id;

    private String departmentName;

    public Department(Long id, String departmentName)
    {
        this.id = id;
        this.departmentName = departmentName;
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}

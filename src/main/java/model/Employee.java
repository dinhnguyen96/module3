package model;

public class Employee
{
    private Long id;

    private String employeeCode;

    private String employeeName;

    private String employeeAddress;

    private double employeeSalary;

    private Department employeeDepartment;

    public Employee(Long id, String employeeCode, String employeeName, String employeeAddress, double employeeSalary, Department employeeDepartment) {
        this.id = id;
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.employeeSalary = employeeSalary;
        this.employeeDepartment = employeeDepartment;
    }

    public Employee(String employeeCode, String employeeName, String employeeAddress, double employeeSalary, Department employeeDepartment) {
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.employeeSalary = employeeSalary;
        this.employeeDepartment = employeeDepartment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public Department getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(Department employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }
}

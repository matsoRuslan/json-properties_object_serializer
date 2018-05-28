package com.matso;

public class Employee {
    private int id;
    private String name;
    private int age;
    private String designation;
    private Compensation compensation;

    static Employee getEmployee() {
        Employee employee = new Employee();
        employee.setId(100);
        employee.setName("Ruslan");
        employee.setAge(23);
        employee.setDesignation("Developer");

        Compensation compensation = new Compensation();
        compensation.setCurrency('$');
        compensation.setSalary(3000);
        TaxValue taxValue = new TaxValue();
        taxValue.setCurrency('$');
        taxValue.setValue(300);
        compensation.setTaxValue(taxValue);
        employee.setCompensation(compensation);
        return employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Compensation getCompensation() {
        return this.compensation;
    }

    public void setCompensation(Compensation compensation) {
        this.compensation = compensation;
    }

    @Override
    public String toString() {
        return String
                .format("Employee: [id: %s, name: %s, age: %s, designation: %s, compensation: %s ]",
                        id, name, age, designation, compensation);
    }
}

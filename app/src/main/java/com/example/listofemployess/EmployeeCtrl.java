package com.example.listofemployess;

public class EmployeeCtrl {
    private EmployeeModel model;
    private EmployeeView view;

    public EmployeeCtrl(EmployeeModel model, EmployeeView view) {
        this.model = model;
        this.view = view;
    }

    public void addEmployee(String name, String age, String salary, String position) {
        model.setName(name);
        model.setAge(age);
        model.setSalary(salary);
        model.setPosition(position);


        String employeeInfo = "Name: " + name + ", Age: " + age + ", Salary: " + salary + ", Position: " + position;


        view.displayEmployee(employeeInfo);


        view.clearFields();
    }
}

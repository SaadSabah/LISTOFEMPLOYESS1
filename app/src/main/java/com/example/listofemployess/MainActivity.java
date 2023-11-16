package com.example.listofemployess;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity implements EmployeeView {
    private EditText nameEditText;
    private EditText ageEditText;
    private EditText salaryEditText;
    private EditText positionEditText;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private EmployeeCtrl controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.Employee_Name);
        ageEditText = findViewById(R.id.Employee_Age);
        salaryEditText = findViewById(R.id.Employee_Salary);
        positionEditText = findViewById(R.id.Employee_Position);
        listView = findViewById(R.id.My_list);

        controller = new EmployeeCtrl(new EmployeeModel(), this);


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
    }

    public void add_Employee(View view) {
        String name = nameEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String salary = salaryEditText.getText().toString();
        String position = positionEditText.getText().toString();


        controller.addEmployee(name, age, salary, position);
    }

    @Override
    public void clearFields() {
        nameEditText.setText("");
        ageEditText.setText("");
        salaryEditText.setText("");
        positionEditText.setText("");
    }

    @Override
    public void displayEmployee(String employeeInfo) {
        adapter.add(employeeInfo);
        adapter.notifyDataSetChanged();
    }
}

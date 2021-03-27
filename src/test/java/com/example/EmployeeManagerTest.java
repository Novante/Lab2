package com.example;

import EmployeeMock.EmployeeRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class EmployeeManagerTest {

    private List<Employee> employeeList;

    private void setupDatabase() {
        employeeList = new ArrayList<>();
        employeeList.add(new Employee("1", 200));
        employeeList.add(new Employee("2", 157));
        employeeList.add(new Employee("3", 1337));
    }

    @Test
    void findFirstEmployee() {

        setupDatabase();
        EmployeeRepositoryImpl mockRepo = new EmployeeRepositoryImpl(employeeList);

        var result = mockRepo.findAll().get(0);

        Assertions.assertEquals("1", result.getId());
        Assertions.assertEquals(200, result.getSalary());
    }

    @Test
    void saveNewEmployee() {
        setupDatabase();
        EmployeeRepositoryImpl mockRepo = new EmployeeRepositoryImpl(employeeList);

        mockRepo.save(new Employee("4", 288));

        Assertions.assertTrue(mockRepo.saveWasCalled);
    }


}
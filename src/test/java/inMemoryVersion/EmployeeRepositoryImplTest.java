package inMemoryVersion;

import com.example.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class EmployeeRepositoryImplTest {

    @Test
    void findAllEmployees() {
        EmployeeRepositoryImpl empRepo = new EmployeeRepositoryImpl();

        Assertions.assertEquals(3, empRepo.findAll().size());
    }

    @Test
    void saveExistingEmployees() {
        EmployeeRepositoryImpl empRepo = new EmployeeRepositoryImpl();
        Employee e = empRepo.save(new Employee("1", 200));

        Assertions.assertTrue(empRepo.replaceExistingEmployee);

    }

    @Test
    void saveNonExistingEmployee() {
        EmployeeRepositoryImpl empRepo = new EmployeeRepositoryImpl();
        empRepo.save(new Employee("5", 200));

        Assertions.assertFalse(empRepo.replaceExistingEmployee);
    }

    @Test
    void saveInvalidEmployee() {
        EmployeeRepositoryImpl empRepo = new EmployeeRepositoryImpl();

        Assertions.assertNull(empRepo.save(new Employee(null, 200)));
        Assertions.assertNull(empRepo.save(null));
    }


    }

package com.testing.testing;

import com.testing.testing.entity.Employees;
import com.testing.testing.entity.repository.EmployeeRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class TestingApplicationTests {



    @Autowired
    private EmployeeRepository employeeRepository;




//    save record in database

    @Test
    void saveRecord() {
        Employees emp = new Employees();
        emp.setFirstName("Bapun");
        emp.setLastName("das");
        emp.setEmail("panda@gmail.com"); // id 2 is created if we create the same dat after delete
//         because the 1L id is already deleted
        emp.setMobile("9337335098");
        employeeRepository.save(emp);

    }


// to delete Record by Id

    @Test
    void deleteRecordById() {

       employeeRepository.deleteById(1L);


    }

//    get All Record By Id

    @Test
    void getRecordById() {
        Optional<Employees> oEmp = employeeRepository.findById(2L);
        if (oEmp.isPresent()) {

            Employees employees = oEmp.get();
            System.out.println(employees.getEmail());
            System.out.println(employees.getFirstName());
            System.out.println(employees.getLastName());
            System.out.println(employees.getMobile());
            System.out.println("Hello");


        }

    }


//    getAllRecords

    @Test
    void getAllRecords(){

        Iterable<Employees> iterable = employeeRepository.findAll();

        for (Employees allEmployee:iterable) {

            System.out.println(allEmployee.getId());
            System.out.println(allEmployee.getFirstName());
            System.out.println(allEmployee.getLastName());
            System.out.println(allEmployee.getMobile());
            System.out.println(allEmployee.getEmail());
        }


    }


//    Count All Record In Database

    @Test
   void countRecords() {

        long count = employeeRepository.count();
        System.out.println(count+" Records In Database");


    }





}

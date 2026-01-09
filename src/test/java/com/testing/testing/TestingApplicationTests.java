package com.testing.testing;

import com.testing.testing.entity.Employees;
import com.testing.testing.entity.repository.EmployeeRepository;
import net.bytebuddy.build.ToStringPlugin;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class TestingApplicationTests {



    @Autowired
    private EmployeeRepository employeeRepository;




//    save record in database

    @Test
    void saveRecord() {
        Employees emp = new Employees();
        emp.setFirstName("bapun");
        emp.setLastName("mishra");
        emp.setEmail("mishra@gmail.com"); // id 2 is created if we create the same dat after delete
//         because the 1L id is already deleted
        emp.setMobile("9337338998");
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
        System.out.println(count+ " Records In Database");


    }


//    Finder Methods


@Test
    void findByEmail() {

    Optional<Employees> oEmp = employeeRepository.findByEmail("mishra@gmail.com");

if (oEmp.isPresent()) {

    Employees employees = oEmp.get();
    System.out.println(employees.getId());
    System.out.println(employees.getFirstName());
    System.out.println(employees.getLastName());
    System.out.println(employees.getMobile());
    System.out.println(employees.getEmail());


} else {

    System.out.println("No Record Found");

}



}


// record find based on mobile
    @Test
    void findByMobile() {

        Optional<Employees> oEmp = employeeRepository.findByMobile("9337335590");

        if (oEmp.isPresent()) {

            Employees employees = oEmp.get();

            System.out.println(employees.getId());
            System.out.println(employees.getFirstName());
            System.out.println(employees.getLastName());
            System.out.println(employees.getMobile());
            System.out.println(employees.getEmail());


        } else  {

            System.out.println("No record Found");

        }





    }


//    Return true or false based on email

    @Test
    void existByEmail() {

        boolean result = employeeRepository.existsByEmail("mishra@gmail.com");

        if (result) {
            System.out.println("record is found");
        } else {

            System.out.println("record not found");

        }


    }



//     Return true or false based on mobile

    @Test
    void existByMobile() {

        boolean result = employeeRepository.existsByMobile("9337335593");
        if (result) {
            System.out.println("Record exist By Mobile");
        } else {

            System.out.println("record Not Found");

        }
    }


@Test
void countByEmail() {

    long count = employeeRepository.countByEmail("mishra@gmail.com");
    System.out.println(count); // to check how many employee exist in an email


}




//  count record based on mobile number
    
    @Test
    void countByMobile() {

        long count = employeeRepository.countByMobile("9337338998");

        System.out.println(count);
        
    }
    
//     find by first name list of all record

    @Test
    void findByFirstName() {

        List<Employees> allEmp = employeeRepository.findByFirstNameContaining("bapun"); // get all
//        record with the first name
        for (Employees employees : allEmp) {

            System.out.println(employees.getId());
            System.out.println(employees.getFirstName());
            System.out.println(employees.getLastName());
            System.out.println(employees.getMobile());
            System.out.println(employees.getEmail());


        }



    }
    
//    find all record based on name start with "b"

    @Test
    void contentStartLetter() {

        List<Employees> allEmp = employeeRepository.findByFirstNameStartingWith("b");

        for (Employees employees : allEmp) {

            System.out.println(employees.getFirstName());
            System.out.println(employees.getLastName());
            System.out.println(employees.getId());
            System.out.println(employees.getMobile());


        }


    }



//    get all record based on ending later of first name
    
    @Test
    void contentEndLetter() {

        List<Employees> allEmp = employeeRepository.findByFirstNameEndingWith("n");
        for (Employees employees : allEmp) {

            System.out.println(employees.getFirstName());
            System.out.println(employees.getLastName());
            System.out.println(employees.getId());
            System.out.println(employees.getMobile());


        }


    }


//    Jpql query method


//    searchBy Email
@Test
   void searchByEmail() {

    Optional<Employees> oEmp = employeeRepository.searchByEmail("sahu@gmail.com");

    if (oEmp.isPresent()) {

        Employees employees = oEmp.get();
        System.out.println(employees.getId());
        System.out.println(employees.getEmail());
        System.out.println(employees.getFirstName());
        System.out.println(employees.getLastName());
        System.out.println(employees.getMobile());

    } else {
        System.out.println("Result not Found");
    }


}



// searchByMobile using jpql

    @Test
    void searchByMobile() {


        Optional<Employees> oEmp = employeeRepository.searchByMobile("9337335593");

        if (oEmp.isPresent()) {

            Employees employees = oEmp.get();

            System.out.println(employees.getId());
            System.out.println(employees.getEmail());
            System.out.println(employees.getFirstName());
            System.out.println(employees.getLastName());
            System.out.println(employees.getMobile());

        } else {
            System.out.println("No Data Found");
        }




    }




//   searchBy emailAnd mobile jpql
    @Test
    void searchByEmailAndMobile() {
        List<Employees> employees = employeeRepository.searchByEmailAndMobile("mishra@gmail.com", "9337338998"); // two data shuld match from one record

        for (Employees allEmp : employees) {
            System.out.println(allEmp.getLastName());
            System.out.println(allEmp.getFirstName());
            System.out.println(allEmp.getId());
            System.out.println(allEmp.getMobile());
            System.out.println(allEmp.getEmail());


        }


    }


    @Test
    void searchByEmailOrMobile() {
        List<Employees> employees = employeeRepository.searchByEmailOrMobile("933733559" , "mishra@gmail.com");

// At least   one record should match mobile or email
        for (Employees allEmp : employees) {
            System.out.println(allEmp.getLastName());
            System.out.println(allEmp.getFirstName());
            System.out.println(allEmp.getId());
            System.out.println(allEmp.getMobile());
            System.out.println(allEmp.getEmail());


        }




    }


//     Native sql findBy emailAndMobile

    @Test
    void findMyEmailAndMobileUsingSql() {

        List<Employees> employees= employeeRepository.findByEmailAndMobileSql("", "9337335593"); // Match only one record With OR
        for (Employees allEmp : employees) {

            System.out.println(allEmp.getFirstName());
            System.out.println(allEmp.getLastName());
            System.out.println(allEmp.getId());
            System.out.println(allEmp.getMobile());
            System.out.println(allEmp.getEmail());


        }


    }




}

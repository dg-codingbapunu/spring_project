package com.testing.testing.entity.repository;

import com.testing.testing.entity.Employees;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employees,Long> {


    Optional<Employees> findByEmail(String email); // find by emailId
    Optional<Employees> findByMobile(String mobile); // find based on mobile
    boolean existsByEmail(String email); // return true false based on email
//    // mobile
    boolean existsByMobile(String mobile);
    long countByEmail(String email);
    // count record by email id
    long countByMobile(String mobile); // count record based on mobile
    List<Employees> findByFirstNameContaining(String keyword); //  find by first name list of all record
    List<Employees> findByFirstNameStartingWith(String prefix);
    List<Employees> findByFirstNameEndingWith(String suffix);

// jpql query

@Query("select e from Employees e where e.email=:x")
 Optional<Employees> searchByEmail(@Param("x") String email);

@Query("select e from Employees e where e.mobile=:m")
    Optional<Employees> searchByMobile(@Param("m") String mobile);

@Query("select e from Employees e where e.email=:x and e.mobile=:m")
    List<Employees> searchByEmailAndMobile(@Param("x")String email, @Param("m") String mobile);

@Query("select e from Employees e where e.mobile=:m or e.email=:x" )
    List<Employees> searchByEmailOrMobile(@Param("m") String mobile, @Param("x") String email);


// Native Sql

    @Query(value = "select * from Employees where email= ?1 or mobile= ?2", nativeQuery = true) //?1 and ?2 are parameter sequence we can use
//    also  @Query(value = "select * from Employees where email=:email or mobile=:mobile", nativeQuery = true)
    List<Employees> findByEmailAndMobileSql(String email,String mobile);




}

package ru.skypro.lessons.springboot.myemployeeweblibrary.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import ru.skypro.lessons.springboot.myemployeeweblibrary.dto.DepartmentReport;
import ru.skypro.lessons.springboot.myemployeeweblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.myemployeeweblibrary.projections.EmployeeByIdFullInfo;

import java.util.List;
import java.util.Optional;


public interface EmployeeRepository extends CrudRepository<Employee, Integer>, PagingAndSortingRepository<Employee, Integer> {

    @Query(value = "FROM Employee e WHERE e.salary = (SELECT MAX(e2.salary) FROM Employee e2)")
    List<Employee> findEmployeesWithHighestSalary();

    @Query(value = "FROM Employee e "+
            "INNER JOIN Position p " +
            "ON e.position.id = p.id and p.name = :name")
    List<Employee> getAllEmployeesByPosition(@Param("name") String positionName);

    @Query("SELECT new ru.skypro.lessons.springboot.myemployeeweblibrary.projections." +
            "EmployeeByIdFullInfo(e.name , e.salary , p.name) " +
            "FROM Employee e join fetch Position p " +
            "WHERE e.position = p AND e.id=?1")
    Optional<Employee> getEmployeeByIdFullInfo(int id);


    @Query(value = "SELECT new ru.skypro.lessons.springboot.myemployeeweblibrary.dto.DepartmentReport" +
            "( " + "p.name, " + "count(e.id), " + "min(e.salary), " + "max(e.salary), " + "avg(e.salary)) "
            + "from Employee e join fetch Position p " + "where e.position = p " + "group by p.id")
    List<DepartmentReport> getReport();

}


package ru.skypro.lessons.springboot.myemployeeweblibrary.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.lessons.springboot.myemployeeweblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.myemployeeweblibrary.exceptions.IncorrectEmployeeIdException;
import ru.skypro.lessons.springboot.myemployeeweblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.myemployeeweblibrary.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;


    @PostMapping("/")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> editEmployeeById(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO) {
        try {
            employeeService.editEmployeeById(id, employeeDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Throwable t) {
            return new ResponseEntity<>("Некорректный ID сотрудника.", HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/{id}")
    public Object getEmployeeFromDataBase(@PathVariable int id) {
        try {
            return employeeService.getEmployeeById(id);
        } catch (Throwable t) {
            return new ResponseEntity<>("Некорректный ID сотрудника.", HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/{id}")
    public Object deleteEmployeeById(@PathVariable int id) {
        try {
            employeeService.deleteEmployeeById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Throwable t) {
            return new ResponseEntity<>("Некорректный ID сотрудника.", HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/allEmployees")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }


    @GetMapping("/WithHighestSalary")
    public List<EmployeeDTO> getEmployeesWithHighestSalary() {

        return employeeService.getEmployeesWithHighestSalary();}


    @GetMapping("/position")
    public Object getAllEmployeesByPosition(@RequestParam("position") String positionName) {
        try {return employeeService.getAllEmployeesByPosition(positionName);
        } catch (Throwable t) {
            return new ResponseEntity<>("Некорректный ввод должности.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}/fullInfo")
    public Object getEmployeeByIdFullInfo(@PathVariable Integer id) {
        try {
        return employeeService.getEmployeeByIdFullInfo(id);
        } catch (Throwable t) {
            return new ResponseEntity<>("Некорректный ID сотрудника.", HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/page")
    public List<EmployeeDTO> getEmployeeWithPaging(@RequestParam("page") int page) {
        return employeeService.getEmployeesByPage(page);
    }

}

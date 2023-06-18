package ru.skypro.lessons.springboot.myemployeeweblibrary.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.myemployeeweblibrary.dto.DepartmentReport;
import ru.skypro.lessons.springboot.myemployeeweblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.myemployeeweblibrary.exceptions.IncorrectEmployeeIdException;
import java.io.IOException;
import java.util.List;

public interface EmployeeService {


    void addEmployee(EmployeeDTO employeeDTO);

    void editEmployeeById(int id, EmployeeDTO employeeDTO) throws IncorrectEmployeeIdException;

    EmployeeDTO getEmployeeById(int id) throws IncorrectEmployeeIdException;

    void deleteEmployeeById(int id) throws IncorrectEmployeeIdException;

    List<EmployeeDTO> getAllEmployees();

    List<DepartmentReport> getDepartmentReport() throws IOException;

    List<EmployeeDTO> getEmployeesWithHighestSalary();

    List<EmployeeDTO> getAllEmployeesByPosition(String positionName);

    EmployeeDTO getEmployeeByIdFullInfo(int id) throws IncorrectEmployeeIdException;

    List<EmployeeDTO> getEmployeesByPage(int pageIndex);

    void uploadNewEmployeesFromFile (MultipartFile file) throws IOException;


}

package ru.skypro.lessons.springboot.myemployeeweblibrary.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.myemployeeweblibrary.dto.DepartmentReport;
import ru.skypro.lessons.springboot.myemployeeweblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.myemployeeweblibrary.exceptions.IncorrectEmployeeIdException;
import ru.skypro.lessons.springboot.myemployeeweblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.myemployeeweblibrary.repository.EmployeeRepository;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public void addEmployee(EmployeeDTO employeeDTO) {
        employeeRepository.save(employeeDTO.toEmployee());
        logger.info("Was invoked method for create employee " + employeeDTO.toEmployee().toString());
    }

    @Override
    public void editEmployeeById(int id, EmployeeDTO employeeDTO) throws IncorrectEmployeeIdException {
        if (employeeRepository.existsById(id)) {
            Employee employee = employeeDTO.toEmployee();
            employee.setId(id);
            employeeRepository.save(employee);
            logger.info("Was invoked method for edit employee " + employee.toString());
        } else {logger.error("There is no employee with id = " + id, new IncorrectEmployeeIdException("Некорректный ID сотрудника."));
        throw new IncorrectEmployeeIdException("Некорректный ID сотрудника.");}
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) throws IncorrectEmployeeIdException {

        Optional<EmployeeDTO> employeeOptional = employeeRepository.findById(id).map(EmployeeDTO::fromEmployee);
        logger.info("Was invoked method getEmployeeById");

        return employeeOptional.orElseThrow(() -> new IncorrectEmployeeIdException("Некорректный ID сотрудника."));
    }

    @Override
    public void deleteEmployeeById(int id) throws IncorrectEmployeeIdException {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            logger.info("Was invoked method for delete employee with ID " + id);
        } else {logger.error("There is no employee with id = " + id, new IncorrectEmployeeIdException("Некорректный ID сотрудника."));
            throw new IncorrectEmployeeIdException("Некорректный ID сотрудника.");}
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        employeeRepository.findAll().forEach((employeeList::add));
        logger.info("Was invoked method getAllEmployees");
        return employeeList.
                stream().map(EmployeeDTO::fromEmployee)
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> getEmployeesWithHighestSalary() {
        List<Employee> employeeList = employeeRepository.findEmployeesWithHighestSalary();
        logger.info("Was invoked method getEmployeesWithHighestSalary");
        return employeeList
                .stream().map(EmployeeDTO::fromEmployee)
                .collect(Collectors.toList());
    }


    public List<EmployeeDTO> getAllEmployeesByPosition(String positionName) {
        String correctPositionName;
        logger.info("Was invoked method getAllEmployeesByPosition");
        if (getAllEmployees().stream().map(EmployeeDTO::toEmployee)
                .anyMatch(employee -> employee.getPosition().getName()
                        .equalsIgnoreCase(positionName))) {
            if (getAllEmployees().stream().map(EmployeeDTO::toEmployee)
                    .anyMatch(employee -> employee.getPosition().getName()
                            .equals(positionName))) {
                return employeeRepository.getAllEmployeesByPosition(positionName).stream()
                        .map(EmployeeDTO::fromEmployee)
                        .collect(Collectors.toList());
            } else correctPositionName = positionName.substring(0, 1).toUpperCase() + positionName.substring(1);
            return employeeRepository.getAllEmployeesByPosition(correctPositionName).stream()
                    .map(EmployeeDTO::fromEmployee)
                    .collect(Collectors.toList());
        } else return getAllEmployees();
    }


    @Override
    public EmployeeDTO getEmployeeByIdFullInfo(int id) throws IncorrectEmployeeIdException {
        Optional<EmployeeDTO> employeeOptional = employeeRepository.getEmployeeByIdFullInfo(id).map(EmployeeDTO::fromEmployee);
        logger.info("Was invoked method getEmployeeByIdFullInfo");
        return employeeOptional.orElseThrow(() -> new IncorrectEmployeeIdException("Некорректный ID сотрудника."));
    }


    public List<EmployeeDTO> getEmployeesByPage(int page) {
        Pageable employeeOfConcretePage = PageRequest.of(page, 10);
        Page<Employee> employeePage = employeeRepository.findAll(employeeOfConcretePage);
        List<Employee> employeeList = employeePage.stream().toList();
        logger.info("Was invoked method getEmployeesByPage");
        return employeeList.stream().map(EmployeeDTO::fromEmployee).collect(Collectors.toList());
    }

    @Override
    public void uploadNewEmployeesFromFile(MultipartFile file) throws IOException {

        try (InputStream inputStream = file.getInputStream()) {

            int streamSize = inputStream.available();
            byte[] bytes = new byte[streamSize];
            inputStream.read(bytes);
            String json = new String(bytes, StandardCharsets.UTF_8);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
            EmployeeDTO[] employeeDTOArray = objectMapper.readValue(json, EmployeeDTO[].class);

            for (EmployeeDTO employeeDTO1 : employeeDTOArray) {
                employeeRepository.save(employeeDTO1.toEmployee());
            }
            logger.info("Was invoked method uploadNewEmployeesFromFile");
        } catch (IOException e) {
            logger.error("Failed to read file" + file, e);
        }

    }

    @Override
    public List<DepartmentReport> getDepartmentReport() throws IOException {
        List<DepartmentReport> departmentReportList = new ArrayList<>(employeeRepository.getReport());

        String list = departmentReportList.toString();
        String fileName = "C:\\Users\\79313\\IdeaProjects\\myEmployeeWeb-library\\src\\main\\resources\\report.json";
        Path path = Paths.get(fileName);
        try {
            Files.write(path, list.getBytes(StandardCharsets.UTF_8));
            logger.info("Was invoked method getDepartmentReport");
        }  catch (IOException e) {
            logger.error("Failed to get DepartmentReport", e);
        }
        return departmentReportList;
    }
}
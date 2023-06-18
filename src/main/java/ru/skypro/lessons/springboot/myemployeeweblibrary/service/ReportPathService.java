package ru.skypro.lessons.springboot.myemployeeweblibrary.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.myemployeeweblibrary.dto.ReportPathDTO;
import java.io.IOException;

public interface ReportPathService {
    String uploadNewReportPath (MultipartFile file) throws IOException;

    ReportPathDTO getReportPathById(int id) throws IllegalArgumentException;

}

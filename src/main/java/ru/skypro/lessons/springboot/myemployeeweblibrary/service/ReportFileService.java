package ru.skypro.lessons.springboot.myemployeeweblibrary.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.myemployeeweblibrary.dto.ReportFileDTO;
import java.io.IOException;

public interface ReportFileService {

    String uploadNewReportFile (MultipartFile file) throws IOException;

    ReportFileDTO getReportFileById(int id) throws IllegalArgumentException;

}

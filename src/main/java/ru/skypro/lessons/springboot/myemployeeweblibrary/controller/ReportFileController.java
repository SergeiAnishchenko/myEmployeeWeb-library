package ru.skypro.lessons.springboot.myemployeeweblibrary.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.myemployeeweblibrary.service.ReportFileService;
import java.io.IOException;


@RestController
@RequestMapping("/reportFile")
@RequiredArgsConstructor
public class ReportFileController {

    private final ReportFileService reportFileService;


    @PostMapping(value = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadNewReportFile(@RequestParam("file") MultipartFile file) throws IOException {

        try {
            return reportFileService.uploadNewReportFile(file);
        } catch (IOException e) {
            return String.valueOf(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> getReportById(@PathVariable Integer id) {

        String fileName = "report.json";
        Resource resource = new ByteArrayResource(reportFileService.getReportFileById(id).getFile());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(resource);
    }


}

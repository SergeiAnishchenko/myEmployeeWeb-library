package ru.skypro.lessons.springboot.myemployeeweblibrary.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.myemployeeweblibrary.dto.ReportFileDTO;
import ru.skypro.lessons.springboot.myemployeeweblibrary.pojo.ReportFile;
import ru.skypro.lessons.springboot.myemployeeweblibrary.repository.ReportFileRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ReportFileServiceImpl implements ReportFileService {

    private final ReportFileRepository reportFileRepository;

    public ReportFileServiceImpl(ReportFileRepository reportFileRepository) {
        this.reportFileRepository = reportFileRepository;
    }

    @Override
    public String uploadNewReportFile(MultipartFile file) throws IOException {
        try (InputStream inputStream = file.getInputStream()) {

            ReportFileDTO reportFileDTO = new ReportFileDTO();
            int streamSize = inputStream.available();
            byte[] bytes = new byte[streamSize];
            inputStream.read(bytes);
            reportFileDTO.setFile(bytes);
            reportFileRepository.save(reportFileDTO.toReportFile());
            List<ReportFile> reportFilesList = new ArrayList<>();
            reportFileRepository.findAll().forEach((reportFilesList::add));
            ReportFile reportFile = reportFilesList.stream().max(Comparator.comparingInt(ReportFile::getId)).get();
            int lastId = reportFile.getId();
            String report = "id созданного объекта: ";
            return report + lastId;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ReportFileDTO getReportFileById(int id) throws IllegalArgumentException {
        Optional<ReportFileDTO> reportOptional = reportFileRepository.findById(id).map(ReportFileDTO::fromReportFile);

        return reportOptional.orElseThrow(() -> new IllegalArgumentException("Некорректный ID отчета."));
    }
}

package ru.skypro.lessons.springboot.myemployeeweblibrary.dto;

import ru.skypro.lessons.springboot.myemployeeweblibrary.pojo.ReportFile;

import java.io.Serializable;

public class ReportFileDTO implements Serializable {

    private int id;
    private byte[] file;

    public static ReportFileDTO fromReportFile(ReportFile report) {
        ReportFileDTO reportDTO = new ReportFileDTO();
        reportDTO.setId(report.getId());
        reportDTO.setFile(report.getFile());
        return reportDTO;
    }

    public ReportFile toReportFile() {
        ReportFile report = new ReportFile();
        report.setId(this.getId());
        report.setFile(this.getFile());
        return report;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}


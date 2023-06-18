package ru.skypro.lessons.springboot.myemployeeweblibrary.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "reportFile")
public class ReportFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "file")
    private byte[] file;

    public ReportFile() {
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public byte[] getFile() {
        return file;
    }
    public void setFile(byte[] file) {
        this.file = file;
    }
}

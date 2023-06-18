package ru.skypro.lessons.springboot.myemployeeweblibrary.repository;

import org.springframework.data.repository.CrudRepository;
import ru.skypro.lessons.springboot.myemployeeweblibrary.pojo.ReportFile;

public interface ReportFileRepository extends CrudRepository<ReportFile, Integer> {

}


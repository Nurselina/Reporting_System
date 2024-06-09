package com.example.demo.repository.report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Integer> {

    @Query("SELECT r FROM Report r WHERE " +
            "(:startDate IS NULL OR r.createdDate >= :startDate) AND " +
            "(:endDate IS NULL OR r.createdDate <= :endDate) AND " +
            "(:reportTitle IS NULL OR r.reportTitle LIKE CONCAT('%', :title, '%'))")
    List<Report> findFilteredReports(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("reportTitle") String reportTitle
    );



    List<Report> findByReportTitleContaining(String reportTitle);

    List<Report> findByCreatedDateBetween(LocalDate startDate, LocalDate endDate);


}

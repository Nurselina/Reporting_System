package com.example.demo.service.report;

import com.example.demo.controller.report.request.CreateReportRequest;
import com.example.demo.controller.report.request.UpdateReportRequest;
import com.example.demo.controller.report.response.ReportResponse;


import java.time.LocalDate;
import java.util.List;

public interface ReportService {

    void create (CreateReportRequest createReportRequest);

    void update (UpdateReportRequest updateReportRequest);

    ReportResponse getById(int id);

    List<ReportResponse> getAll();

    void delete(int id);

    List<ReportResponse> getAllFiltered ( LocalDate startDate, LocalDate endDate, String reportTitle);

    List<ReportResponse> findByReportTitleContaining(String reportTitle);

    List<ReportResponse> findByCreatedDateBetween(LocalDate startDate, LocalDate endDate);

}

package com.example.demo.service.report;

import com.example.demo.controller.report.request.CreateReportRequest;
import com.example.demo.controller.report.request.UpdateReportRequest;
import com.example.demo.controller.report.response.ReportResponse;
import com.example.demo.core.exception.NotFoundException;
import com.example.demo.core.exception.type.NotFoundExceptionType;
import com.example.demo.core.mapper.ModelMapperService;
import com.example.demo.repository.report.Report;
import com.example.demo.repository.report.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportManager implements ReportService{

    private final ReportRepository reportRepository;
    private final ModelMapperService modelMapperService;
    private final ReportRules reportRules;

    @Override
    public void create(CreateReportRequest createReportRequest) {
        reportRules.existsByName(createReportRequest.getReportTitle());
        String fixedReportTitle = reportRules.fixName(createReportRequest.getReportTitle());
        createReportRequest.setReportTitle(fixedReportTitle);

            Report report = modelMapperService.forRequest().map(createReportRequest, Report.class);
            reportRepository.save(report);
    }

    @Override
    public void update(UpdateReportRequest updateReportRequest) {
        reportRules.existsByNameAndIdNot(updateReportRequest.getReportTitle(),updateReportRequest.getId());

        reportRepository.findById(updateReportRequest.getId()).orElseThrow(() ->
                new NotFoundException(NotFoundExceptionType.REPORT_DATA_NOT_FOUND));
        Report report = modelMapperService.forRequest().map(updateReportRequest, Report.class);
        reportRepository.save(report);

    }

    @Override
    public ReportResponse getById(int id) {
        Report report = reportRepository.findById(id).orElseThrow(() ->
                new NotFoundException(NotFoundExceptionType.REPORT_DATA_NOT_FOUND));

        return modelMapperService.forResponse().map(report, ReportResponse.class);
    }

    @Override
    public List<ReportResponse> getAll() {
        List<Report> reportList = reportRepository.findAll();

        reportRules.checkDataList(reportList);

        return reportList.stream().map(report -> modelMapperService.forResponse().map(report, ReportResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
       reportRepository.findById(id).orElseThrow(() -> new NotFoundException(NotFoundExceptionType.REPORT_DATA_NOT_FOUND));
       reportRepository.deleteById(id);
    }

    @Override
    public List<ReportResponse> findByReportTitleContaining(String reportTitle) {
        List<Report> reports = reportRepository.findByReportTitleContaining(reportTitle);
        return reports.stream()
                .map(report -> modelMapperService.forResponse().map(report, ReportResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ReportResponse> findByCreatedDateBetween(LocalDate startDate, LocalDate endDate) {
        List<Report> reports = reportRepository.findByCreatedDateBetween(startDate, endDate);
        return reports.stream()
                .map(report -> modelMapperService.forResponse().map(report, ReportResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ReportResponse> getAllFiltered(LocalDate startDate, LocalDate endDate, String reportTitle) {
        if (startDate != null && endDate != null && startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Başlangıç tarihi, bitiş tarihinden sonra olamaz.");
        }


        List<Report> filteredReports = reportRepository.findAll();
        if (reportTitle != null && startDate != null && endDate != null) {
            filteredReports = reportRepository.findFilteredReports(startDate, endDate, reportTitle);
        } else if (reportTitle != null) {
            filteredReports = reportRepository.findByReportTitleContaining(reportTitle);
        } else if (startDate != null && endDate != null) {
            filteredReports = reportRepository.findByCreatedDateBetween(startDate, endDate);
        } else {
            filteredReports = reportRepository.findAll();
        }


        return filteredReports.stream()
                .map(report -> modelMapperService.forResponse().map(report, ReportResponse.class))
                .collect(Collectors.toList());
    }
}

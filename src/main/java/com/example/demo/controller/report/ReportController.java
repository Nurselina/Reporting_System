package com.example.demo.controller.report;

import com.example.demo.controller.report.request.CreateReportRequest;
import com.example.demo.controller.report.request.UpdateReportRequest;
import com.example.demo.controller.report.response.ReportResponse;
import com.example.demo.service.report.ReportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/reports")
public class ReportController {

    private final ReportService reportService;

    @PostMapping
    public void createReport(@RequestBody @Valid CreateReportRequest createReportRequest){
        reportService.create(createReportRequest);
    }

    @PutMapping
    public void updateReport(@RequestBody @Valid UpdateReportRequest updateReportRequest){
        reportService.update(updateReportRequest);
    }

    @GetMapping("/{id}")
    public ReportResponse getByIdReport(@PathVariable int id){
        return reportService.getById(id);
    }

    @GetMapping
    public List<ReportResponse> getAllReports(){
        return reportService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable int id){
        reportService.delete(id);
    }

    @GetMapping("/titleFilter")
    public List<ReportResponse> findByReportTitleContaining(@RequestParam String reportTitle){
        return reportService.findByReportTitleContaining(reportTitle);
    }

    @GetMapping("/dateFilter")
    public List<ReportResponse> findByCreatedDateBetween(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate startDate,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate endDate
    ){
        return reportService.findByCreatedDateBetween(startDate, endDate);
    }

    @GetMapping("getAllFilter")
    public List<ReportResponse> getAllFiltered( @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate startDate,
                                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate endDate,
                                                @RequestParam String reportTitle){
        return reportService.getAllFiltered(startDate, endDate, reportTitle);
    }


}

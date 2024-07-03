package com.example.demo.controller.report;

import com.example.demo.controller.BaseController;
import com.example.demo.controller.report.request.CreateReportRequest;
import com.example.demo.controller.report.request.UpdateReportRequest;
import com.example.demo.controller.report.response.ReportResponse;
import com.example.demo.service.report.ReportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/reports")
public class ReportController extends BaseController {

    private final ReportService reportService;

    @PostMapping
    public ResponseEntity<Void> createReport(@RequestBody @Valid CreateReportRequest createReportRequest){
        reportService.create(createReportRequest);
        return answer(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> updateReport(@RequestBody @Valid UpdateReportRequest updateReportRequest){
        reportService.update(updateReportRequest);
        return answer(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportResponse>  getByIdReport(@PathVariable int id){
        return answer(reportService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ReportResponse>> getAllReports(){
        return answer(reportService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  deleteReport(@PathVariable int id){
        reportService.delete(id);
        return answer(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/titleFilter")
    public ResponseEntity<List<ReportResponse>> findByReportTitleContaining(@RequestParam String reportTitle){
        return answer(reportService.findByReportTitleContaining(reportTitle), HttpStatus.OK);
    }

    @GetMapping("/dateFilter")
    public ResponseEntity<List<ReportResponse>> findByCreatedDateBetween(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate startDate,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate endDate
    ){
        return answer(reportService.findByCreatedDateBetween(startDate, endDate), HttpStatus.OK);
    }

    @GetMapping("getAllFilter")
    public ResponseEntity<List<ReportResponse>> getAllFiltered( @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate startDate,
                                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate endDate,
                                                @RequestParam String reportTitle){
        return answer(reportService.getAllFiltered(startDate, endDate, reportTitle), HttpStatus.OK);
    }


}

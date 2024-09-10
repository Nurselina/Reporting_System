package com.example.demo.service.report;

import com.example.demo.core.exception.AlreadyExistsException;
import com.example.demo.core.exception.NotFoundException;
import com.example.demo.core.exception.type.AlreadyExistsExceptionType;
import com.example.demo.core.exception.type.NotFoundExceptionType;
import com.example.demo.repository.report.ReportRepository;
import com.example.demo.service.businessRulesAbstract.BaseItemRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportRules implements BaseItemRules {

    private final ReportRepository reportRepository;

    @Override
    public void existsByName(String reportTitle) {
      if (reportRepository.existsByReportTitle(reportTitle)){
          throw new AlreadyExistsException(AlreadyExistsExceptionType.REPORT_ALREADY_EXISTS);
      }
    }

    @Override
    public void existsByNameAndIdNot(String reportTitle, int id) {
      if (reportRepository.existsByReportTitleAndIdNot(reportTitle,id)){
          throw new AlreadyExistsException(AlreadyExistsExceptionType.REPORT_ALREADY_EXISTS);
      }
    }

    @Override
    public void checkDataList(List<?> list) {
     if (list.isEmpty()){
         throw new NotFoundException(NotFoundExceptionType.REPORT_LIST_NOT_FOUND);
     }
    }

    @Override
    public String fixName(String title) {
        return title.trim().toLowerCase();
    }

    @Override
    public void checkData(int id) {
        if (!reportRepository.existsById(id)){
            throw new NotFoundException(NotFoundExceptionType.REPORT_DATA_NOT_FOUND);
        }
    }
}

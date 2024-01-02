package by.sportliner.lk.core.service.analysis;

import by.sportliner.lk.core.model.BranchOffice;

import java.time.LocalDate;
import java.util.Map;

public interface AnalysisService {

    Map<LocalDate, AttendancesAnalysis> analysisBranchOfficeForRange(BranchOffice branchOffice,
                                                                     LocalDate from,
                                                                     LocalDate to);

    AttendancesAnalysis analysisBranchOffice(BranchOffice branchOffice, LocalDate date);

}

package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.BranchOffice;

import java.util.List;

public interface BranchOfficeService {

    List<BranchOffice> getAllBranchOffices();

    BranchOffice getById(String id);

    BranchOffice save(BranchOffice branchOffice);

    void deleteById(String id);
}

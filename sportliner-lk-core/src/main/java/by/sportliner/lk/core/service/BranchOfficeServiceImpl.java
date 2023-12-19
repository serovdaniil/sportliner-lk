package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.BranchOffice;
import by.sportliner.lk.core.repository.BranchOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BranchOfficeServiceImpl implements BranchOfficeService {

    @Autowired
    private BranchOfficeRepository branchOfficeRepository;

    @Override
    public List<BranchOffice> findAll() {
        return branchOfficeRepository.findAll();
    }

    @Override
    public BranchOffice getById(String id) {
        return branchOfficeRepository.getReferenceById(id);
    }

    @Override
    @Transactional
    public BranchOffice save(BranchOffice branchOffice) {
        return branchOfficeRepository.save(branchOffice);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        branchOfficeRepository.deleteById(id);
    }
}

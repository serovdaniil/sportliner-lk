package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.BranchOffice;
import by.sportliner.lk.core.model.Child;
import by.sportliner.lk.core.model.UserAccount;
import by.sportliner.lk.core.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChildServiceImpl implements ChildService {

    @Autowired
    private ChildRepository childRepository;

    @Override
    public Child getChildById(String id) {
        return childRepository.getReferenceById(id);
    }

    @Override
    @Transactional
    public List<Child> findChildrenByParent(UserAccount parent) {
        return childRepository.findByParent(parent);
    }

    @Override
    @Transactional
    public List<Child> findChildrenByBranchOffice(BranchOffice branchOffice) {
        return childRepository.findByBranchOffice(branchOffice);
    }

    @Override
    @Transactional
    public void save(List<Child> children) {
        childRepository.saveAll(children);
    }

    @Override
    @Transactional
    public void deleteByParent(UserAccount parent) {
        childRepository.deleteAllByParent(parent);
    }
}

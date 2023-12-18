package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.Child;
import by.sportliner.lk.core.model.UserAccount;
import by.sportliner.lk.core.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChildServiceImpl implements ChildService{

    @Autowired
    private ChildRepository childRepository;

    @Override
    public Child findChildById(String id) {
        return childRepository.getReferenceById(id);
    }

    @Override
    public List<Child> findChildrenByParent(UserAccount parent) {
        return childRepository.findByParent(parent);
    }

    @Override
    @Transactional
    public void saveChildren(List<Child> children) {
        childRepository.saveAll(children);
    }

    @Override
    @Transactional
    public void saveChild(Child child) {
        childRepository.save(child);
    }

    @Override
    @Transactional
    public void deleteByParent(UserAccount parent) {
        childRepository.deleteAllByParent(parent);
    }
}

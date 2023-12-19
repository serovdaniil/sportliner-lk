package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.Child;
import by.sportliner.lk.core.model.UserAccount;

import java.util.List;

public interface ChildService {

    Child getChildById(String id);

    List<Child> findChildrenByParent(UserAccount parent);

    void save(List<Child> children);

    void deleteByParent(UserAccount parent);

}

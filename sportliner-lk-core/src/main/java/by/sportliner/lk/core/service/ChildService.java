package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.Child;
import by.sportliner.lk.core.model.UserAccount;
import org.apache.catalina.User;

import java.util.List;

public interface ChildService {

    Child findChildById(String id);

    List<Child> findChildrenByParent(UserAccount parent);

    void saveChildren(List<Child> children);

    void saveChild(Child child);

    void deleteByParent(UserAccount parent);

}

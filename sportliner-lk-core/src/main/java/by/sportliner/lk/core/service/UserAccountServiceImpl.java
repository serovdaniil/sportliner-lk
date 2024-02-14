package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.Child;
import by.sportliner.lk.core.model.PaymentType;
import by.sportliner.lk.core.model.UserAccount;
import by.sportliner.lk.core.model.UserRole;
import by.sportliner.lk.core.repository.UserAccountRepository;
import by.sportliner.lk.core.service.integration.epos.EposHgroshService;
import by.sportliner.lk.core.support.jpa.JpaPredicates;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
@Transactional
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private ChildService childService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private EposHgroshService eposHgroshService;

    @Override
    public List<UserAccount> findAll(UserAccountCriteria criteria) {
        return userAccountRepository.findAll(toSpecification(criteria));
    }

    @Override
    public UserAccount getById(String id) {
        return userAccountRepository.getReferenceById(id);
    }

    @Override
    public List<UserAccount> getTrainers() {
        return userAccountRepository.findByRole(UserRole.TRAINER);
    }

    @Override
    public void deleteById(String id) {
        userAccountRepository.deleteById(id);
    }

    @Override
    public UserAccount saveWithChildren(UserAccount userAccount, List<Child> children) {
        if (userAccount.getId() == null) {
            userAccount.setCreateTimestamp(Instant.now());
        } else {
            userAccount.setUpdateTimestamp(Instant.now());
        }

        UserAccount target = userAccountRepository.save(userAccount);

        for (Child child : children) {
            if (child.getId() != null || (child.getId() == null && child.getInvoiceNumber() != null)) {
                childService.save(child);
                continue;
            }

            String invoiceNumber = eposHgroshService.createInvoiceFor(child);

            child.setInvoiceNumber(invoiceNumber);

            childService.save(child);

            if (child.getPaymentType().equals(PaymentType.PREPAYMENT)) {
                transactionService.addTransactionForNewChild(child);
            }
        }

        return target;
    }

    private Specification<UserAccount> toSpecification(UserAccountCriteria criteria) {
        return (root, query, cb) -> {
            Predicate result = cb.conjunction();

            String lastName = criteria.getLastName();
            if (lastName != null) {
                result = cb.and(result,
                    JpaPredicates.containsAllWords(cb, lastName, root.get("lastName"))
                );
            }

            UserRole role = criteria.getRole();
            if (role != null) {
                result = cb.and(result, cb.equal(root.get("role"), role));
            }

            Boolean payAttention = criteria.getPayAttention();
            if (payAttention != null) {
                result = cb.and(result, cb.equal(root.get("payAttention"), payAttention));
            }

            return result;
        };
    }
}

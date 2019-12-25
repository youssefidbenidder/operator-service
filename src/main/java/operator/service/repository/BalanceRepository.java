package operator.service.repository;

import operator.service.model.Balance;
import operator.service.model.PhoneUser;
import operator.service.model.PurchaseType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<Balance, Long> {
    public Balance findByPurchaseTypeAndPhoneUser(PurchaseType purchaseType, PhoneUser phoneUser);
}

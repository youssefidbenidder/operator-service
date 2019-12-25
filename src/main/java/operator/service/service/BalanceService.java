package operator.service.service;

import operator.service.model.Balance;
import operator.service.model.PhoneUser;
import operator.service.model.PurchaseType;
import operator.service.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceService {

    @Autowired
    private BalanceRepository repository;

    public Balance create(Balance balance){
        return repository.save(balance);
    }

    public Balance findBalanceByPurchaseTypeAndPhoneUser(PurchaseType purchaseType, PhoneUser phoneUser){
        return repository.findByPurchaseTypeAndPhoneUser(purchaseType, phoneUser);
    }

}

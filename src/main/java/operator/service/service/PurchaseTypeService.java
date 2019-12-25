package operator.service.service;

import operator.service.model.PurchaseType;
import operator.service.repository.PurchaseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseTypeService {

    @Autowired
    private PurchaseTypeRepository repository;

    public PurchaseType create(PurchaseType purchaseType) {
        return repository.save(purchaseType);
    }

    public PurchaseType findByType(String type) {
        return repository.findByType(type);
    }

    public List<PurchaseType> findAll() {
        return repository.findAll();
    }

}

package operator.service.repository;

import operator.service.model.PurchaseType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseTypeRepository extends JpaRepository<PurchaseType, Long> {
    public PurchaseType findByType(String type);
}

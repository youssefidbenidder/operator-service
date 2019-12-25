package operator.service.repository;

import operator.service.model.PhoneUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhoneUserRepository extends JpaRepository<PhoneUser,Long> {
    public Optional<PhoneUser> findByPhoneNumber(String phoneNumber);
}

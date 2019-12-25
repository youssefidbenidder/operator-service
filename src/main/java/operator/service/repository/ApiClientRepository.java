package operator.service.repository;

import operator.service.model.ApiClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApiClientRepository extends JpaRepository<ApiClient, Long> {
    public Optional<ApiClient> findByUsername(String username);
}

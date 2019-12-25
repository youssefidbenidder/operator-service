package operator.service.service;

import operator.service.model.ApiClient;
import operator.service.repository.ApiClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApiClientService {

    @Autowired
    private ApiClientRepository repository;

    public ApiClient create(ApiClient apiClient){
        return repository.save(apiClient);
    }

    public ApiClient findByUsername(String username){
        return repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Api Client Not Found with -> username : " + username));
    }

}

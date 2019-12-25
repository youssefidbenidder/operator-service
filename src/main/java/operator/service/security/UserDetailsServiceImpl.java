package operator.service.security;


import operator.service.repository.ApiClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private ApiClientRepository apiClientRepository;

    @Autowired
    public UserDetailsServiceImpl(ApiClientRepository apiClientRepository) {
        this.apiClientRepository = apiClientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.apiClientRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Api Client Not Found with -> username : " + username));
    }

}
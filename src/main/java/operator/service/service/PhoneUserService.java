package operator.service.service;

import operator.service.model.PhoneUser;
import operator.service.repository.PhoneUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneUserService {

    @Autowired
    private PhoneUserRepository repository;

    public PhoneUser create(PhoneUser phoneUser){
        return repository.save(phoneUser);
    }

    public PhoneUser update(PhoneUser phoneUser) {
        return repository.save(phoneUser);
    }

    public PhoneUser findByPhoneNumber(String phoneNumber) throws Exception {
        return repository.findByPhoneNumber(phoneNumber).orElseThrow(()-> new Exception("Phone User with this phone number is not found"));
    }

}

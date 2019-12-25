package operator.service.service;

import operator.service.model.*;
import operator.service.model.dto.PurchaseDto;
import operator.service.repository.PhoneUserRepository;
import operator.service.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository repository;

    @Autowired
    private PhoneUserService phoneUserService;

    @Autowired
    private BalanceService balanceService;

    @Autowired
    private PurchaseTypeService purchaseTypeService;

    @Autowired
    private ApiClientService apiClientService;

    @Autowired
    private SmsService smsService;

    public Purchase create(PurchaseDto purchaseDto){
        PhoneUser phoneUser = null;
        try {
            phoneUser = phoneUserService.findByPhoneNumber(purchaseDto.getPhoneNumber());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        ApiClient apiClient = apiClientService.findByUsername(userDetails.getUsername());
        Purchase purchase = Purchase.builder().apiClient(apiClient).phoneUser(phoneUser)
                .amount(purchaseDto.getAmount()).type(purchaseDto.getType()).build();
        Balance balance = balanceService.findBalanceByPurchaseTypeAndPhoneUser(purchaseTypeService.findByType(purchaseDto.getType()),phoneUser);
        balance.setBalance(balance.getBalance() + purchaseDto.getAmount());
        smsService.sendSms(purchaseDto.getPhoneNumber());
        return repository.save(purchase);
    }

}

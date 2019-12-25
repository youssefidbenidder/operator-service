package operator.service;


import operator.service.model.Balance;
import operator.service.model.PhoneUser;
import operator.service.model.PurchaseType;
import operator.service.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {


    private static final boolean LOAD_INITIAL_DATA = false;
    private static final String PURCHASE_TYPE_INTERNET = "Internet Refills";
    private static final String PURCHASE_TYPE_CALLS_SMS = "Recharge Calls and SMS";
    private static final String PURCHASE_TYPE_FLEX = "Flex Refill";
    private static final String PURCHASE_TYPE_NORMAL = "Normal Refill";
    private static final String PURCHASE_TYPE_INTERNATIONAL = "International Call Refill";

    private final PhoneUserService phoneUserService;
    private final PurchaseService purchaseService;
    private final PurchaseTypeService purchaseTypeService;
    private final BalanceService balanceService;
    private final ApiClientService apiClientService;


    @Autowired
    public DataInitializer(PhoneUserService phoneUserService, PurchaseService purchaseService, PurchaseTypeService purchaseTypeService, BalanceService balanceService, ApiClientService apiClientService) {

        this.phoneUserService = phoneUserService;
        this.purchaseService = purchaseService;
        this.purchaseTypeService = purchaseTypeService;
        this.balanceService = balanceService;
        this.apiClientService = apiClientService;
    }

    @Override
    public void run(String... args) throws Exception {
        if(LOAD_INITIAL_DATA){

            PurchaseType purchaseTypeInternet = PurchaseType.builder().type(PURCHASE_TYPE_INTERNET).build();
            purchaseTypeService.create(purchaseTypeInternet);
            PurchaseType purchaseTypeCalls = PurchaseType.builder().type(PURCHASE_TYPE_CALLS_SMS).build();
            purchaseTypeService.create(purchaseTypeCalls);
            PurchaseType purchaseTypeFlex = PurchaseType.builder().type(PURCHASE_TYPE_FLEX).build();
            purchaseTypeService.create(purchaseTypeFlex);
            PurchaseType purchaseTypeInternational = PurchaseType.builder().type(PURCHASE_TYPE_INTERNATIONAL).build();
            purchaseTypeService.create(purchaseTypeInternational);
            PurchaseType purchaseTypeNormal = PurchaseType.builder().type(PURCHASE_TYPE_NORMAL).build();
            purchaseTypeService.create(purchaseTypeNormal);

            PhoneUser phoneUser = PhoneUser.builder().phoneNumber("0632844738").build();
            phoneUserService.create(phoneUser);
            Balance balance = Balance.builder().balance(100l).purchaseType(purchaseTypeService.findByType(PURCHASE_TYPE_INTERNET)).phoneUser(phoneUser).build();
            Balance balance1 = Balance.builder().balance(100l).purchaseType(purchaseTypeService.findByType(PURCHASE_TYPE_FLEX)).phoneUser(phoneUser).build();
            Balance balance2 = Balance.builder().balance(100l).purchaseType(purchaseTypeService.findByType(PURCHASE_TYPE_CALLS_SMS)).phoneUser(phoneUser).build();
            Balance balance3 = Balance.builder().balance(100l).purchaseType(purchaseTypeService.findByType(PURCHASE_TYPE_NORMAL)).phoneUser(phoneUser).build();
            Balance balance4 = Balance.builder().balance(100l).purchaseType(purchaseTypeService.findByType(PURCHASE_TYPE_INTERNATIONAL)).phoneUser(phoneUser).build();
            balanceService.create(balance);
            balanceService.create(balance1);
            balanceService.create(balance2);
            balanceService.create(balance3);
            balanceService.create(balance4);

        }
    }
}

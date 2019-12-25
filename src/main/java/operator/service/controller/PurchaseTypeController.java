package operator.service.controller;

import operator.service.model.PurchaseType;
import operator.service.service.PurchaseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/v1/operator/purchase-type")
@RestController
public class PurchaseTypeController {

    @Autowired
    private PurchaseTypeService purchaseTypeService;

    @GetMapping(value = "")
    public List<PurchaseType> findAll() {
        return purchaseTypeService.findAll();
    }
}

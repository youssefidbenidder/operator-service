package operator.service.controller;

import lombok.extern.slf4j.Slf4j;
import operator.service.model.ApiClient;
import operator.service.model.Purchase;
import operator.service.model.dto.PurchaseDto;
import operator.service.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Slf4j
@RequestMapping("/v1/operator/purchase")
@RestController
public class PurchaseController {

    @Autowired
    private PurchaseService service;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Purchase> create(@RequestBody PurchaseDto model) {
        Purchase savedModel = service.create(model);
        if (savedModel != null) {
            return new ResponseEntity<>(savedModel, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

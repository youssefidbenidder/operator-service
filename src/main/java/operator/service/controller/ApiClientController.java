package operator.service.controller;

import operator.service.model.ApiClient;
import operator.service.security.jwt.JwtUtil;
import operator.service.service.ApiClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/operator/api_client")
@RestController
public class ApiClientController {

    @Autowired
    private ApiClientService service;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/create_token")
    public String createToken(@RequestBody ApiClient apiClient){

        apiClient.setPassword(passwordEncoder.encode(apiClient.getPassword()));
        ApiClient modelSaved = service.create(apiClient);
        String token = jwtUtil.createToken(modelSaved);
        return token;

    }

}

package pl.pcz.carsCrud3.dao;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pcz.carsCrud3.dto.UserView;

@Service
public class RestTemplateService {

    private final String apiURL = "http://localhost:8080/users/";

    public UserView getUserInformation(Long id){
        RestTemplate restTemplate = new RestTemplate();
        String apiURLWitchId = apiURL + id;
        return restTemplate.getForObject(apiURLWitchId,UserView.class);
    }
}

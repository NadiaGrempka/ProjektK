package com.kotki.frontend;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


import java.util.List;
import java.util.logging.Logger;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class WebService { // to jest rest client
    public static final String BASE_URL = "http://localhost:8080";
    private Logger logger = Logger.getLogger("Web Service");
    RestClient restClient;
    public WebService(){
        restClient = RestClient.create();
    }

    public Iterable<Cat> getAllCats() {
        logger.info("Method getAllCats");
        List<Cat> cats = restClient
                .get()
                .uri(BASE_URL + "/cat/viewAll")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
        logger.info("Method getAllCats2");
        return cats;
    }

    public void addNewCat(Cat cat) {
        logger.info("Method addCat");
        Cat cat1 = restClient
                .post()
                .uri(BASE_URL + "/cat/add")
                .contentType(APPLICATION_JSON)
                .body(cat)
                .retrieve()
                .body(Cat.class);
    }

    public void updateCat(Cat cat) {
        logger.info("Method updateCat");
        Cat cat2 = restClient
                .put()
                .uri(BASE_URL + "/cat/update")
                .contentType(APPLICATION_JSON)
                .body(cat)
                .retrieve()
                .body(Cat.class);
    }

    public Cat getCatId(long id) {
        logger.info("Method editCat");
        Cat cat = restClient
                .get()
                .uri(BASE_URL + "/cat/id/" + id)
                .retrieve()
                .body(Cat.class);
        return cat;
    }

    public void deleteById(Long id) {
    }
}

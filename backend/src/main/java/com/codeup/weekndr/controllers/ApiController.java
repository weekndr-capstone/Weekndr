package com.codeup.weekndr.controllers;

import com.codeup.weekndr.models.ApiKeys;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping(name = "/api")
public class ApiController {

    @GetMapping("/yelpList")
    public ResponseEntity<String> yelpList(){
        ApiKeys apiKeys = new ApiKeys("", "");
        return getyelpList(apiKeys.getYelp());
    }

    private static ResponseEntity<String> getyelpList(String bearer)
    {
        final String uri = "https://api.yelp.com/v3/businesses/north-india-restaurant-san-francisco";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + bearer);

        System.out.println(headers + " HEADERS");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

        System.out.println(result);
        return result;
    }
}
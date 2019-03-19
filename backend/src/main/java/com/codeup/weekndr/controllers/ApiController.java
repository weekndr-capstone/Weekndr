package com.codeup.weekndr.controllers;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.twilio.twiml.voice.Sms;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
//import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(name = "/api")
public class ApiController {

    @Value("${api-yelp}")
    private String yelpApi;
    @Value("${api-weather}")
    private String weatherApi;
    @Value("${api-authtwillio}")
    private String authtwilio;
    @Value("${api-twillioSID}")
    private String twilioSID;
    @Value("${api-uberserver}")
    private String uberserver;
    @Value("${api-uberclientId}")
    private String uberclientId;
    @Value("${api-ubersecretId}")
    private String apiubersecredId;
    @Value("${api-google}")
    private String googleApi;


    @GetMapping("/yelpList/{location}/{type}")
    public ResponseEntity<String> yelpList(@PathVariable String location, @PathVariable String type){
        System.out.println("Made it here");
        return getyelpList(yelpApi, location, type);
    }

    @PostMapping("/twilio")
    public String twilio(@RequestParam("friends") String friends, @RequestParam("fromNumber") String fromNumber){
        System.out.println(friends);
        System.out.println(fromNumber);
        String body = "You have been invited on a trip. Click the link to join in on the fun!";
        String toNumber = "+12105188350";
        String testNum = "+13022447485";
        twilioMessage(toNumber, testNum, body, authtwilio, twilioSID);
        return "message sent";
    }

    private static ResponseEntity<String> getyelpList(String bearer, String location, String type)
    {
        String uri;
        switch (type){
            case "1": uri = "https://api.yelp.com/v3/businesses/search?location=" + location + "&term=experience&radius=20000&limit=26";
            break;

            case "2": uri = "https://api.yelp.com/v3/businesses/search?location=" + location + "&term=food&radius=20000&limit=26";
            break;

            case "3": uri = "https://api.yelp.com/v3/businesses/search?location=" + location + "&term=hotel&radius=20000&limit=26";
            break;

            default: uri = "https://api.yelp.com/v3/businesses/search?location=" + location + "&radius=20000&limit=26";
        }
        System.out.println(uri);
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

    private static ResponseEntity<String> getyelpListFood(String bearer, String location)
    {
        final String uri = "https://api.yelp.com/v3/businesses/search?location=" + location + "&term=food&radius=20000";
        System.out.println(uri);
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



        public void twillioTest(String Auth, String SID ) {
            Twilio.init(Auth, SID);

            Message message = Message
                    .creator(new PhoneNumber("+14159352345"), // to
                            new PhoneNumber("+14158141829"), // from
                            "Where's Wallace?")
                    .create();

            System.out.println(message.getSid());
        }

        public void twilioMessage(String to, String from, String body, String Auth, String SID ){
            Twilio.init(Auth, SID);

            Message message = Message
                    .creator(new PhoneNumber(to),
                            new PhoneNumber(from),
                            body)
                    .create();
            System.out.println(message.getSid());
        }



}
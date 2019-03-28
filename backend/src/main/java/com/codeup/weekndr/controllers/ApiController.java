package com.codeup.weekndr.controllers;
        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.http.*;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.client.RestTemplate;
        import com.twilio.Twilio;
        import com.twilio.rest.api.v2010.account.Message;
        import com.twilio.type.PhoneNumber;

        import java.util.Arrays;

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
        return getyelpList(yelpApi, location, type);
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

    @PostMapping("/twilio")
    public String twilio(@RequestParam("friends") String friends, @RequestParam("fromNumber") String fromNumber){
        String body = "You have been invited on a trip. Click the link to join in on the fun!";
        twilioMessage(friends, fromNumber, body, authtwilio, twilioSID);
        return "message sent";
    }

    public void twilioMessage(String to, String from, String body, String Auth, String SID ){
        Twilio.init(Auth, SID);

        Message message = Message
                .creator(new PhoneNumber("+1"+to), // to
                        new PhoneNumber("+13252550907"), // from
                        body)
                .create();
        System.out.println(message.getSid());
    }

    @GetMapping("/api/weather")
    public ResponseEntity<String> Weather(@RequestParam String lat, @RequestParam String lon){
        return getWeatherResults(weatherApi,lat, lon);
    }

    private static ResponseEntity<String> getWeatherResults(String bearer, String lat, String lon)
    {
        String uri = "https://api.darksky.net/forecast/"+ bearer +"/"+ lat + "," + lon;
        System.out.println(uri);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + bearer);

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

        return result;
    }
}
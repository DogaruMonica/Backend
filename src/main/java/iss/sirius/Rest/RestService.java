package iss.sirius.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/*
    You need to have the middleware running on port 8000 for this to work
 */
@Service
public class RestService {
    @Autowired
    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getTeachers() {
        String url = "http://127.0.0.1:8000/webscrapper/teachers";
        URI uri = null;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {

        }
        ResponseEntity<String> response = this.restTemplate.getForEntity(uri, String.class);
        return response != null ? response.getBody() : null;
    }

    public String getRooms() {
        String url = "http://127.0.0.1:8000/webscrapper/rooms";
        URI uri = null;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {

        }
        ResponseEntity<String> response = this.restTemplate.getForEntity(uri, String.class);
        return response != null ? response.getBody() : null;
    }

    public String getTimetables() {
        String url = "http://127.0.0.1:8000/webscrapper/timetable";
        URI uri = null;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {

        }
        ResponseEntity<String> response = this.restTemplate.getForEntity(uri, String.class);
        return response != null ? response.getBody() : null;
    }
}

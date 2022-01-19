package com.example.oaeeventcms;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OaeEventCmsController {

    @Autowired
    OaeEventCmsRepository repository;

    @GetMapping("/events")
    public ResponseEntity<List<Event>> getEvents() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
        } catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ArrayList<>());
        }
    }

    public void checkNullOrEmptyValue(String value, String propertyName) {
        if(value == null || value.equals("")){
            throw new IllegalArgumentException("Event " + propertyName + " cannot be null");
        }
    }

    public void checkNullOrEmptyValue(Object value, String propertyName) {
        if(value == null){
            throw new IllegalArgumentException("Event " + propertyName + " cannot be null");
        }
    }

    public void checkingEventValues(Event event) {
        checkNullOrEmptyValue(event.getName(), "name");
        checkNullOrEmptyValue(event.getSeries(), "series");
        checkNullOrEmptyValue(event.getTime(), "time");
        checkNullOrEmptyValue(event.getDate(), "date");
        checkNullOrEmptyValue(event.getLocation(), "location");
        checkNullOrEmptyValue(event.getImageSrc(), "imageSrc");
        checkNullOrEmptyValue(event.getFeaturedEvent(), "featuredEvent");
        for(int i = 0; i < event.getIntro().size(); i++) {
            checkNullOrEmptyValue(event.getIntro().get(i).getHeading(), "heading");
            checkNullOrEmptyValue(event.getIntro().get(i).getContent(), "content");
        }
        checkNullOrEmptyValue(event.getTheme().getTemplateTheme(), "templateTheme");
        checkNullOrEmptyValue(event.getTheme().getPrimaryColor(), "primaryColor");
        checkNullOrEmptyValue(event.getTheme().getAccentColor(), "accentColor");
        checkNullOrEmptyValue(event.getTheme().getSubtitleColor(), "subtitleColor");
        for(int i = 0; i < event.getSchedule().size(); i++) {
            checkNullOrEmptyValue(event.getSchedule().get(i).getName(), "scheduleName");
        }
    }

    // need to add more if statements to throw exceptions for better error handling
    @PostMapping("/events/add")
    public ResponseEntity<String> createEvent(@RequestBody Event event) {
        try {
            checkingEventValues(event);
            repository.save(event);
            return ResponseEntity.status(HttpStatus.CREATED).body("Event added: " + event.getName());
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while trying to add new event: " + e.getMessage());
        } catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while trying to add new event");
        }
    }

    // Put the id within the body for the update to work
    @PutMapping("/events/{id}")
    public ResponseEntity<String> updateEventById(@RequestBody Event event, @PathVariable String id) {
        try {
            checkingEventValues(event);
            repository.save(event);
            return ResponseEntity.status(HttpStatus.OK).body("Event has been updated");
        } catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while trying to update event with id " + event.getId());
        }
    }

    @GetMapping("events/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable String id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(repository.findEventByid(Integer.parseInt(id)));
        } catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status((HttpStatus.BAD_REQUEST)).body(null);
        }
    }

    @DeleteMapping("events/{id}")
    @Transactional
    public ResponseEntity<String> deleteEventById(@PathVariable String id) {
        try {
            repository.deleteEventByid(Integer.parseInt(id));
            return ResponseEntity.status(HttpStatus.OK).body("Event with ID " + id + " has been deleted.");
        } catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while trying to delete event with id " + repository.getById(id).getId());
        }
    }

}

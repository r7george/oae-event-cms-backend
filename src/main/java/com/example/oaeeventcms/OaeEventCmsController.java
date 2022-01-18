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
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ArrayList<>());
        }
    }

    @PostMapping("/events/add")
    public ResponseEntity<String> createEvent(@RequestBody Event event) {
        try {
            repository.save(event);
            return ResponseEntity.status(HttpStatus.CREATED).body("Event added: " + event.getName());
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while trying to add new event");
        }
    }

    // Put the id within the body for the update to work
    @PutMapping("/events/{id}")
    public ResponseEntity<String> updateEventById(@RequestBody Event event, @PathVariable String id) {
        try {
            repository.save(event);
            return ResponseEntity.status(HttpStatus.OK).body("Event has been updated");
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while trying to update event with id " + event.getId());
        }
    }

    @GetMapping("events/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable String id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(repository.findEventByid(Integer.parseInt(id)));
        } catch(Exception e) {
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
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while trying to delete event with id " + repository.getById(id).getId());
        }
    }

}

package com.example.oaeeventcms;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class OaeEventCmsController {

    @Autowired
    OaeEventCmsRepository repository;

    @GetMapping("/events")
    public ResponseEntity<List<Event>> getEvents() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @PostMapping("/events/add")
    public ResponseEntity<String> createEvent(@RequestBody Event event) {
        repository.save(event);
        return ResponseEntity.status(HttpStatus.CREATED).body("Event added: " + event.getName());
    }

    @GetMapping("events/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findEventByid(Integer.parseInt(id)));
    }

}

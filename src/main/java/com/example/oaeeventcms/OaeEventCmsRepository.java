package com.example.oaeeventcms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OaeEventCmsRepository extends JpaRepository<Event, String> {
    Event findEventByid(int id);
}

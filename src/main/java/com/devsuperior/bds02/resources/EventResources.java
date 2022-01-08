package com.devsuperior.bds02.resources;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.services.EventServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/events")
public class EventResources {
    @Autowired
    private EventServices services;

    @PutMapping(value="/{id}")
    public ResponseEntity<EventDTO> update(@PathVariable Long id, @RequestBody EventDTO eventDTO){
        EventDTO eventDto= services.update(eventDTO, id);
        return ResponseEntity.ok().body(eventDto);
    }

}

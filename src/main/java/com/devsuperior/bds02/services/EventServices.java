package com.devsuperior.bds02.services;


import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventServices {
    @Autowired
    private EventRepository repository;

    @Transactional
    public EventDTO update(EventDTO eventDTO){
        Event event = new Event();
        event.setId(eventDTO.getId());
        event.setName(eventDTO.getName());
        event.setDate(eventDTO.getDate());
        event.setUrl(eventDTO.getUrl());
        event.setCity( new City(eventDTO.getCityId(),null));
        event=repository.save(event);
        return new EventDTO( event);
    }
}

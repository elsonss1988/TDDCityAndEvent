package com.devsuperior.bds02.resources;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.services.CityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="cities")
public class CityResources {

    @Autowired
    private CityServices services;

    @GetMapping
    public ResponseEntity<List<CityDTO>> findAll(){
        List<CityDTO> listDTO=services.findAll();
        return ResponseEntity.ok().body(listDTO);
    }
}

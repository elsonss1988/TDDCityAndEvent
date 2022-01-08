package com.devsuperior.bds02.resources;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.services.CityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @DeleteMapping(value="/{id}")
    public ResponseEntity<CityDTO> delete(@PathVariable Long id){
        services.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<CityDTO> insert(@RequestBody CityDTO cityDTO){
        CityDTO cityDto=services.insert(cityDTO);
        URI uri= ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/id}")
                .buildAndExpand(cityDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).body(cityDto);

    }

}

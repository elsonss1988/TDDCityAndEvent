package com.devsuperior.bds02.services;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.CityRepository;
import com.devsuperior.bds02.services.exceptions.DataBaseException;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServices {
    @Autowired
    private CityRepository repository;

    @Transactional(readOnly = true)
    public List<CityDTO> findAll(){
        List<City> list=repository.findAll(Sort.by("name"));
        List<CityDTO> listDTO = list.stream().map(x->new CityDTO(x)).collect(Collectors.toList());
        return listDTO;
    }

    @Transactional
    public CityDTO insert(CityDTO cityDTO){
        City city = new City();
        city.setName(cityDTO.getName());
        city=repository.save(city);
        return new CityDTO(city);
    }

     public void delete(Long id){
        try {
            repository.deleteById(id);
            System.out.println();
        }catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id not found " +id);
        }catch (DataIntegrityViolationException e){
            throw new DataBaseException("Integrity Violation");
        }
    }
}

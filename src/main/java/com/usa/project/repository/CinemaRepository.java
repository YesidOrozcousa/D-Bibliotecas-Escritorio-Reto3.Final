package com.usa.project.repository;

import com.usa.project.model.Cinema;
import com.usa.project.repository.crud.CinemaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CinemaRepository {
    @Autowired
    private CinemaCrudRepository cinemaCrudRepository;

    public List<Cinema> getAll(){
        return (List<Cinema>) cinemaCrudRepository.findAll();
    }

    public Optional<Cinema> getCinema(int id){
        return cinemaCrudRepository.findById(id);
    }

    public Cinema save(Cinema cinema){
        return cinemaCrudRepository.save(cinema);
    }
    public void delete(Cinema cinema){
        cinemaCrudRepository.delete(cinema);
    }

    public List<Object[]> getTopByCapacity(){
        return cinemaCrudRepository.countTotalCinemaByCapacity();
    }

}

package com.usa.project.repository.crud;

import com.usa.project.model.Cinema;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CinemaCrudRepository extends CrudRepository<Cinema,Integer> {

    @Query("SELECT c.capacity, COUNT(c.capacity) from Cinema AS c group by c.capacity order by COUNT(c.capacity) DESC")
    public List<Object[]> countTotalCinemaByCapacity();

}

package com.usa.project.service;
import com.usa.project.model.Cinema;
import com.usa.project.model.custom.CapacityAmount;
import com.usa.project.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {
    @Autowired
    private CinemaRepository cinemaRepository;

    public List<Cinema> getAll(){
        return cinemaRepository.getAll();
    }

    public Optional<Cinema> getCinema(int id) {
        return cinemaRepository.getCinema(id);
    }

    public Cinema save(Cinema cinema){
        if(cinema.getId()==null){
            return cinemaRepository.save(cinema);
        }else{
            Optional<Cinema> e= cinemaRepository.getCinema(cinema.getId());
            if(e.isEmpty()){
                return cinemaRepository.save(cinema);
            }else{
                return cinema;
            }
        }
    }

    public Cinema update(Cinema cinema){
        if(cinema.getId()!=null){
            Optional<Cinema> e= cinemaRepository.getCinema(cinema.getId());
            if(!e.isEmpty()){
                if(cinema.getName()!=null){
                    e.get().setName(cinema.getName());
                }
                if(cinema.getOwner()!=null){
                    e.get().setOwner(cinema.getOwner());
                }
                if(cinema.getCapacity()!=null){
                    e.get().setCapacity(cinema.getCapacity());
                }
                if(cinema.getDescription()!=null){
                    e.get().setDescription(cinema.getDescription());
                }
                if(cinema.getCategory()!=null){
                    e.get().setCategory(cinema.getCategory());
                }
                cinemaRepository.save(e.get());
                return e.get();
            }else{
                return cinema;
            }
        }else{
            return cinema;
        }
    }


    public boolean delete(int id) {
        Boolean aBoolean = getCinema(id).map(costume -> {
            cinemaRepository.delete(costume);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<CapacityAmount> getTopCinemaByCapacity(){
        List<Object[]> report= cinemaRepository.getTopByCapacity();
        List<CapacityAmount>res=new ArrayList<>();
        for(int i=0;i<report.size();i++){
            res.add(new CapacityAmount((int)report.get(i)[0],(int) report.get(i)[1]));
        }
        return res;
    }
}


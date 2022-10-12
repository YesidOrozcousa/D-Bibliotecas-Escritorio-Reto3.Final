package com.usa.project.model.custom;

import com.usa.project.model.Cinema;

public class CountCinema {
    private Long total;
    private Cinema cinema;

    public CountCinema(Long total, Cinema cinema) {
        this.total = total;
        this.cinema = cinema;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cinema getCar() {
        return cinema;
    }

    public void setCar(Cinema cinema) {
        this.cinema = cinema;
    }
}

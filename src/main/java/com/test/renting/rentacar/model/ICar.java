package com.test.renting.rentacar.model;

public interface ICar {
    public Double calculatePrice(int days);
    public Double calculateExtraDay(int extraDays);
}

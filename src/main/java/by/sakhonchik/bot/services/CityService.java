package by.sakhonchik.bot.services;

import by.sakhonchik.bot.entities.City;

import java.util.List;

public interface CityService {
    List<City> getAllCity();

    String getInfoAboutCity(String cityName);

    City addCity(City city);

    void deleteCityById(Long id);

    boolean isExist(String cityName);


}

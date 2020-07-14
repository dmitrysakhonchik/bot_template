package by.sakhonchik.bot.services;

import by.sakhonchik.bot.entities.City;
import by.sakhonchik.bot.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    public CityRepository repository;

    @Autowired
    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<City> getAllCity() {
        return repository.findAll();
    }

    @Override
    public String getInfoAboutCity(String cityName) {
        City cityFromDB = repository.findCityByName(cityName);
        return cityFromDB.getInfo();
    }

    @Override
    public boolean isExist(String cityName) {
        return repository.existsCityByName(cityName);
    }

    @Override
    public City addCity(City city) {
        return repository.save(city);
    }

    @Override
    public void deleteCityById(Long id) {
        repository.deleteById(id);
    }


}

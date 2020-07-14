package by.sakhonchik.bot.controllers;

import by.sakhonchik.bot.entities.City;
import by.sakhonchik.bot.services.CityServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/city")
public class CityController {

    private final CityServiceImpl service;

    @Autowired
    public CityController(CityServiceImpl service) {
        this.service = service;
    }

    @GetMapping(path = "/all", produces = "application/json")
    public List<City> showAllCity() {
        return service.getAllCity();
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    public City create(@RequestBody City city) {
        return service.addCity(city);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.deleteCityById(id);
    }

    @PutMapping("/{id}")
    public City update(@PathVariable("id") City cityFromDb,
                       @RequestBody City city) {
        BeanUtils.copyProperties(city, cityFromDb, "id");
        return service.addCity(cityFromDb);
    }

}

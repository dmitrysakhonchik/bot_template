package by.sakhonchik.bot.controllers;

import by.sakhonchik.bot.entities.City;
import by.sakhonchik.bot.services.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:63342")
@RestController
@RequestMapping("api/v1/item")
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
}

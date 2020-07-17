package by.sakhonchik.bot.controllers;

import by.sakhonchik.bot.entities.City;
import by.sakhonchik.bot.services.CityServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for {@link City} connected requests.
 *
 * @author Dmitry Sakhonchik
 * @version 1.0
 */


@RestController
@RequestMapping("api/v1/city")
public class CityController {

    private final CityServiceImpl service;

    @Autowired
    public CityController(CityServiceImpl service) {
        this.service = service;
    }

    @GetMapping(path = "all", produces = "application/json")
    public ResponseEntity<List<City>> showAllCity() {
        List<City> cities = this.service.getAllCity();

        if (cities.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<City> create(@RequestBody City city) {
        HttpHeaders headers = new HttpHeaders();

        if (city == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.service.addCity(city);
        return new ResponseEntity<>(city, headers, HttpStatus.CREATED);

    }

    @DeleteMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<City> delete(@PathVariable("id") Long id) {
        City city = this.service.getCityById(id);

        if (city == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.service.deleteCityById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


    @PutMapping(path = "{id}", produces = "application/json")
    public City update(@PathVariable("id") Long id,
                       @RequestBody City city) {

        City cityFromDb = service.getCityById(id);
        BeanUtils.copyProperties(city, cityFromDb, "id");
        return service.addCity(cityFromDb);


    }

}

package org.spring.springboot.webflux.controller;

import java.lang.System.Logger.Level;

import org.spring.springboot.domain.City;
import org.spring.springboot.handler.CityHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/city")
public class CityWebFluxController {

    @Autowired
    private CityHandler cityHandler;

    @GetMapping(value = "/{id}")
    public Mono<City> findCityById(@PathVariable("id") Long id) {
      System.Logger logger = System.getLogger(getClass().getName()); 
      logger.log(Level.INFO, "findCityById id = "+ id);
      return cityHandler.findCityById(id);
    }

    @GetMapping()
    public Flux<City> findAllCity() {
        return cityHandler.findAllCity();
    }

    @PostMapping()
    public Mono<City> saveCity(@RequestBody City city) {
        return cityHandler.save(city);
    }

    @PutMapping()
    public Mono<City> modifyCity(@RequestBody City city) {
        return cityHandler.modifyCity(city);
    }

    @DeleteMapping(value = "/deleteCityWithId/{id}")
    public Mono<Long> deleteCityWithId(@PathVariable("id") Long id) {
      System.Logger logger = System.getLogger(getClass().getName()); 
      logger.log(Level.INFO, "deleteCityWithId id = "+id);
      return cityHandler.deleteCityWithId(id);
    }
    
    @DeleteMapping(value = "/{id}")
    public Mono<Void> deleteCity(@PathVariable("id") Long id) {
      System.Logger logger = System.getLogger(getClass().getName()); 
      logger.log(Level.INFO, "deleteCity id = "+id);
      return cityHandler.deleteCity(id);
    }
}

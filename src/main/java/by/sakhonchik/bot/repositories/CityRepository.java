package by.sakhonchik.bot.repositories;

import by.sakhonchik.bot.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link City} class.
 *
 * @author Dmitry Sakhonchik
 * @version 1.0
 */

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findCityByName(String cityName);

    boolean existsCityByName(String cityName);

}

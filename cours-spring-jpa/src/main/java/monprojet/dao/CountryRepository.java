package monprojet.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import monprojet.entity.Country;

// This will be AUTO IMPLEMENTED by Spring 
//

public interface CountryRepository extends JpaRepository<Country, Integer> {
    HashMap<Country,Integer> lesPays = new HashMap<>();

    @Query("SELECT SUM(city.population) AS pop FROM City city GROUP BY country_id HAVING country_id=:id")
    public Integer pop( Integer id);

}

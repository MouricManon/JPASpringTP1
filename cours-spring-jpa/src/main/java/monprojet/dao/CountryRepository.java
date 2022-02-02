package monprojet.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import monprojet.entity.Country;

// This will be AUTO IMPLEMENTED by Spring 
//

public interface CountryRepository extends JpaRepository<Country, Integer> {
    HashMap<Country,Integer> lesPays = new HashMap<>();

    @Query("SELECT SUM(city.population) AS pop FROM City city GROUP BY country_id HAVING country_id=:id")
    public Integer pop( Integer id);

    @Query(value="SELECT name FROM Country country",nativeQuery=true)
    public List<String> listePays();


    public default Map<String,Integer> listePopPays(){
        Map<String, Integer> liste1 = new HashMap<>();
        List<String> liste = listePays();
        for(int i=0;i<liste.size();i++){
        liste1.put(liste.get(i), pop(i+1));
        }
        return liste1;
    }
}

package edu.logos.repository;

import edu.logos.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query("SELECT c FROM Country c WHERE LOWER(c.name) = :name")
    Country findCountryByName(@Param("name") String name);

}

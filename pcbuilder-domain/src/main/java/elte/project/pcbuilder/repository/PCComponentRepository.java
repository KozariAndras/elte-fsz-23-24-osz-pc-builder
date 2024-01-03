package elte.project.pcbuilder.repository;

import elte.project.pcbuilder.domain.components.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PCComponentRepository extends CrudRepository<PCComponent,Integer> {
        // Don't use this to query to get all the PCComponents it will find nothing
        // because there are no PCComponent types in the table since it's an Abstract class
        @Query("from PCComponent part where type(part) = :type")
        <T extends PCComponent> List<T> findPCComponent(@Param("type") Class<T> type);

        List<PCComponent> findByNameContainingIgnoreCase(String search);
        @Query("select distinct brand from PCComponent")
        List<String> findDistinctBrands();

}

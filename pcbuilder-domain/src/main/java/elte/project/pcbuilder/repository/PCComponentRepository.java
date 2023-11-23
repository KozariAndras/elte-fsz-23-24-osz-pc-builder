package elte.project.pcbuilder.repository;

import elte.project.pcbuilder.domain.components.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface PCComponentRepository extends CrudRepository<PCComponent,Integer> {

        List<PCComponent> findAllById(int id);
        List<PCComponent> findAllByBrand(String brand);
        List<PCComponent> findAllByName(String name);
        List<PCComponent> findAllByPriceIsLessThanEqual(BigDecimal price);
        List<PCComponent> findAllByPriceIsGreaterThanEqual(BigDecimal price);

        @Query("from PCComponent part where type(part) = CPU")
        List<CPU> findAllCPU();
}

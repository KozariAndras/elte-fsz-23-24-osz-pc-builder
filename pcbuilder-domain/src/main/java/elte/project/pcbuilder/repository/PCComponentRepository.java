package elte.project.pcbuilder.repository;

import elte.project.pcbuilder.domain.components.*;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface PCComponentRepository extends CrudRepository<PCComponent,Integer> {

        List<PCComponent> findAllById(int id);
        List<PCComponent> findAllByBrand(String brand);
        List<PCComponent> findAllByName(String name);
        List<PCComponent> findAllByPriceIsLessThanEqual(BigDecimal price);
        List<PCComponent> findAllByPriceIsGreaterThanEqual(BigDecimal price);

}

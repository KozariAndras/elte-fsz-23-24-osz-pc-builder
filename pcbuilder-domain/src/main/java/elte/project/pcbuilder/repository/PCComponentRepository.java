package elte.project.pcbuilder.repository;

import elte.project.pcbuilder.domain.components.PCComponent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PCComponentRepository extends CrudRepository<PCComponent,Integer> {


}

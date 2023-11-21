package elte.project.pcbuilder.repository;

import elte.project.pcbuilder.domain.user.Credential;
import org.springframework.data.repository.CrudRepository;

public interface CredentialRepository extends CrudRepository<Credential,Integer> {
}

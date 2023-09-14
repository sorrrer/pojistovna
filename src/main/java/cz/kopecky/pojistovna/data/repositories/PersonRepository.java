package cz.kopecky.pojistovna.data.repositories;

import cz.kopecky.pojistovna.data.entities.PersonEntity;
import cz.kopecky.pojistovna.models.dto.PersonDTO;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<PersonEntity,Long> {
}

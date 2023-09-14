package cz.kopecky.pojistovna.data.repositories;

import cz.kopecky.pojistovna.data.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
}

package cz.kopecky.pojistovna.models.services;

import cz.kopecky.pojistovna.models.dto.PersonDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface PersonService extends UserDetailsService {
    void create(PersonDTO person,boolean isAdmin);

}

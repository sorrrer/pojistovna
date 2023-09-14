package cz.kopecky.pojistovna.models.services;

import cz.kopecky.pojistovna.data.entities.PersonEntity;
import cz.kopecky.pojistovna.data.repositories.PersonRepository;
import cz.kopecky.pojistovna.models.dto.PersonDTO;
import cz.kopecky.pojistovna.models.exceptions.DuplicateEmailException;
import cz.kopecky.pojistovna.models.exceptions.PasswordDoNotException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void create(PersonDTO user, boolean isAdmin)
    {
        if(!user.getPassword().equals(user.getConfirmPassword()))
            throw new PasswordDoNotException();
        PersonEntity personEntity = new PersonEntity();
        personEntity.setEmail(passwordEncoder.encode(user.getPassword()));
        personEntity.setAdmin(isAdmin);
        try {
            personRepository.save(personEntity);
        }
        catch (DataIntegrityViolationException e)
        {
            throw new DuplicateEmailException();
        }
    }
}

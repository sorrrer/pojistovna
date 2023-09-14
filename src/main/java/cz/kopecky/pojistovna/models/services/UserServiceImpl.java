package cz.kopecky.pojistovna.models.services;

import cz.kopecky.pojistovna.data.entities.UserEntity;
import cz.kopecky.pojistovna.data.repositories.UserRepository;
import cz.kopecky.pojistovna.models.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(UserDTO user)
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(user.getFirstName());
        userEntity.setSecondName(user.getSecondName());
        userEntity.setAddress(user.getAddress());
        userEntity.setStreet(user.getStreet());
        userEntity.setEmail(user.getEmail());
        userEntity.setPsc(user.getPsc());
        userEntity.setPhoneNumber(user.getPhoneNumber());
        userRepository.save(userEntity);
    }

}

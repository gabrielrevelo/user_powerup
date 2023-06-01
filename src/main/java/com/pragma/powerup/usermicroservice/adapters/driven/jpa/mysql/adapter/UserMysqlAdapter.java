package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.MailAlreadyExistsException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.PersonAlreadyExistsException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.UserNotFoundException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IUserEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IUserRepository;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class UserMysqlAdapter implements IUserPersistencePort {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public User saveUser(User user) {
        if (userRepository.findByDniNumber(user.getDniNumber()).isPresent()) {
            throw new PersonAlreadyExistsException();
        }

        if (userRepository.existsByMail(user.getMail())){
            throw new MailAlreadyExistsException();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity userSaved = userRepository.save(userEntityMapper.toEntity(user));
        return userEntityMapper.toDomain(userSaved);
    }

    @Override
    public User findUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return userEntityMapper.toDomain(userEntity);
    }


}

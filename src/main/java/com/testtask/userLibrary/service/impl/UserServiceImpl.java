package com.testtask.userLibrary.service.impl;

import com.testtask.userLibrary.model.User;
import com.testtask.userLibrary.repository.UserRepository;
import com.testtask.userLibrary.service.UserServise;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServise {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll().stream().filter(u -> !u.isDeleted()).collect(Collectors.toList());
    }

    @Override
    public User getUserById(Long id) {
        User user = userRepository.getOne((long) Math.toIntExact(id));

        return user;
    }

    @Override
    public String getUserFullName(Long id) {
        User user = userRepository.getOne((long) Math.toIntExact(id));
        String fullName = user.getFirstName().concat(" ").concat(user.getLastName());
        return fullName;
    }


    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User updateUser(User user,String udpFirstName,String updSecondName) {
        User userUpd = userRepository.getOne(user.getId());
        userUpd.setFirstName(udpFirstName);
        userUpd.setLastName(updSecondName);
        userRepository.save(userUpd);
        return userUpd;
    }

    @Override
    public boolean delete(Long id) {
        User user = userRepository.getOne((long) Math.toIntExact(id));
        user.setDeleted(true);

        userRepository.save(user);
        return true;
    }


}

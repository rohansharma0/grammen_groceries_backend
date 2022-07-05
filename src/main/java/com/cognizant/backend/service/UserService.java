package com.cognizant.backend.service;

import com.cognizant.backend.model.User;
import com.cognizant.backend.payload.UserDto;

import java.util.List;

public interface UserService {

    UserDto registerUser(UserDto userDto);

    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user , long userId);

    UserDto getUserById(long userId);

    List<UserDto> getAllUsers();

    void deleteUser(long userId);


}

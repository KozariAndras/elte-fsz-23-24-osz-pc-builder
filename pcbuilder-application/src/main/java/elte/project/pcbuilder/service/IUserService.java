package elte.project.pcbuilder.service;

import elte.project.pcbuilder.domain.DTOs.UserDto;
import elte.project.pcbuilder.domain.user.User;

public interface IUserService {

    public User RegisterNewUser(UserDto userDto);
}

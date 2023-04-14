package com.bni.test.services;

import com.bni.test.dto.request.CreateUserDto;
import com.bni.test.dto.request.UpdateUserRequestDTO;
import com.bni.test.dto.request.UpdateUserSettingRequestDTO;
import com.bni.test.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> getAllUsers();

    public User createUser(CreateUserDto dto);

    public Optional findUserById(Long id);

    public Page<User> getAllUsers(Integer pageNumber, Integer size);

    public User updateUser(Long id, UpdateUserRequestDTO dto);

    public void deleteUser(Long id);

    public User reactivateUser(Long id);

    public User updateUserSetting(Long id, List<UpdateUserSettingRequestDTO> dto);
}

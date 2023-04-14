package com.bni.test.services;

import com.bni.test.dto.request.CreateUserDto;
import com.bni.test.entity.User;
import com.bni.test.entity.UserSetting;
import com.bni.test.repository.UserRepository;
import com.bni.test.repository.UserSettingRepository;
import com.bni.test.services.impl.UserServiceImpl;
import com.bni.test.utils.DateUtils;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.mockito.junit.jupiter.MockitoExtension;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserSettingRepository userSettingRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    private List<User> userList;

    private UserSetting userSetting = null;

    private EasyRandom easyRandom = new EasyRandom();

    @DisplayName("Unit Test Service - getAlUsers()")
    @Test
    public void getAllUsers() {
        Integer numberOfObjects = 10;
        List<User> expectedList = easyRandom.objects(User.class, numberOfObjects).collect(Collectors.toList());

        when(userRepository.findAll()).thenReturn(expectedList);

        List<User> actualList = userRepository.findAll();

        assertEquals(expectedList.size(), actualList.size());
    }

    @DisplayName("Unit Test Service - createUser")
    @Test
    public void createUser() {
        User expectedUser = easyRandom.nextObject(User.class);

        CreateUserDto dto = new CreateUserDto();
        dto.setSsn("SSSSSSSSSSSSSSN1");
        dto.setFirst_name("UTOR");
        dto.setMiddle_name("Erikson");
        dto.setBirth_date("1980-01-01");

        User user = new User();
        user.setSsn(expectedUser.getSsn());
        user.setFirst_name(expectedUser.getFirst_name());
        user.setMiddle_name(expectedUser.getMiddle_name());

        user.setBirth_date(DateUtils.parseDate(dto.getBirth_date()));

        when(userRepository.save(user)).thenReturn(user);

        User actualUser = userService.createUser(dto);

        assertEquals(actualUser, user);
    }
}

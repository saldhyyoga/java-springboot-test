package com.bni.test.services.impl;

import com.bni.test.dto.request.CreateUserDto;
import com.bni.test.dto.request.UpdateUserRequestDTO;
import com.bni.test.dto.request.UpdateUserSettingRequestDTO;
import com.bni.test.entity.User;
import com.bni.test.entity.UserSetting;
import com.bni.test.entity.UserSettingEnum;
import com.bni.test.exception.BadRequestException;
import com.bni.test.repository.UserRepository;
import com.bni.test.repository.UserSettingRepository;
import com.bni.test.services.UserService;
import com.bni.test.utils.DateUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private UserSettingRepository userSettingRepository;

//    private DateUtils dateUtils;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(CreateUserDto dto) {
        User user = new User();
        user.setSsn(dto.getSsn());
        user.setFirst_name(dto.getFirst_name());
        user.setMiddle_name(dto.getMiddle_name());

        user.setBirth_date(DateUtils.parseDate(dto.getBirth_date()));

        List<UserSetting> userSettings = new ArrayList<>();
        userSettings.add(new UserSetting("biometric_login", "false"));
        userSettings.add(new UserSetting("push_notification", "false"));
        userSettings.add(new UserSetting("sms_notification", "false"));
        userSettings.add(new UserSetting("show_onboarding", "false"));
        userSettings.add(new UserSetting("widget_order", "1,2,3,4,5"));

        user.setUser_settings(userSettings);
        User createdUser = userRepository.save(user);

        userSettingRepository.saveAll(userSettings);
        return createdUser;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Page<User> getAllUsers(Integer pageNumber, Integer size) {
        Pageable paging = PageRequest.of(pageNumber - 1, size);
        return userRepository.findAll(paging);
    }

    @Override
    public User updateUser(Long id, UpdateUserRequestDTO dto) {
        User user = userRepository.findById(id).orElseThrow(() -> new BadRequestException("user not found"));

        user.setFirst_name(dto.getFirst_name());
        user.setLast_name(dto.getLast_name());
        user.setSsn(dto.getSsn());
        user.setBirth_date(DateUtils.parseDate(dto.getBirth_date()));

        userRepository.save(user);

        return user;
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new BadRequestException("user not found"));

        user.setDeleted_time(new Date());
        user.setIs_active(false);
        userRepository.save(user);
    }

    @Override
    public User reactivateUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new BadRequestException("user not found"));

        user.setDeleted_time(null);
        user.setIs_active(true);
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUserSetting(Long id, List<UpdateUserSettingRequestDTO> dto) {
        List<UserSetting> userSettings = userSettingRepository.findByUserId(id);

        User user = userRepository.findById(id).orElseThrow(() -> new BadRequestException("user not found"));

        String biometric_login = dto.get(0).getBiometric_login();
        String push_notification = dto.get(0).getPush_notification();
        String sms_notification = dto.get(0).getSms_notification();
        String sms_onboarding = dto.get(0).getShow_onboarding();
        String widget_order = dto.get(0).getShow_onboarding();

        List<UserSetting> userSettingList = user.getUser_settings().stream().map( usr -> {
            if (usr.getKey() == "biometric_login") usr.setValue(biometric_login);
            else if(usr.getKey() == "push_notification") usr.setValue(push_notification);
            else if(usr.getKey() == "sms_notification") usr.setValue(sms_notification);
            else if(usr.getKey() == "sms_onboarding") usr.setValue(sms_onboarding);
            else if(usr.getKey() == "widget_order") usr.setValue(widget_order);

            return usr;
        }).collect(Collectors.toList());

        user.setUser_settings(userSettingList);

//        userRepository.save(user);

        return user;
    }

}

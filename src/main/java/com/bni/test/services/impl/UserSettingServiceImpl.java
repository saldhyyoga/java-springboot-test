package com.bni.test.services.impl;


import com.bni.test.dto.request.UpdateUserSettingRequestDTO;
import com.bni.test.entity.User;
import com.bni.test.entity.UserSetting;
import com.bni.test.repository.UserSettingRepository;
import com.bni.test.services.UserSettingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@AllArgsConstructor
public class UserSettingServiceImpl implements UserSettingService {

    private UserSettingRepository userSettingRepository;


    @Override
    public List<UserSetting> updateUserSetting(Long id, List<UpdateUserSettingRequestDTO> dto) {
        return userSettingRepository.findByUserId(id);
    }
}

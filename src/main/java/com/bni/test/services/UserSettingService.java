package com.bni.test.services;

import com.bni.test.dto.request.UpdateUserSettingRequestDTO;
import com.bni.test.entity.User;
import com.bni.test.entity.UserSetting;

import java.util.List;

public interface UserSettingService {

    public List<UserSetting> updateUserSetting(Long id, List<UpdateUserSettingRequestDTO> dto);
}

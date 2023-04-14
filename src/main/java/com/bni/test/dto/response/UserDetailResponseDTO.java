package com.bni.test.dto.response;

import com.bni.test.entity.User;
import com.bni.test.entity.UserSetting;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class UserDetailResponseDTO {

    private User user_data;

    private List<UserSetting> user_settings;
}

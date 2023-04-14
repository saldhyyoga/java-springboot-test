package com.bni.test.controller;

import com.bni.test.dto.UserSettingDto;
import com.bni.test.entity.UserSetting;
import com.bni.test.repository.UserSettingRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/usersettings")
@AllArgsConstructor
public class UserSettingController {

    private UserSettingRepository userSettingRepository;

//    @PostMapping()
//    public ResponseEntity<String> createUserSetting(@RequestBody UserSettingDto body) {
//        UserSetting userSetting = new UserSetting();
//        userSetting.set
//        var result = userSettingRepository.save()
//    }
}

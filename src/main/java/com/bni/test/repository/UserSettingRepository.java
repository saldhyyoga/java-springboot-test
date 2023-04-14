package com.bni.test.repository;

import com.bni.test.entity.UserSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserSettingRepository extends JpaRepository<UserSetting, Long> {

    @Query( "SELECT us FROM User u join u.user_settings us WHERE u.id = :userId")
    List<UserSetting> findByUserId(Long userId);
}

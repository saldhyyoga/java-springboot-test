package com.bni.test.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_setting")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSetting {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "testkey")
    private String key;

    @Column(name = "testvalue")
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public UserSetting(String key, String value) {
        this.key = key;
        this.value = value;
    }
}

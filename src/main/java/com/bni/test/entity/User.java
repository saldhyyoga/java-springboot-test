package com.bni.test.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "app_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "ssn", nullable = false, length = 16)
    private String ssn;

    @Column(name = "first_name", nullable = false, length = 100)
    private String first_name;

    @Column(name = "middle_name", nullable = true, length = 100)
    private String middle_name;

    @Column(name = "last_name", nullable = true, length = 100)
    private String last_name;

    @Column(name = "family_name", nullable = true, length = 100)
    private String family_name;

    @Column(name = "birth_date")
    private Date birth_date;

    @CreationTimestamp
    private Date created_time;

    @UpdateTimestamp
    private Date updated_time;

    @Column(name = "created_by", nullable = false, length = 100)
    private String created_by = "SYSTEM";

    @Column(name = "updated_by", nullable = false, length = 100)
    private String updated_by = "SYSTEM";

    @Column(name = "is_active", nullable = false)
    private Boolean is_active = true;

    @Column(name = "deleted_time", nullable = true)
    private Date deleted_time;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<UserSetting> user_settings;
}

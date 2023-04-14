package com.bni.test.dto.response;

import com.bni.test.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class UserListPaginationDTO {
    private List<User> user_data;
    private Integer max_records;
    private Integer offset;
}

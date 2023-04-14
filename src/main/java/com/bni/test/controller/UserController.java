package com.bni.test.controller;

import com.bni.test.dto.request.UpdateUserRequestDTO;
import com.bni.test.dto.request.UpdateUserSettingRequestDTO;
import com.bni.test.dto.response.UserDetailResponseDTO;
import com.bni.test.dto.response.UserListPaginationDTO;
import com.bni.test.entity.User;
import com.bni.test.dto.request.CreateUserDto;
import com.bni.test.entity.UserSetting;
import com.bni.test.repository.UserRepository;
import com.bni.test.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
@AllArgsConstructor
public class UserController {

    private UserRepository userRepository;

    private UserService userService;

    @GetMapping()
    public ResponseEntity<UserListPaginationDTO> getAllUsers(
            @RequestParam(name = "max_records", required = true, defaultValue = "5") Integer max_records,
            @RequestParam(name = "offset", required = true, defaultValue = "0") Integer offset
    ) {
        Page<User> users = userService.getAllUsers(offset, max_records);
        System.out.println("userss" + users);

        UserListPaginationDTO userListPaginationDTO = new UserListPaginationDTO();
        userListPaginationDTO.setUser_data(users.getContent());
        userListPaginationDTO.setMax_records(max_records);
        userListPaginationDTO.setOffset(offset);

        return new ResponseEntity<>(userListPaginationDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody CreateUserDto dto) {
            User user = userService.createUser(dto);

            return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailResponseDTO> detailUser(@PathVariable Long id) {
        Optional<User> user = userService.findUserById(id);

        if (user.isPresent()) {
            List<UserSetting> userSetting = user.get().getUser_settings();
            user.get().setUser_settings(null);
            UserDetailResponseDTO userDetailResponseDTO = new UserDetailResponseDTO();
            userDetailResponseDTO.setUser_data(user.get());
            userDetailResponseDTO.setUser_settings(userSetting);

            return new ResponseEntity<>(userDetailResponseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable Long id,
            @RequestBody UpdateUserRequestDTO dto
            ) {
        return userService.updateUser(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        System.out.println("id" + id);
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/refresh")
    public ResponseEntity<User> reactivateUser(@PathVariable Long id) {
        User user = userService.reactivateUser(id);

        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PutMapping("/{id}/settings")
    public ResponseEntity<User> updateUserSetting(@PathVariable Long id, @Valid @RequestBody List<UpdateUserSettingRequestDTO> dto) {
        User user = userService.reactivateUser(id);

        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}

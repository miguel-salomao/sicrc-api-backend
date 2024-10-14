package com.salomao.dtos;

import com.salomao.enums.ProfileEnum;
import com.salomao.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {
    private String name;
    private String email;
    private String password;
    private Integer age;
    private String phone;
    private StatusEnum status;
    private ProfileEnum profile;
    private String registration;
}

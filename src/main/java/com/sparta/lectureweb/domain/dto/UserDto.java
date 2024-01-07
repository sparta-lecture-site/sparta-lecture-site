package com.sparta.lectureweb.domain.dto;

import com.sparta.lectureweb.domain.Authority;
import com.sparta.lectureweb.domain.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    @Email
    private String email;
    @Size(min = 8, max = 15, message = "비밀번호는 8자 이상 15자 이하이어야 합니다.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$",
            message = "알파벳 대소문자, 숫자, 특수문자를 포함해야 합니다.")
    private String password;
    private String gender;
    private String phone;
    private String address;
    private Authority authority;

    public UserDto(User entity) {
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.gender = entity.getGender();
        this.phone = entity.getPhone();
        this.address = entity.getAddress();
        this.authority = entity.getAuthority();
    }

}

package com.example.demo.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NotBlank(message = "First Name không được để trống")
    @Size(min = 5, max = 45,
            message = "First Name phải từ 5 đến 45 ký tự")
    private String firstName;

    @NotBlank(message = "Last Name không được để trống")
    @Size(min = 5, max = 45,
            message = "Last Name phải từ 5 đến 45 ký tự")
    private String lastName;

    @Pattern(
            regexp = "^(0|\\+84)[0-9]{9}$",
            message = "Số điện thoại không hợp lệ"
    )
    private String phoneNumber;

    @NotNull(message = "Tuổi không được để trống")
    @Min(value = 18, message = "Tuổi phải từ 18 trở lên")
    @Max(value = 50, message = "Tuổi không được lớn hơn 50")
    private Integer age;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;
}
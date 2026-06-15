package org.example.music.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "songs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(max = 800,
            message = "Tên bài hát không được vượt quá 800 ký tự")
    @Pattern(
            regexp = "^[^@;.=+\\-]*$",
            message = "Tên bài hát không được chứa ký tự đặc biệt (@ ; . = - +)"
    )
    private String name;

    @NotBlank(message = "Tên nghệ sĩ không được để trống")
    @Size(max = 300,
            message = "Tên nghệ sĩ không được vượt quá 300 ký tự")
    @Pattern(
            regexp = "^[^@;.=+\\-]*$",
            message = "Tên nghệ sĩ không được chứa ký tự đặc biệt (@ ; . = - +)"
    )
    private String artist;

    @NotBlank(message = "Thể loại không được để trống")
    @Size(max = 1000,
            message = "Thể loại không được vượt quá 1000 ký tự")
    @Pattern(
            regexp = "^[^@;.=+\\-]*$",
            message = "Thể loại chỉ được phép dùng dấu phẩy (,)"
    )
    private String genre;
}
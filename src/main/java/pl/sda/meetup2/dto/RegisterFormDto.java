package pl.sda.meetup2.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString(exclude = "password")
public class RegisterFormDto {

//    @NotNull(message = "pole nie może być puste")
    @NotEmpty(message = "pole nie może być puste")
//    @NotBlank(message = "nie mogą być same spacje")
    @Email(message = "must be an email address")
    private String email;


    @NotEmpty(message = "pole nie może być puste")
    @Size(min = 8, max = 30, message = "8 - 30 symbols")
    private String password;

//    @NotNull(message = "pole nie może być puste")
    @NotEmpty(message = "pole nie może być puste")
//    @NotBlank(message = "pole nie może być puste")
    @Pattern(regexp = "[^\\s\\\\]{1,50}", message = "no whitespaces, length between 1 and 50")
    private String nickname;
}

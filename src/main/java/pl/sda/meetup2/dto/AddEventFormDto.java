package pl.sda.meetup2.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class AddEventFormDto {

    @NotEmpty(message = "pole nie może być puste")
    private String eventName;

    @NotEmpty(message = "pole nie może być puste")
    @Size(min = 20, message = "minimum 20 znaków")
    private String description;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
//    @Future(message = "nie może być zeszła data")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
//    @Future(message = "nie może być zeszła data")
    private LocalDate endDate;

}

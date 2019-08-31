package pl.sda.meetup2.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
public class AddEventFormDto {

    @NotEmpty(message = "pole nie może być puste")
    private String eventName;

    @NotEmpty(message = "pole nie może być puste")
    @Size(min = 20, message = "minimum 20 znaków")
    private String description;

    @NotEmpty(message = "pole nie może być puste")
    private LocalDateTime startDate;

    @NotEmpty(message = "pole nie może być puste")
    private LocalDateTime endDate;

}

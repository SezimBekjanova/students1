package kg.megacom.students1.models.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseDto {
    Long id;
    String title;
    double price;
    String duration;
}

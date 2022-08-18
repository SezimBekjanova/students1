package kg.megacom.students1.models.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherDto {
    Long id;
    String name;
    String surname;
    String title;
}

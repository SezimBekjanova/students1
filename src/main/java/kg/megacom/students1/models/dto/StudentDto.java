package kg.megacom.students1.models.dto;

import kg.megacom.students1.models.enums.StudentStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentDto {
    Long id;
    String name;
    String surname;
    String title;
    StudentStatus status;
}

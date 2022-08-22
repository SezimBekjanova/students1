package kg.megacom.students1.models.dto;

import kg.megacom.students1.models.enums.StudentStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    Long id;
    String name;
    String surname;
    String title;
    StudentStatus status;
}

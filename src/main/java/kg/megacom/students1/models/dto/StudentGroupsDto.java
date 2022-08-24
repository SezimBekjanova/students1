package kg.megacom.students1.models.dto;

import kg.megacom.students1.models.enums.StudentStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class StudentGroupsDto {
    Long id;
    Date startDate;
    Date endDate;
    GroupDto group;
    StudentDto student;
    StudentStatus status;

}

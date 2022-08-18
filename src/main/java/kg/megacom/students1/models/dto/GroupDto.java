package kg.megacom.students1.models.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupDto {
    Long id;
    String name;
    Date startDate;
    Date endDate;
    CourseDto course;
    TeacherDto teacher;
}

package kg.megacom.students1.models.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LessonDto {
    Long id;
    Date day;
    GroupDto group;
}

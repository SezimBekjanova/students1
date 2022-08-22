package kg.megacom.students1.mappers;

import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.dto.StudentDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentMapper {
/*    private final ModelMapper modelMapper;
    public Student teEntity(StudentDto studentDto){
        return Objects.isNull(studentDto) ?null : modelMapper.map(studentDto,  Student.class);
    }
    public StudentDto toDto(Student student){
        return Objects.isNull(student) ? null : modelMapper.map(student,StudentDto.class);
    }*/
}


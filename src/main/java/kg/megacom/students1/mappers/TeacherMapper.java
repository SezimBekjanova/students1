package kg.megacom.students1.mappers;

import kg.megacom.students1.models.Teacher;
import kg.megacom.students1.models.dto.TeacherDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TeacherMapper {
    private  final ModelMapper modelMapper;
    public Teacher toEntity(TeacherDto teacherDto){
        return Objects.isNull(teacherDto) ? null : modelMapper.map(teacherDto, Teacher.class);
    }
    public TeacherDto toDto(Teacher teacher){
        return Objects.isNull(teacher) ? null : modelMapper.map(teacher, TeacherDto.class);
    }
    public List<TeacherDto> toDtoList(List<Teacher> teacherList) {
        return teacherList.stream().map(teacher -> modelMapper.map(teacher, TeacherDto.class))
                .collect(Collectors.toList());
    }
}

package kg.megacom.students1.mappers;

import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.dto.CourseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class CourseMapper {
    private final ModelMapper modelMapper;
    public Course toEntity(CourseDto courseDto){
        return Objects.isNull(courseDto) ? null : modelMapper.map(courseDto, Course.class);
    }
    public CourseDto toDto(Course course){
        return Objects.isNull(course) ? null : modelMapper.map(course, CourseDto.class);
    }
    public List<CourseDto> toDtoList(List<Course> courseList){
        return courseList.stream().map(course -> modelMapper.map(course, CourseDto.class))
                .collect(Collectors.toList());
    }
}

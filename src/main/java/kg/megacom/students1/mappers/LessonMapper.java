package kg.megacom.students1.mappers;

import kg.megacom.students1.models.Lesson;
import kg.megacom.students1.models.dto.LessonDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Component
@RequiredArgsConstructor
public class LessonMapper {
    private final ModelMapper modelMapper;
    public Lesson toEntity(LessonDto lessonDto){
        return  Objects.isNull(lessonDto) ? null :  modelMapper.map(lessonDto,  Lesson.class);
    }
    public LessonDto toDto(Lesson lesson){
        return Objects.isNull(lesson) ? null : modelMapper.map(lesson, LessonDto.class);
    }
    public List<LessonDto> toDtoList(List<Lesson> lessonList){
        return  lessonList.stream().map(lesson -> modelMapper.map(lesson, LessonDto.class))
                .collect(Collectors.toList());
    }
}

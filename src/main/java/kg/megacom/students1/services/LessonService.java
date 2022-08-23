package kg.megacom.students1.services;

import kg.megacom.students1.models.Lesson;
import kg.megacom.students1.models.dto.LessonDto;

import java.util.List;

public interface LessonService {
    Lesson createLesson(LessonDto lessonDto);
    List<LessonDto> findAll();
}

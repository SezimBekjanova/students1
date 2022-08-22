package kg.megacom.students1.services.impl;

import kg.megacom.students1.models.Lesson;
import kg.megacom.students1.models.repositiries.LessonRepo;
import kg.megacom.students1.services.LessonService;
import org.springframework.stereotype.Service;

@Service
public class LessonServiceImpl implements LessonService {
    private final LessonRepo lessonRepo;

    public LessonServiceImpl(LessonRepo lessonRepo){
        this.lessonRepo = lessonRepo;
    }

    @Override
    public Lesson createLesson(Lesson lesson) {
        return lessonRepo.save(lesson);
    }
}

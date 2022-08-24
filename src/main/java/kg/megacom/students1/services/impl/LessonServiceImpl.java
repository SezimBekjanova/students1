package kg.megacom.students1.services.impl;

import kg.megacom.students1.mappers.LessonMapper;
import kg.megacom.students1.models.Lesson;
import kg.megacom.students1.models.dto.LessonDto;
import kg.megacom.students1.repositiries.LessonRepo;
import kg.megacom.students1.services.LessonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {
    private final LessonRepo lessonRepo;
private  final LessonMapper lessonMapper;

    public LessonServiceImpl(LessonRepo lessonRepo, LessonMapper lessonMapper) {
        this.lessonRepo = lessonRepo;
        this.lessonMapper = lessonMapper;
    }

    @Override
    public Lesson createLesson(LessonDto lessonDto) {
        Lesson lesson = lessonMapper.toEntity(lessonDto);
        return lessonRepo.save(lesson);
    }

    @Override
    public List<LessonDto> findAll() {
        List<Lesson> lessonList = lessonRepo.findAll();
        return lessonMapper.toDtoList(lessonList);
    }

    @Override
    public Lesson update(Long id, Long group) {
        lessonRepo.update(id,group);
        return lessonRepo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        lessonRepo.delete(lessonRepo.findById(id).get());

    }
}

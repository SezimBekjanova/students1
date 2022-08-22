package kg.megacom.students1.controllers;

import kg.megacom.students1.models.Lesson;
import kg.megacom.students1.services.LessonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lesson")
public class LessonController {
    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }
    @PostMapping("/add")
    public Object createLesson(@RequestBody Lesson lesson){
        return lessonService.createLesson(lesson);
    }
}

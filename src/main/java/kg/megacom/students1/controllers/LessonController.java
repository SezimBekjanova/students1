package kg.megacom.students1.controllers;

import kg.megacom.students1.models.Lesson;
import kg.megacom.students1.models.dto.LessonDto;
import kg.megacom.students1.services.LessonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lesson")
public class LessonController {
    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }
    @PostMapping("/add")
    public Object createLesson(@RequestBody LessonDto lessonDto){
        return lessonService.createLesson(lessonDto);
    }
    @PutMapping("/update")
    public Lesson update(
            @RequestParam Long id,
            @RequestParam Long group
    ){
        return lessonService.update(id,group);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        lessonService.delete(id);
    }
}

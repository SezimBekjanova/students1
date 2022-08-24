package kg.megacom.students1.controllers;

import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.dto.CourseDto;
import kg.megacom.students1.services.CourseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/add")
    public Object createCourse(@RequestBody CourseDto courseDto){
        return courseService.createCourse(courseDto);
    }
    @DeleteMapping("/delete")
    public  void delete(@RequestParam Long id){
        courseService.delete(id);
    }
    @PutMapping("/update")
    public Course update(@RequestParam Long id, @RequestParam double price){
        return courseService.update(id,price);
    }
}

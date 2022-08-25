package kg.megacom.students1.services;

import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.dto.CourseDto;

import java.util.List;

public interface CourseService {
    Course createCourse(CourseDto courseDto);
    List<CourseDto> findAll();
    Course update(Long id,double price);
    void delete(Long id);
    Course findById(Long id);
}

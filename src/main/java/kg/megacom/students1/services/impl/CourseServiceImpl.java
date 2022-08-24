package kg.megacom.students1.services.impl;

import kg.megacom.students1.mappers.CourseMapper;
import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.dto.CourseDto;
import kg.megacom.students1.repositiries.CourseRepo;
import kg.megacom.students1.services.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;
    private final CourseMapper courseMapper;
    public CourseServiceImpl(CourseRepo courseRepo, CourseMapper courseMapper){
        this.courseRepo = courseRepo;
        this.courseMapper = courseMapper;
    }
    @Override
    public Course createCourse(CourseDto courseDto) {
        Course course = courseMapper.toEntity(courseDto);
        courseRepo.save(course);
        return course;
    }
    @Override
    public List<CourseDto> findAll() {
        List<Course> courseList = courseRepo.findAll();
        return courseMapper.toDtoList(courseList);
    }

    @Override
    public Course update(Long id, double price) {
        courseRepo.update(id,price);
        return courseRepo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        courseRepo.delete(courseRepo.findById(id).get());
    }

}
package kg.megacom.students1.services.impl;

import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.repositiries.CourseRepo;
import kg.megacom.students1.models.repositiries.GroupRepo;
import kg.megacom.students1.services.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;
    public CourseServiceImpl(CourseRepo courseRepo){
        this.courseRepo = courseRepo;
    }
    @Override
    public Course createCourse(Course course) {
        return courseRepo.save(course);
    }
}
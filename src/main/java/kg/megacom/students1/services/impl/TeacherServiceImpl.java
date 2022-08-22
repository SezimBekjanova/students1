package kg.megacom.students1.services.impl;

import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.Teacher;
import kg.megacom.students1.models.repositiries.StudentRepo;
import kg.megacom.students1.models.repositiries.TeacherRepo;
import kg.megacom.students1.services.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepo teacherRepo;

    public  TeacherServiceImpl(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }
}

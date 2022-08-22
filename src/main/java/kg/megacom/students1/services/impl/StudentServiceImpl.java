package kg.megacom.students1.services.impl;

import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.repositiries.StudentRepo;
import kg.megacom.students1.services.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    public  StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }
    @Override
    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }


}

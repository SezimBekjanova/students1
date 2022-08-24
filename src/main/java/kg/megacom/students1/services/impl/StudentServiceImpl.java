package kg.megacom.students1.services.impl;

import kg.megacom.students1.mappers.StudentMapper;
import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.dto.StudentDto;
import kg.megacom.students1.repositiries.StudentRepo;
import kg.megacom.students1.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;

    public  StudentServiceImpl(StudentRepo studentRepo, StudentMapper studentMapper) {
        this.studentRepo = studentRepo;
        this.studentMapper = studentMapper;
    }
    @Override
    public Student createStudent(StudentDto studentDto) {
        Student student = studentMapper.toEntity(studentDto);
        studentRepo.save(student);
        return student;
    }

    @Override
    public List<StudentDto> findAll() {
        List<Student> studentList = studentRepo.findAll();
        return studentMapper.toDtoList(studentList);

    }

    @Override
    public Student update(Long id, String title) {
        //Optional<Student> student = studentRepo.findById(id);
       // student.get().setTitle(title);
        studentRepo.update(id, title);
        return studentRepo.findById(id).get();

    }

    @Override
    public Student delete(Long id) {
        //
        Student student = studentRepo.findById(id).get();
        student.setDeleted(true);
        studentRepo.save(student);
        return studentRepo.findById(id).get();
    }

    @Override
    public List<Student> findAllNotDelete() {
        return studentRepo.findAllByIsDeletedIsFalse();
    }


}
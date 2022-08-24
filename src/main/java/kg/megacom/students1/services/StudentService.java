package kg.megacom.students1.services;

import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.dto.StudentDto;

import java.util.List;

public interface StudentService {
    Student createStudent(StudentDto studentDto);
    List<StudentDto> findAll();
    Student update(Long id, String title);
    void delete (Long id);
}

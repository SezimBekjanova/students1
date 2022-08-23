package kg.megacom.students1.services;

import kg.megacom.students1.models.Teacher;
import kg.megacom.students1.models.dto.TeacherDto;

import java.util.List;

public interface TeacherService {
    Teacher createTeacher(TeacherDto teacherdto);
    List<TeacherDto> findAll();
}

package kg.megacom.students1.services.impl;

import kg.megacom.students1.mappers.TeacherMapper;
import kg.megacom.students1.models.Teacher;
import kg.megacom.students1.models.dto.TeacherDto;
import kg.megacom.students1.repositiries.TeacherRepo;
import kg.megacom.students1.services.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepo teacherRepo;
    private final TeacherMapper teacherMapper;

    public  TeacherServiceImpl(TeacherRepo teacherRepo, TeacherMapper teacherMapper) {
        this.teacherRepo = teacherRepo;
        this.teacherMapper = teacherMapper;
    }

    public Teacher createTeacher(TeacherDto teacherDto) {
        Teacher teacher = teacherMapper.toEntity(teacherDto);
        teacherRepo.save(teacher);
        return teacher;
    }

    @Override
    public List<TeacherDto> findAll() {
        List<Teacher> teacherList = teacherRepo.findAll();
        return teacherMapper.toDtoList(teacherList);
    }
}

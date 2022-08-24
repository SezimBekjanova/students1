package kg.megacom.students1.services.impl;

import kg.megacom.students1.mappers.StudentGroupsMapper;
import kg.megacom.students1.models.StudentGroups;
import kg.megacom.students1.models.dto.StudentGroupsDto;
import kg.megacom.students1.repositiries.StudentGroupsRepo;
import kg.megacom.students1.services.StudentGroupsService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class  StudentGroupsServiceImpl implements StudentGroupsService {
    private final StudentGroupsRepo studentGroupsRepo;
    private final StudentGroupsMapper studentGroupsMapper;

    public StudentGroupsServiceImpl(StudentGroupsRepo studentGroupsRepo, StudentGroupsMapper studentGroupsMapper) {
        this.studentGroupsRepo = studentGroupsRepo;
        this.studentGroupsMapper = studentGroupsMapper;
    }

    @Override
    public StudentGroups createStudentGroups(StudentGroupsDto studentGroupsDto) {
        StudentGroups studentGroups = studentGroupsMapper.toEntity(studentGroupsDto);
        studentGroupsRepo.save(studentGroups);
        return studentGroups;
    }

    @Override
    public List<StudentGroupsDto> findAll() {
        List<StudentGroups> studentGroupsList = studentGroupsRepo.findAll();
        return studentGroupsMapper.toDtoList(studentGroupsList);
    }

    @Override
    public StudentGroups update(Long id, Date end_date) {
        studentGroupsRepo.update(id, end_date);
        return studentGroupsRepo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        studentGroupsRepo.delete(studentGroupsRepo.findById(id).get());
    }

}

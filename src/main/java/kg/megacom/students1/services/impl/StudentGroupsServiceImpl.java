package kg.megacom.students1.services.impl;

import kg.megacom.students1.mappers.StudentGroupsMapper;
import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.StudentGroups;
import kg.megacom.students1.models.dto.StudentGroupsDto;
import kg.megacom.students1.models.enums.StudentStatus;
import kg.megacom.students1.repositiries.GroupRepo;
import kg.megacom.students1.repositiries.StudentGroupsRepo;
import kg.megacom.students1.repositiries.StudentRepo;
import kg.megacom.students1.services.StudentGroupsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class  StudentGroupsServiceImpl implements StudentGroupsService {
    private final StudentGroupsRepo studentGroupsRepo;
    private final StudentGroupsMapper studentGroupsMapper;
    private final StudentRepo studentRepo;
    private final GroupRepo groupRepo;

    public StudentGroupsServiceImpl(StudentGroupsRepo studentGroupsRepo, StudentGroupsMapper studentGroupsMapper, StudentRepo studentRepo, GroupRepo groupRepo) {
        this.studentGroupsRepo = studentGroupsRepo;
        this.studentGroupsMapper = studentGroupsMapper;
        this.studentRepo = studentRepo;
        this.groupRepo = groupRepo;
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
    @Override
    public ResponseEntity createStudentGroupsV2(Date startDate, Date endDate, Long studentId, Long groupId) {
        try {
            Student student = studentRepo.findById(studentId).get();
            if (student.isDeleted()) {
                return ResponseEntity.ok("Student is delete");
            }
            StudentGroups studentGroups = new StudentGroups();
            studentGroups.setStudent(studentRepo.findById(studentId).get());
            studentGroups.setGroup(groupRepo.findById(groupId).get());
            studentGroups.setStartDate(startDate);
            studentGroups.setEndDate(endDate);
            studentGroups.setStatus(StudentStatus.STUDIES);
            return ResponseEntity.ok(studentGroupsRepo.save(studentGroups));
        }catch (Exception e){
            return ResponseEntity.ok("Student doesn't exists");
        }
    }

}

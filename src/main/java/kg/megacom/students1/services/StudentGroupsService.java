package kg.megacom.students1.services;

import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.StudentGroups;
import kg.megacom.students1.models.dto.StudentGroupsDto;

import java.util.Date;
import java.util.List;

public interface StudentGroupsService {
    StudentGroups createStudentGroups(StudentGroupsDto studentGroupsDto);
    List<StudentGroupsDto> findAll();
    StudentGroups update(Long id, Date end_date);
    void delete(Long id);
}

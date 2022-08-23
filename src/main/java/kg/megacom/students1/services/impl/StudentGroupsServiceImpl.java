package kg.megacom.students1.services.impl;

import kg.megacom.students1.models.StudentGroups;
import kg.megacom.students1.repositiries.StudentGroupsRepo;
import kg.megacom.students1.services.StudentGroupsService;
import org.springframework.stereotype.Service;

@Service
public class  StudentGroupsServiceImpl implements StudentGroupsService {
    private final StudentGroupsRepo studentGroupsRepo;

    public StudentGroupsServiceImpl(StudentGroupsRepo studentGroupsRepo) {
        this.studentGroupsRepo = studentGroupsRepo;
    }

    @Override
    public StudentGroups createStudentGroups(StudentGroups studentGroups) {
        return studentGroupsRepo.save(studentGroups);
    }
}

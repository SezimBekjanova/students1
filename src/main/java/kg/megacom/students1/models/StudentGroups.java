package kg.megacom.students1.models;

import kg.megacom.students1.models.enums.StudentStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "student_groups")
public class StudentGroups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    Date startDate;
    @DateTimeFormat(pattern = "yyyy-mm-dd")

    Date endDate;
    @ManyToOne
    @JoinColumn(name = "group_id")
    Group group;
    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;
    @Enumerated(value = EnumType.STRING)
    private StudentStatus status;
    double summa;
}

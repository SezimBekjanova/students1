package kg.megacom.students1.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "groups")
public class Group {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Date startDate;
    Date endDate;
    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    Teacher teacher;
}

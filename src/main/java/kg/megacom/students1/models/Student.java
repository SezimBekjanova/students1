package kg.megacom.students1.models;

import kg.megacom.students1.models.enums.StudentStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "students")
public class Student {
        @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        String name;
        String surname;
        String title;
        @Enumerated(value = EnumType.STRING)
        StudentStatus status;
}

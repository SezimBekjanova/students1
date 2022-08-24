package kg.megacom.students1.models;

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
        @Column(name = "is_delete", columnDefinition = "boolean default false")
        boolean isDeleted;
}

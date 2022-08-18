package kg.megacom.students1.models;

import kg.megacom.students1.models.enums.PaymentStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date date_payments;
    @ManyToOne
    @JoinColumn(name = "group_id")
    Group group;
    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;
    @Enumerated(value = EnumType.STRING)
    PaymentStatus status;
}


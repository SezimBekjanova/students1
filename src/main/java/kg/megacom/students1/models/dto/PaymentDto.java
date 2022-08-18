package kg.megacom.students1.models.dto;

import kg.megacom.students1.models.enums.PaymentStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentDto {
    Long id;
    Date date_payments;
    GroupDto group;
    StudentDto student;
    PaymentStatus status;
}

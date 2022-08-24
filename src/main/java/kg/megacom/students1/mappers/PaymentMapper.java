package kg.megacom.students1.mappers;

import kg.megacom.students1.models.Payment;
import kg.megacom.students1.models.dto.PaymentDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PaymentMapper {
    private final ModelMapper modelMapper;
    public Payment toEntity(PaymentDto paymentDto){
        return Objects.isNull(paymentDto) ? null : modelMapper.map(paymentDto, Payment.class);
    }
    public PaymentDto toDto(Payment payment){
        return Objects.isNull(payment) ? null : modelMapper.map(payment, PaymentDto.class);
    }
    public List<PaymentDto> toDtoList(List<Payment> paymentList){
        return paymentList.stream().map(payment -> modelMapper.map(payment, PaymentDto.class))
                .collect(Collectors.toList());
    }

}

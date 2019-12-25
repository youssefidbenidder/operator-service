package operator.service.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDto {

    private String type;
    private Long amount;
    private String phoneNumber;
}

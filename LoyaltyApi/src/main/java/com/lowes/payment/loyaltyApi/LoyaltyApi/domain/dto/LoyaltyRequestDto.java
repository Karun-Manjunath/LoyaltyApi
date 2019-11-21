package com.lowes.payment.loyaltyApi.LoyaltyApi.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
public class LoyaltyRequestDto {

    @NotBlank
    public String customerId;
    public Date customerRegistrationDate;
    public String loyaltyId;
    public int rewardPoints;
}

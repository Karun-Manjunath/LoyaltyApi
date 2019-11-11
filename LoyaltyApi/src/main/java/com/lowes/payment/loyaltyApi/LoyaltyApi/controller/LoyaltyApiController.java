package com.lowes.payment.loyaltyApi.LoyaltyApi.controller;

import com.lowes.payment.loyaltyApi.LoyaltyApi.domain.dto.LoyaltyDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoyaltyApiController {
    private final static Logger Log = LoggerFactory.getLogger(LoyaltyDto.class);

    @RequestMapping(value = "/loyalty", method = RequestMethod.POST)
    public String saveLoyalty(@RequestBody @Valid LoyaltyDto requestLoyaltyDto){
        requestLoyaltyDto.setLoyaltyId("47XXXXXXXXX0001");
        Log.info("Customer Id:"+requestLoyaltyDto.customerId + "has been registered with Loyalty Id: "
                +requestLoyaltyDto.loyaltyId);
        return ("Success");
    }

}

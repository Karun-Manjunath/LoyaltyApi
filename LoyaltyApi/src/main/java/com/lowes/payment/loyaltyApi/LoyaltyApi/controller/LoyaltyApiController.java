package com.lowes.payment.loyaltyApi.LoyaltyApi.controller;

import com.lowes.payment.loyaltyApi.LoyaltyApi.domain.dto.LoyaltyRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
public class LoyaltyApiController {
    private final static Logger Log = LoggerFactory.getLogger(LoyaltyRequestDto.class);

    HashMap<String, LoyaltyRequestDto> loyaltyList = new HashMap<String, LoyaltyRequestDto>();

    @RequestMapping(value = "/loyalty", method = RequestMethod.POST)
    public String saveLoyalty(@RequestBody @Valid LoyaltyRequestDto requestLoyaltyDto){
        requestLoyaltyDto.setLoyaltyId("47XXXXXXXXX0001");
        requestLoyaltyDto.setRewardPoints(10);

        loyaltyList.put(requestLoyaltyDto.customerId, requestLoyaltyDto);
        Log.info("Customer Id:"+requestLoyaltyDto.customerId + "has been registered with Loyalty Id: "
                +requestLoyaltyDto.loyaltyId);

        return ("Success");
    }

    @ResponseBody
    @RequestMapping(value="/loyalty", method = RequestMethod.GET)
    public LoyaltyRequestDto getLoyalty(@RequestHeader("customerId")  String customerId){

        return(loyaltyList.get(customerId));
    }
}

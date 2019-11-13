package com.lowes.payment.loyaltyApi.LoyaltyApi.controller;

import com.lowes.payment.loyaltyApi.LoyaltyApi.domain.dto.LoyaltyDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
public class LoyaltyApiController {
    private final static Logger Log = LoggerFactory.getLogger(LoyaltyDto.class);

    HashMap<String,LoyaltyDto> loyaltyList = new HashMap<String,LoyaltyDto>();

    @RequestMapping(value = "/loyalty", method = RequestMethod.POST)
    public String saveLoyalty(@RequestBody @Valid LoyaltyDto requestLoyaltyDto){
        requestLoyaltyDto.setLoyaltyId("47XXXXXXXXX0001");

        loyaltyList.put(requestLoyaltyDto.customerId, requestLoyaltyDto);
        Log.info("Customer Id:"+requestLoyaltyDto.customerId + "has been registered with Loyalty Id: "
                +requestLoyaltyDto.loyaltyId);

        return ("Success");
    }

    @ResponseBody
    @RequestMapping(value="/loyalty/{customerID}", method = RequestMethod.GET)
    public LoyaltyDto getLoyalty(@PathVariable("customerID")  String customerID){

        return(loyaltyList.get(customerID));
    }
}

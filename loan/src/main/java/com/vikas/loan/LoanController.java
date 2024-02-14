package com.vikas.loan;

import com.vikas.attributemodel.model.ProfileAttributes;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @GetMapping("/num")
    public Integer getLoanAmount(){

        return 20;
    }

    @GetMapping("/attribute")
    public ProfileAttributes getAttr(){
        CollectionUtils.isEmpty(Collections.singletonList("1"));
        ProfileAttributes profileAttributes = new ProfileAttributes();
        profileAttributes.setLePay("123");;
        profileAttributes.setRehypothecation("5325");
        return  profileAttributes;
    }
}

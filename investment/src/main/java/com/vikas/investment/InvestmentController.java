package com.vikas.investment;

import com.vikas.util.Utility;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/investment")
public class InvestmentController {

    @GetMapping("/num")
    public Integer getNum(){
        return Utility.getNum();
    }
}

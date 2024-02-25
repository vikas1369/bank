package com.vikas.investment;

import com.vikas.util.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/investment")
public class InvestmentController {
    Logger logger = LoggerFactory.getLogger(InvestmentController.class);

    @GetMapping("/num")
    public Integer getNum(){
        logger.info("Investment controller called");
        return Utility.getNum();
    }
}

package com.vikas.loan;

import com.vikas.loan.entity.LoanEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public class DistributorFunction implements Function<LoanEntity, String> {
    Logger logger = LoggerFactory.getLogger(DistributorFunction.class);

    @Override
    public String apply(LoanEntity loanEntity) {
        logger.info("Received message "+ loanEntity +"Sending message"+ loanEntity.getAttributeJson());
        return loanEntity.getAttributeJson();
    }
}

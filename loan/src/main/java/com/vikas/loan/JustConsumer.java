package com.vikas.loan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service("justConsumer")
public class JustConsumer implements Consumer<String> {
    Logger logger = LoggerFactory.getLogger(JustConsumer.class);

    @Override
    public void accept(String s) {
        logger.info("Message received from out topic "+s);
    }
}

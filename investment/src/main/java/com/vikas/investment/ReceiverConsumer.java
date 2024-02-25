package com.vikas.investment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;
import java.util.function.Function;

@Service("receiverConsumer")
public class ReceiverConsumer implements Consumer<String> {
    Logger logger = LoggerFactory.getLogger(ReceiverConsumer.class);

    @Override
    public void accept(String s) {
        logger.info("Message received from loan "+s);
    }
}

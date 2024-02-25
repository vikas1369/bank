package com.vikas.loan;

import com.datastax.driver.core.utils.UUIDs;
import com.vikas.attributemodel.model.LoanAttributes;
import com.vikas.loan.entity.LoanEntity;
import com.vikas.loan.repository.LoanRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/loan")
public class LoanController {

    LoanRepository loanRepository;

    StreamBridge streamBridge;

    CassandraTemplate cassandraTemplate;

    public LoanController(LoanRepository loanRepository, StreamBridge streamBridge, CassandraTemplate cassandraTemplate) {
        this.loanRepository = loanRepository;
        this.streamBridge = streamBridge;
        this.cassandraTemplate = cassandraTemplate;
    }

    public static Logger logger = LoggerFactory.getLogger(LoanController.class);

    @GetMapping("/num")
    public Integer getLoanAmount(){

        return 20;
    }

    @GetMapping("/getSampleAttribute")
    public LoanAttributes getAttribute(){
        CollectionUtils.isEmpty(Collections.singletonList("1"));
        LoanAttributes profileAttributes = new LoanAttributes();
        profileAttributes.setLePay("123");;
        profileAttributes.setRehypothecation("5325");
        logger.info("Trying to get sample attribute");
        return  profileAttributes;
    }

    @PostMapping("/populate")
    public List<LoanEntity> populateDB(){
        List<Integer> list =  IntStream.range(1,100).boxed().collect(Collectors.toList());
        return list.stream().map(item->{
            LoanEntity loanEntity = new LoanEntity();
            loanEntity.setId(String.valueOf(item));
            loanEntity.setLine("Credit");
            loanEntity.setType("Trade");
            loanEntity.setAttributeJson("dummy");
            loanEntity.setUpdate_dt(Instant.now());
            loanEntity.setVersionId(UUIDs.random());
            return loanRepository.save(loanEntity);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void getAndPublishOnKafka(@RequestParam String id, @RequestParam String lob, @RequestParam String type){
        LoanEntity entity = loanRepository.findByIdAndLobAndType(id, lob, type);
        logger.info("Found"+entity);
        //streamBridge.send("topic_loan", entity);
        streamBridge.send("justProducer-out-0", entity.getId()); //If using this then don't define the producer that implements a supplier at all

    }

    @GetMapping("/testTracing")
    public Integer testDistributedTracing(){
        logger.info("Loan controller called");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Integer> entity = restTemplate.getForEntity("http://localhost:9000/investment/num", Integer.class);
        return entity.getBody();

    }
}

package com.vikas.loan;

import com.datastax.driver.core.utils.UUIDs;
import com.vikas.attributemodel.model.ProfileAttributes;
import com.vikas.loan.entity.ProfileEntity;
import com.vikas.loan.repository.ProfileRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/loan")
public class LoanController {

    ProfileRepository profileRepository;

    public LoanController(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public static Logger logger = LoggerFactory.getLogger(LoanController.class);

    @GetMapping("/num")
    public Integer getLoanAmount(){

        return 20;
    }

    @GetMapping("/getSampleAttribute")
    public ProfileAttributes getAttribute(){
        CollectionUtils.isEmpty(Collections.singletonList("1"));
        ProfileAttributes profileAttributes = new ProfileAttributes();
        profileAttributes.setLePay("123");;
        profileAttributes.setRehypothecation("5325");
        logger.info("Trying to get sample attribute");
        return  profileAttributes;
    }

    @PostMapping("/populate")
    public List<ProfileEntity> populateDB(){
        List<Integer> list =  IntStream.range(1,100).boxed().collect(Collectors.toList());
        return list.stream().map(item->{
            ProfileEntity profileEntity = new ProfileEntity();
            profileEntity.setId(String.valueOf(item));
            profileEntity.setLob("Credit");
            profileEntity.setType("Trade");
            profileEntity.setAttributeJson("dummy");
            profileEntity.setUpdate_dt(Instant.now());
            profileEntity.setVersionId(UUIDs.random());
            return profileRepository.save(profileEntity);
        }).collect(Collectors.toList());

    }
}

package com.vikas.bank.controller;

import com.vikas.bank.model.Instrument;
import org.openjdk.jol.info.ClassLayout;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/feed")
public class FeedController {

    @GetMapping("/get")
    public List<Instrument> test(){
        Map<Integer, Integer> map = new HashMap<>();
        List<Instrument> list =  IntStream.range(1,100000).boxed().map(val -> new Instrument(val, val)).collect(Collectors.toList());
        //System.out.println(ClassLayout.parseInstance(list).toPrintable());
        return list;
    }
}

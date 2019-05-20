package com.example.BloomFilter.controller;

import com.example.BloomFilter.service.BloomFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BloomFilterController {

    @Autowired
    private BloomFilter bloomFilter;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addWord(@RequestParam(value = "input")  String word) {
        if(word == null || word.trim().length() == 0) {
            return;
        }
        bloomFilter.add(word);
    }

    @RequestMapping(value = "/contains", method = RequestMethod.GET)
    public boolean containsWord(@RequestParam(value = "input") String word) {
        if(word == null || word.trim().length() == 0) {
            return false;
        }
        return bloomFilter.contains(word);
    }

    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    public void resetFilter() {
        bloomFilter.clear();
    }
}

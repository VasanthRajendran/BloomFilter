package com.example.BloomFilter.controller;

import com.example.BloomFilter.service.BloomFilter;
import com.example.BloomFilter.service.impl.HashFactoryMD5Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BloomFilterController {

    @Autowired
    private BloomFilter bloomFilter;

    @Autowired
    private HashFactoryMD5Impl hashFactoryMD5;

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public void addWord(@RequestBody String word) {
        if(word == null) {
            return;
        }
        bloomFilter.add(word);
    }

    @RequestMapping(value = "/contains", method = RequestMethod.GET)
    public boolean containsWord(@RequestParam String word) {
        if(word == null) {
            return false;
        }
        return bloomFilter.contains(word);
    }

    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    public void resetFilter() {
        bloomFilter.clear();
    }
}

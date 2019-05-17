package com.example.BloomFilter.service.impl;

import com.example.BloomFilter.service.HashFactory;
import org.springframework.stereotype.Component;

@Component("hashFactoryA")
public class HashFactoryImpl implements HashFactory {

    @Override
    public int generateHash(String word) {
        return word.hashCode();
    }
}

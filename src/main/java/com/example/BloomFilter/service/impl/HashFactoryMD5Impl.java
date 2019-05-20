package com.example.BloomFilter.service.impl;

import com.example.BloomFilter.service.HashFactory;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;

@Component("hashFactoryB")
public class HashFactoryMD5Impl implements HashFactory {

    /* Generating hashcode based on MD5 algorithm implementation*/
    @Override
    public int generateHash(String password) {
        int hashValue = 0;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            BigInteger bi = new BigInteger(digest);
            hashValue = bi.intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashValue;
    }
}

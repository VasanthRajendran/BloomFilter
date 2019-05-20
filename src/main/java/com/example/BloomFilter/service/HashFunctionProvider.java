package com.example.BloomFilter.service;

import com.example.BloomFilter.service.impl.BloomFilterImpl;
import org.springframework.stereotype.Service;

@Service
public class HashFunctionProvider {

    /* hashFunction1 and hashFunction2 returns a int value in the range of bitset(16000) based on the hashvalue passed*/
    public int hashFunction1(int hashValue) {
        return ((((hashValue % BloomFilterImpl.NUMBER_OF_BITS) * 7) % BloomFilterImpl.NUMBER_OF_BITS) * 11) % BloomFilterImpl.NUMBER_OF_BITS;
    }

    public int hashFunction2(int hashValue) {
        return ((((hashValue % BloomFilterImpl.NUMBER_OF_BITS) * 13) % BloomFilterImpl.NUMBER_OF_BITS) * 17) % BloomFilterImpl.NUMBER_OF_BITS;

    }
}

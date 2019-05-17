package com.example.BloomFilter.service.impl;

import com.example.BloomFilter.service.BloomFilter;
import com.example.BloomFilter.service.HashFactory;
import com.example.BloomFilter.service.HashFunctionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.BitSet;

@Service
public class BloomFilterImpl implements BloomFilter {

    @Autowired
    HashFactory hashFactoryA;

    @Autowired
    HashFactory hashFactoryB;

    @Autowired
    HashFunctionProvider hashFunctionProvider;

    public final static int NUMBER_OF_BITS = 16000;

    BitSet bitSet = new BitSet(NUMBER_OF_BITS);

    @Override
    public void add(String word) {
        try {
            int hashCodeA = Math.abs(hashFactoryA.generateHash(word));
            bitSet.set(hashFunctionProvider.hashFunction1(hashCodeA));
            bitSet.set(hashFunctionProvider.hashFunction2(hashCodeA));
            int hashCodeB = hashFactoryB.generateHash(word);
            bitSet.set(hashFunctionProvider.hashFunction1(hashCodeB));
            bitSet.set(hashFunctionProvider.hashFunction2(hashCodeB));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean contains(String word) {
        try {
            int hashCodeA = hashFactoryA.generateHash(word);
            int hashCodeB = hashFactoryB.generateHash(word);
            if (bitSet.get(hashFunctionProvider.hashFunction1(hashCodeA)) && bitSet.get(hashFunctionProvider.hashFunction2(hashCodeA))
            && bitSet.get(hashFunctionProvider.hashFunction1(hashCodeB)) && bitSet.get(hashFunctionProvider.hashFunction2(hashCodeB))) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void clear() {
        bitSet.clear();
    }

}

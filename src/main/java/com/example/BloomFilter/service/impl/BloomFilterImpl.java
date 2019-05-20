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

    /* HashCodeA(Java Implementation of Hash) and HashCodeB(MD5 implementation of hash)
    are passed to the  hashFunction1 and hashFunction2 to generate 4 different values and
    the bit values are set using those values.
     */
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


    /* HashCodeA(Java Implementation of Hash) and HashCodeB(MD5 implementation of hash)
    are passed to the  hashFunction1 and hashFunction2 to generate 4 different values and
    the bit values validated to see if they are already set to true. If yes the word may be
    present else its not present.
    */
    @Override
    public boolean contains(String word) {
        try {
            int hashCodeA = Math.abs(hashFactoryA.generateHash(word));
            int hashCodeB = hashFactoryB.generateHash(word);
            return (bitSet.get(hashFunctionProvider.hashFunction1(hashCodeA)) && bitSet.get(hashFunctionProvider.hashFunction2(hashCodeA))
            && bitSet.get(hashFunctionProvider.hashFunction1(hashCodeB)) && bitSet.get(hashFunctionProvider.hashFunction2(hashCodeB)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* Clears all the values of bitset*/
    @Override
    public void clear() {
        bitSet.clear();
    }

}

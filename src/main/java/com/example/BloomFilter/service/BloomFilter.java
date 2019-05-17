package com.example.BloomFilter.service;


public interface BloomFilter{

    void add(String word);

    boolean contains(String word);

    void clear();

}

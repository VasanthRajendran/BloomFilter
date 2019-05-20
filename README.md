# BloomFilter


A Java implementation of simple bloom filter application. 

## Whar is Bloom Filter? 

Bloom filters are probabilistic space-efficient data structures. They are used exclusively membership existence in a set. However, they have a very powerful property which allows to make trade-off between space and false-positive rate when it comes to membership existence. Since it can make a tradeoff between space and false positive rate, it is called probabilistic data structure.

# Deployment:

The Application is deployed in AWS cloud to test the functionality. 

## Endpoint:

http://Bloomfilter-env.byx6xfxzpq.us-west-2.elasticbeanstalk.com 

**1. add**

The post endpoint "/add" is used to add the word to the bloom filter application. 

**2. contains**

The get endpoint "/contains" is used to check the existence of word. 

**3. reset**

The get endpoint "/reset" is used to reset/clear the bloom filter. 

## Running the Application Locally:

**As a maven target:**

1.) Import the project from GitHub:

Run the below commands in the command line,

1.) mvn clean install

2.) mvn exec:java -Dexec.mainClass="com.example.BloomFilter.BloomFilterApplication"

**Running the Application in IDE (Intellij/Eclipse)**

1.) Import the project as a maven target into the IDE.

2.) Right click on the main class "BloomFilterApplication" and click run. 


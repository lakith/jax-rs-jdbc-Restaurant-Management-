package com.advance_jersey_app_3.app.jdbcConnection.Client;


import redis.clients.jedis.Jedis;

public final class RedisClient  {

    public RedisClient(){}

  //  private static Jedis redis = new Jedis("localhost");


    public  void setCache(String key, String value) {

      //  redis.set(key, value);

    }

    public  String getCache(String key) {

        Jedis jedis = new Jedis("localhost");
        jedis.set("foo","bar");
        return jedis.get("foo");

      //  return redis.get(key);
    }


}

package com.advance_jersey_app_3.app.jdbcConnection.Client;

import com.advance_jersey_app_3.app.jdbcConnection.models.Employee;
import redis.clients.jedis.Jedis;

public final class Radies {

     private static  Jedis jedis = new Jedis("localhost");

/*    public static void main(String[] args) {

        Jedis jedis = new Jedis("localhost");
        Radies radies = new Radies();
        radies.setRadies(jedis);
        radies.getRadiues(jedis);

    }*/
    public void setRadies(){
        jedis.set("foo", "employee");
    }

    public String getRadiues()
    {
       return jedis.get("foo");
    }



}

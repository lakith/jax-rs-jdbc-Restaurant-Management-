package com.advance_jersey_app_3.app.jdbcConnection.Redis;

import redis.clients.jedis.Jedis;

import java.io.*;

public class RedisImpl {

    private static Jedis jedis = new Jedis("localhost");

    /**
     * inset values to redis server
     * @param key
     * @param object
     */
    public void setRadies(String key , Object object){

        jedis.set(key.getBytes(),toBytes(object));
    }

    /**
     * get objects from redis server by key
     * @param key
     * @return
     */
    public Object getObjectValue(String key) {
        return fromBytes(jedis.get(key.getBytes()));
    }

    /**
     * check availability of the key
     * @param key
     * @return
     */
    public boolean checkData(String key){
        return jedis.exists(key.getBytes());
    }

    /**
     * convert byte array to object
     * @param key
     * @return
     */
    public Object fromBytes(byte key[]) {
        Object obj = null;
        if(key!=null)
        {
            try {
                ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(key));
                obj = ois.readObject();
                ois.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }

    /**
     * object to byte array
     * @param object
     * @return
     */
    public byte[] toBytes(Object object){

        ByteArrayOutputStream baos;
        ObjectOutputStream oos;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            oos.close();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

}

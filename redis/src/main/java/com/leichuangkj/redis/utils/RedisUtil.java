package com.leichuangkj.redis.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RedisUtil {

    /**
     * @description 指定缓存失效时间
     *
     * @param key  键
     * @param time 时间(秒)
     * @return boolean
     */
    public static boolean expire(RedisTemplate<String, Object> redisTemplate, String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description 根据key获取过期时间
     *
     * @param key 键(不能为null)
     * @return long 时间(秒) 返回0代表为永久有效
     */
    public static long getExpire(RedisTemplate<String, Object> redisTemplate, String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * @description 判断key是否存在
     *
     * @param key 键
     * @return boolean(true:存在 false:不存在)
     */
    public static boolean hasKey(RedisTemplate<String, Object> redisTemplate, String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description 删除缓存
     *
     * @param key 可以传一个值或多个
     */
    @SuppressWarnings("unchecked")
    public static void del(RedisTemplate<String, Object> redisTemplate, String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    // ============================String=============================

    /**
     * @description 普通缓存获取
     *
     * @param key 键
     * @return Object
     */
    public static Object get(RedisTemplate<String, Object> redisTemplate, String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * @description 普通缓存放入
     *
     * @param key   键
     * @param value 值
     * @return boolean (true:成功 false:失败)
     */
    public static boolean set(RedisTemplate<String, Object> redisTemplate, String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * @description 普通缓存放入并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒) (time要大于0,如果time小于等于0,将设置无限期)
     * @return boolean (true:成功 false:失败)
     */
    public static boolean set(RedisTemplate<String, Object> redisTemplate, String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(redisTemplate, key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description 递增
     *
     * @param key 键
     * @return long
     */
    public static long incr(RedisTemplate<String, Object> redisTemplate, String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * @description 递减
     *
     * @param key 键
     * @return long
     */
    public static long decr(RedisTemplate<String, Object> redisTemplate, String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, -delta);
    }

    // ================================Map=================================

    /**
     * @description HashGet
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return Object 值
     */
    public static Object hget(RedisTemplate<String, Object> redisTemplate, String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }

    /**
     * @description 获取hashKey对应的所有键值
     *
     * @param key 键
     * @return Map<Object,Object> 对应的多个键值
     */
    public static Map<Object, Object> hmget(RedisTemplate<String, Object> redisTemplate, String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * @description HashSet
     *
     * @param key 键
     * @param map 对应多个键值
     * @return boolean (true:成功 false:失败)
     */
    public static boolean hmset(RedisTemplate<String, Object> redisTemplate, String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description HashSet 并设置时间
     *
     * @param key  键
     * @param map  对应多个键值
     * @param time 时间(秒)
     * @return boolean (true:成功 false:失败)
     */
    public static boolean hmset(RedisTemplate<String, Object> redisTemplate, String key, Map<String, Object> map, long time) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if (time > 0) {
                expire(redisTemplate, key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @return boolean (true:成功 false:失败)
     */
    public static boolean hset(RedisTemplate<String, Object> redisTemplate, String key, String item, Object value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @param time  时间(秒) (如果已存在的hash表有时间,这里将会替换原有的时间)
     * @return boolean (true:成功 false:失败)
     */
    public static boolean hset(RedisTemplate<String, Object> redisTemplate, String key, String item, Object value, long time) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            if (time > 0) {
                expire(redisTemplate, key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description 删除hash表中的值
     *
     * @param key  键 不能为null
     * @param item 项 可以为多个但不能为null
     */
    public static void hdel(RedisTemplate<String, Object> redisTemplate, String key, Object... item) {
        redisTemplate.opsForHash().delete(key, item);
    }

    /**
     * @description 判断hash表中是否有该项的值
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return boolean (true:存在 false:不存在)
     */
    public static boolean hHasKey(RedisTemplate<String, Object> redisTemplate, String key, String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    /**
     * @description hash递增
     *
     * @param key  键
     * @param item 项
     * @param by   要增加(大于0)
     * @return double
     */
    public static double hincr(RedisTemplate<String, Object> redisTemplate, String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, by);
    }

    /**
     * @description  hash递减
     *
     * @param key  键
     * @param item 项
     * @param by   要减少(小于0)
     * @return double
     */
    public static double hdecr(RedisTemplate<String, Object> redisTemplate, String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, -by);
    }

    // ============================set=============================

    /**
     * @description 根据key获取Set中的所有值
     *
     * @param key 键
     * @return Set<Object>
     */
    public static Set<Object> sGet(RedisTemplate<String, Object> redisTemplate, String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @description 根据value从一个set中查询,判断是否存在
     *
     * @param key   键
     * @param value 值
     * @return boolean(true:存在 false:不存在)
     */
    public static boolean sHasKey(RedisTemplate<String, Object> redisTemplate, String key, Object value) {
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description 将数据放入set缓存
     *
     * @param key    键
     * @param values 值
     * @return long 返回存入成功的个数
     */
    public static long sSet(RedisTemplate<String, Object> redisTemplate, String key, Object... values) {
        try {
            return redisTemplate.opsForSet().add(key, values);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * @description 将set数据放入缓存
     *
     * @param key    键
     * @param time   时间(秒)
     * @param values 值
     * @return long 返回存入成功的个数
     */
    public static long sSetAndTime(RedisTemplate<String, Object> redisTemplate, String key, long time,
                                   Object... values) {
        try {
            Long count = redisTemplate.opsForSet().add(key, values);
            if (time > 0)
                expire(redisTemplate, key, time);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * @description 获取set缓存的长度
     *
     * @param key 键
     * @return long
     */
    public static long sGetSetSize(RedisTemplate<String, Object> redisTemplate, String key) {
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * @description 移除值为value的数
     *
     * @param key    键
     * @param values 值
     * @return long 返回移除的个数
     */
    public static long setRemove(RedisTemplate<String, Object> redisTemplate, String key, Object... values) {
        try {
            Long count = redisTemplate.opsForSet().remove(key, values);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    // ===============================list=================================

    /**
     * @description 获取list缓存的内容
     *
     * @param key   键
     * @param start 开始
     * @param end   结束 (0到-1代表所有值)
     * @return List<Object>
     */
    public static List<Object> lGet(RedisTemplate<String, Object> redisTemplate, String key, long start, long end) {
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @description 获取list缓存的长度
     *
     * @param key 键
     * @return long
     */
    public static long lGetListSize(RedisTemplate<String, Object> redisTemplate, String key) {
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * @description 通过索引,获取list中的值
     *
     * @param key   键
     * @param index 索引 (index>=0时，0:表头，1:第二个元素，依次类推；index<0时，-1:表尾，-2:倒数第二个元素，依次类推)
     * @return Object
     */
    public static Object lGetIndex(RedisTemplate<String, Object> redisTemplate, String key, long index) {
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @description 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return boolean
     */
    public static boolean lSet(RedisTemplate<String, Object> redisTemplate, String key, Object value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return boolean
     */
    public static boolean lSet(RedisTemplate<String, Object> redisTemplate, String key, Object value, long time) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            if (time > 0)
                expire(redisTemplate, key, time);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description  将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return boolean
     */
    public static boolean lSet(RedisTemplate<String, Object> redisTemplate, String key, List<Object> value) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return boolean
     */
    public static boolean lSet(RedisTemplate<String, Object> redisTemplate, String key, List<Object> value, long time) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            if (time > 0)
                expire(redisTemplate, key, time);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description 根据索引修改list中的某条数据
     *
     * @param key   键
     * @param index 索引
     * @param value 值
     * @return boolean
     */
    public static boolean lUpdateIndex(RedisTemplate<String, Object> redisTemplate, String key, long index, Object value) {
        try {
            redisTemplate.opsForList().set(key, index, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description 移除N个值为value
     *
     * @param key   键
     * @param count 移除个数
     * @param value 值
     * @return long 返回移除的个数
     */
    public static long lRemove(RedisTemplate<String, Object> redisTemplate, String key, long count, Object value) {
        try {
            Long remove = redisTemplate.opsForList().remove(key, count, value);
            return remove;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
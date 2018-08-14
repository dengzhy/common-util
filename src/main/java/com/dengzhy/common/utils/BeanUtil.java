package com.dengzhy.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dengzhy
 * create 2017-04-15
 */
public class BeanUtil {

    private static Logger logger = LoggerFactory.getLogger(BeanUtil.class);

    /**
     * 需要字段
     *
     * @param dest 目的
     * @param orig 源
     */
    public static void copyProperties(Object dest, Object orig) {
        try {
            BeanUtilsBean.getInstance().copyProperties(dest, orig);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 普通对象转换
     *
     * @param targetClass 目标对象类型，必须含有无参构造函数，且目标对象和被转换对象如果有相同名称字段，则2个字段的类型必须一致
     * @param source      被转换的对象
     */
    public static <T> T transform(Class<T> targetClass, Object source) {
        if (source == null) {
            return null;
        }
        try {
            String json_source = JSON.toJSONString(source);
            T dest = JSONObject.parseObject(json_source, targetClass);

            return dest;
        } catch (Exception e) {
            logger.error("对象转换出错：目标对象类型:{}, 被转换的对象类型:{}, 被转换的对象值:{}", targetClass, source.getClass(),
                    JSON.toJSONString(source, SerializerFeature.WriteMapNullValue), e);
            throw new RuntimeException(e);
        }
    }


    /**
     * 普通对象集合转换
     *
     * @param targetClass 目标对象类型，必须含有无参构造函数，且目标对象和被转换对象如果有相同名称字段，则2个字段的类型必须一致
     * @param listSource  被转换的对象
     */
    public static <T> List<T> transformList(Class<T> targetClass, List<?> listSource) {
        if (listSource == null) {
            return null;
        }
        try {
            String json_source = JSON.toJSONString(listSource);
            List<T> dest = JSONArray.parseArray(json_source, targetClass);
            return dest;
        } catch (Exception e) {
            logger.error("对象转换出错：目标对象类型:{}, 被转换的对象类型:{}, 被转换的对象值:{}", targetClass, listSource.getClass(),
                    JSON.toJSONString(listSource, SerializerFeature.WriteMapNullValue), e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 实体转换成map
     * @param obj
     * @return
     */
    public static Map ConvertObjToMap(Object obj) {
        Map<String, Object> reMap = new HashMap<String, Object>();
        if (obj == null) {
            return null;
        }
        Field[] fields = obj.getClass().getDeclaredFields();
        try {
            for (int i = 0; i < fields.length; i++) {
                try {
                    Field f = obj.getClass().getDeclaredField(fields[i].getName());
                    f.setAccessible(true);
                    Object o = f.get(obj);
                    reMap.put(fields[i].getName(), o);
                } catch (NoSuchFieldException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return reMap;
    }
}

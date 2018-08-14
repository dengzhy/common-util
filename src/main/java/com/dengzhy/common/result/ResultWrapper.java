package com.dengzhy.common.result;


import com.dengzhy.common.exception.ApiException;
import com.dengzhy.common.utils.Jackson;
import com.dengzhy.common.utils.PageModel;
import com.dengzhy.common.utils.PageModelMap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 对结果进行封装
 * @Author dengzhy
 * @Date 2018/8/14 14:01
 * @Return 
 */
public class ResultWrapper {
    /**
     * 成功返回（带提示信息）
     */
    public static Map<String, Object> success(String message) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("success", true);
        map.put("message", message);
        return map;
    }

    /**
     * 成功返回（带有返回值）
     */
    public static Map<String, Object> success(Object data) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("success", true);
        map.put("data", data);
        return map;
    }

    /**
     * 失败返回（带错误信息）
     */
    public static Map<String, Object> fail(String errorMsg) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("success", false);
        map.put("message", errorMsg);
        return map;
    }

    /**
     * 失败返回（带标准错误code与信息）
     */
    public static Map<String, Object> fail(BaseResultCode baseResultCode) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("success", false);
        map.put("code", baseResultCode.getCode());
        map.put("message", baseResultCode.getMessage());
        return map;
    }

  /**
   * 返回 ApiException 错误信息
   * @Author dengzhy
   * @Date 2018/8/14 14:00
    * @param apiException
   * @Return java.util.Map<java.lang.String,java.lang.Object>
   */
    public static Map<String, Object> fail(ApiException apiException) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("success", false);
        if (apiException.getErrCode() != null) {
            map.put("code", apiException.getErrCode());
        }
        map.put("message", apiException.getMessage());
        return map;
    }
    /**
     * 返回string类型的结果
     * @Author dengzhy
     * @Date 2018/8/14 14:00
     * @param object
     * @Return java.lang.String
     */
    public static String successList(Object object) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("success", true);
        if (object instanceof PageModel) {
            PageModel<?> pm = (PageModel<?>) object;
            map.put("data", pm.getData());
            map.put("total", pm.getRecordCount());
        } else if (object instanceof PageModelMap) {
            map.putAll((Map<? extends String, ? extends Object>) object);
        } else {
            map.put("data", object);
        }
        return Jackson.mobile().writeValueAsString(map);
    }
}

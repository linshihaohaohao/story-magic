package org.yoqu.story.dao.handler.util;

import com.sun.javafx.scene.transform.TransformUtils;
import org.apache.commons.beanutils.MethodUtils;
import org.yoqu.common.enums.CodeBaseEnum;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by Admin on 2017/6/18.
 */
public class CodeEnumUtil {
    /**
     * @param enumClass
     * @param value
     * @param <E>
     * @return
     */
    public static <E extends Enum<?> & CodeBaseEnum> E codeOf(Class<E> enumClass, String value) {
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e : enumConstants) {
            if (value.equals(e.value())){
                return e;
            }
        }
        return null;
    }


    /**
     * 为miniUI提供单选下拉列表提供数据
     * @param ref enum类
     * @param mapName input获取数据的名称
     * @param <T>
     * @return
     */
    public static <T> List<Map<String, String>> getListMapEnum(Class<T> ref,String mapName){
        List<Map<String,String>> returnData = new ArrayList<>();
        if(ref.isEnum()){
            T[] ts = ref.getEnumConstants() ;
            for(T t : ts){
                Map<String,String> typeMap = new HashMap<>();
                String value = getInvokeValue(t, "getValue") ;
                typeMap.put(mapName,value);
                returnData.add(typeMap);
            }
        }
        return returnData ;
    }
    static <T> String getInvokeValue(T t , String methodName){
        try {
            Method method = t.getClass().getMethod(methodName);
            if(null == method){
                return null ;
            }
            Object text = method.invoke(t) ;
            return text.toString() ;
        } catch (Exception e) {
            return null ;
        }
    }
}

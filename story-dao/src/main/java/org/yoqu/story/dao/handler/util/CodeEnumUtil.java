package org.yoqu.story.dao.handler.util;

import org.yoqu.common.enums.CodeBaseEnum;

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
}

package com.bozhong.insistapi.enums;

import java.util.*;

/**
 * Created by xiezg@317hu.com on 2017/7/25 0025.
 */
public enum ParamTypeEnum {
    String, Double, Int, Boolean, Byte, Short, Long, Float, Date, DateTime,
    Json, Object, File, Array;
    public static final List<String> LIST = new ArrayList<>();

    static {
        for (ParamTypeEnum paramTypeEnum : EnumSet.allOf(ParamTypeEnum.class)) {
            LIST.add(paramTypeEnum.name().toLowerCase());
        }
    }
}

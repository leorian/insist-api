package com.bozhong.insistapi.entity;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * Created by xiezg@317hu.com on 2017/8/30 0030.
 */
public class AccessEntity implements Serializable {
    private String accessName;
    private Long accessCount;

    public String getAccessName() {
        return accessName;
    }

    public void setAccessName(String accessName) {
        this.accessName = accessName;
    }

    public Long getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(Long accessCount) {
        this.accessCount = accessCount;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

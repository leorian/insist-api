package com.bozhong.insistapi.entity;

import java.io.Serializable;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
public abstract class BaseEntity implements Serializable{

    /**
     * 创建人
     */
    private String createUserId;

    /**
     * 创建时间
     */
    private String createDateTime;

    /**
     * 更新人
     */
    private String updateUserId;

    /**
     * 更新时间
     */
    private String updateDateTime;

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(String updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public BaseEntity() {
    }
}

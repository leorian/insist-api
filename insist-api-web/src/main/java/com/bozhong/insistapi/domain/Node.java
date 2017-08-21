package com.bozhong.insistapi.domain;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/8/21 0021.
 */
public class Node {
    private String text;
    private String href;
    private List<Node> nodes;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

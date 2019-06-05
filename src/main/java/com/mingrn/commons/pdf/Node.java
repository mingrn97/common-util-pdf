package com.mingrn.commons.pdf;

/**
 * 数据节点
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 2019/6/5 17:05
 */
public class Node<V extends Number> {
    private String category;

    private V val;

    public Node() {
    }

    public Node(String category, V val) {
        this.category = category;
        this.val = val;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public V getVal() {
        return val;
    }

    public void setVal(V val) {
        this.val = val;
    }
}
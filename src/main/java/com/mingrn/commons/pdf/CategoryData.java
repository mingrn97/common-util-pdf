package com.mingrn.commons.pdf;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据集
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 2019/6/5 14:21
 */
public class CategoryData extends Node {

    private String seriesName;

    private List<Node> nodes = new ArrayList<>();

    private Node add;

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void add(Node node) {
        this.nodes.add(node);
    }
}

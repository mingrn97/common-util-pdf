package com.mingrn.commons.pdf;

import com.sun.istack.internal.NotNull;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.List;

public abstract class DataSet {

    /**
     * 创建数据
     *
     * @param data 数据集
     * @return <code>DefaultCategoryDataset</code>
     */
    DefaultCategoryDataset createDataset(@NotNull CategoryData data) {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

        List<Node> nodes = data.getNodes();
        for (Node node : nodes) {
            dataSet.setValue(node.getVal(), data.getSeriesName(), node.getCategory());
        }

        return dataSet;
    }
}

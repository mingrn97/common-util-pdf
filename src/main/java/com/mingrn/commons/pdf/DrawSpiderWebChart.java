package com.mingrn.commons.pdf;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DrawSpiderWebChart extends DataSet {

    private int defaultHeight = 1000;
    private int defaultWight = 1000;

    public DrawSpiderWebChart() {
    }

    public DrawSpiderWebChart(int height, int wight) {
        this.defaultHeight = height;
        this.defaultWight = wight;
    }

    public InputStream create(String title, CategoryData data) throws IOException {
        return create(title, data, false);
    }

    public InputStream create(String title, CategoryData data, boolean legend) throws IOException {
        DefaultCategoryDataset dataset = createDataset(data);
        JFreeChart chart = drawChart(title, legend, dataset);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ChartUtils.writeChartAsJPEG(outputStream, chart, defaultWight, defaultHeight);
        byte[] bytes = outputStream.toByteArray();
        outputStream.flush();

        return new ByteArrayInputStream(bytes);
    }

    public JFreeChart drawChart(String title, boolean legend, DefaultCategoryDataset dataset) {
        SpiderWebPlot spiderWebPlot = new SpiderWebPlot(dataset);
        // 内边距
        spiderWebPlot.setInteriorGap(SpiderWebPlot.DEFAULT_INTERIOR_GAP);
        // 偏角,默认为90度12点钟方向
        spiderWebPlot.setStartAngle(90);
        // 设置坐标系颜色值
        spiderWebPlot.setSeriesPaint(new Color(51, 133, 255));
        // 设置坐标系角线颜色值(默认为黑色)与角线粗细
        spiderWebPlot.setAxisLinePaint(new Color(51, 133, 255));
        spiderWebPlot.setAxisLineStroke(new BasicStroke(5F));
        // 设置坐标系数值边线颜色值与粗细
        spiderWebPlot.setSeriesOutlinePaint(new Color(51, 133, 255));
        spiderWebPlot.setSeriesOutlineStroke(new BasicStroke(5F));

        JFreeChart chart = new JFreeChart(title, new Font("宋体", Font.BOLD, 32), spiderWebPlot, legend);

        // 设置统计图边框背景
        chart.setBackgroundPaint(new Color(105, 105, 105));

        // 获取面板,设置统计图首选项
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setFillZoomRectangle(true);
        chartPanel.setPreferredSize(new Dimension(defaultWight, defaultHeight));

        return chart;
    }
}

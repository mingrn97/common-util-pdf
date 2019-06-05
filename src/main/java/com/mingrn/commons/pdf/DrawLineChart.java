package com.mingrn.commons.pdf;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;

import java.awt.*;

/**
 * 2D折线图绘制, 可根据需要自定义扩展 <code>BaseCreate</code>
 * 绘制个性化折线图,如 3D
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 2019/6/5 16:35
 */
public class DrawLineChart extends BaseCreate {

    private int defaultHeight = 618;
    private int defaultWight = 2000;

    DrawLineChart() {
        super();
    }

    DrawLineChart(int height, int wight) {
        super(height, wight);
        this.defaultHeight = height;
        this.defaultWight = wight;
    }

    @Override
    public JFreeChart drawChart(String title, String xAxisLabel, String yAxisLabel, CategoryDataset categoryDatase, PlotOrientation orientation, boolean legend, boolean toolTip) {

        JFreeChart chart = ChartFactory.createLineChart(title, xAxisLabel, yAxisLabel, categoryDatase, orientation, legend, toolTip, false);

        // 设置图例不可见
        /*chart.getLegend().setVisible(false);*/

        // 设置标题样式
        chart.getTitle().setFont(new Font("宋体", Font.BOLD, 32));

        // 设置统计图边框背景
        chart.setBackgroundPaint(new Color(105, 105, 105));

        // 获取面板,设置统计图首选项
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setFillZoomRectangle(true);
        chartPanel.setPreferredSize(new Dimension(defaultWight, defaultHeight));

        // 获取图例
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setOutlineVisible(false);
        plot.setBackgroundAlpha(0.5F);

        // 设置统计图背景颜色值
        plot.setBackgroundPaint(new Color(105, 105, 105));

        // 设置类目
        CategoryItemRenderer itemRenderer = plot.getRenderer();
        // 设置线条粗细
        itemRenderer.setSeriesStroke(0, new BasicStroke(5F));
        // 设置线条颜色值
        itemRenderer.setSeriesPaint(0, new Color(51, 133, 255));

        // 设置X轴
        CategoryAxis xAxis = plot.getDomainAxis();
        /*xAxis.setAxisLinePaint(new Color(0,0,0,0));*/
        xAxis.setTickLabelPaint(new Color(255, 255, 255));
        xAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 18));

        // 设置y轴
        ValueAxis yAxis = plot.getRangeAxis();
        /*yAxis.setAxisLinePaint(new Color(0,0,0,0));*/
        yAxis.setTickLabelPaint(new Color(255, 255, 255));
        yAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 18));

        return chart;
    }
}

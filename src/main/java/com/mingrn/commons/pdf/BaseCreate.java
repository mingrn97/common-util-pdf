package com.mingrn.commons.pdf;

import com.sun.istack.internal.NotNull;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * JFree 统计图创建抽象类
 * <p>
 * {@link #createDataset(CategoryData)} 数据集封装抽象方法
 * {@link #drawChart(String, String, String, CategoryDataset, PlotOrientation, boolean, boolean)} 统计图绘制抽象方法
 * <p>
 * 该类方法默认返回为 {@code InputStream io} 流,你可以将其转换为你想要的任何数据.如将其转换为 <code>BufferedImage</code> 对象:
 * <pre>{@code
 *    InputStream in = // do what you want to do
 *    BufferedImage img = ImageIO.read(in);
 *    return img;
 *
 *    // 如果你得到的是 byte[] 数据,则可以使用如下方式
 *    try (InputStream inputStream = new ByteArrayInputStream(bytes)) {
 *        return ImageIO.read(inputStream);
 *    } catch (IOException e) {
 *        e.printStackTrace();
 *    }
 *    return null;
 * }</pre>
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 2019/6/5 14:05
 * @see DrawBarChart
 * @see DrawLineChart
 */
public abstract class BaseCreate {

    private int defaultHeight = 618;
    private int defaultWight = 2000;

    BaseCreate() {
    }

    BaseCreate(int height, int wight) {
        this.defaultHeight = height;
        this.defaultWight = wight;
    }

    public InputStream create(String title, CategoryData data) throws IOException {
        return create(title, null, null, data);
    }

    public InputStream create(String title, String xAxisLabel, String yAxisLabel, CategoryData data) throws IOException {
        return create(title, xAxisLabel, yAxisLabel, data, PlotOrientation.VERTICAL);
    }

    public InputStream create(String title, String xAxisLabel, String yAxisLabel, CategoryData data, PlotOrientation orientation) throws IOException {
        return create(title, xAxisLabel, yAxisLabel, data, orientation, false, false);
    }

    public InputStream create(String title, String xAxisLabel, String yAxisLabel, CategoryData data, PlotOrientation orientation, boolean legend, boolean tooltip) throws IOException {
        DefaultCategoryDataset dataset = createDataset(data);
        JFreeChart chart = drawChart(title, xAxisLabel, yAxisLabel, dataset, orientation, legend, tooltip);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ChartUtils.writeChartAsJPEG(outputStream, chart, defaultWight, defaultHeight);
        byte[] bytes = outputStream.toByteArray();
        outputStream.flush();

        return new ByteArrayInputStream(bytes);
    }

    /**
     * 创建数据
     *
     * @param data 数据集
     * @return <code>DefaultCategoryDataset</code>
     */
    private DefaultCategoryDataset createDataset(@NotNull CategoryData data) {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

        List<Node> nodes = data.getNodes();
        for (Node node : nodes) {
            dataSet.setValue(node.getVal(), data.getSeriesName(), node.getCategory());
        }

        return dataSet;
    }

    /**
     * 绘制统计图
     *
     * @param title          统计图标题
     * @param xAxisLabel     坐标轴类目,通常为 X 坐标轴
     * @param yAxisLabel     数值, 通常为 Y 坐标轴
     * @param categoryDatase 数据集, {@link #createDataset(CategoryData)}
     * @param orientation    坐标轴展示方式:
     *                       {@link PlotOrientation#HORIZONTAL} 水平展示,
     *                       {@link PlotOrientation#VERTICAL} 垂直展示
     * @param legend         是否显示图例
     * @param toolTip        是否显示提示
     * @return <code>JFreeChart</code>
     */
    protected abstract JFreeChart drawChart(String title, String xAxisLabel, String yAxisLabel, CategoryDataset categoryDatase, PlotOrientation orientation, boolean legend, boolean toolTip);
}

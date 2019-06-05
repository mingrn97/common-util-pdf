package com.mingrn.commons.pdf;

/**
 * 统计图绘制工厂类
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 2019/6/5 14:57
 */
public enum DrawChartFactory {

    /**
     * 实例化
     */
    INSTANCE;

    public DrawBarChart createBar() {
        return new DrawBarChart();
    }

    public DrawBarChart createBar(int height, int wight) {
        return new DrawBarChart(height, wight);
    }

    public DrawLineChart createLine() {
        return new DrawLineChart();
    }

    public DrawLineChart createLine(int height, int wight) {
        return new DrawLineChart(height, wight);
    }
}

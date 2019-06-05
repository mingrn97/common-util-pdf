测试用例演示:

```java
class App {
    public static void main(String[] args){
        // 工厂类绘制折线图
        DrawLineChart drawLineChart = DrawChartFactory.INSTANCE.createLine();
       
       // 数据封装
       CategoryData lineData = new CategoryData();
       // lineData do something
       
       // 绘制统计图, 得到 IO
       InputStream line = drawLineChart.create("统计图标题", lineData);
       
       // 下面可以使用 IO, 如导出为图片
       BufferedImage img = ImageIO.read(in);
       
       ImageIO.write(img, "JPG", new File("/line.jpg"));
    }
}
```
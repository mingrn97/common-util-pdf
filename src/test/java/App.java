
import com.mingrn.commons.pdf.*;
import vo.FaultCodeVO;
import vo.IllegalRecordVO;
import vo.OwnerAndCarReportVO;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 测试用例, 当前仅仅支持柱状图和折线图绘制
 * 具体见工厂类 {@link DrawChartFactory}
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 2019/6/5 19:12
 */
@SuppressWarnings("unchecked")
public class App {

    public static void main(String[] args) throws IOException {

        // 演示生成统计图片
        downloadChartImg();

        // 演示生成PDF
        genPDF();
    }

    public static void genPDF() throws IOException {

        // 下面开始数据封装

        // 这里说下 Node 类,该类仅有两个属性 category 和 val.
        // category 表示坐标轴的类目, 通常为 X 轴, val 表示类
        // 目对应的值,通常为 Y 轴

        // CategoryData 类是数据集, 该类将 Node 作为内部属性: List<Node>,
        // 同时还有一个 seriesName 属性,该属性用于设置坐标系. 一个 seriesName
        // 对用一个 List<Node>.
        // 当前,仅提供单坐标系(即一个统计图中只有一条统计数据, 如对于折线图不
        // 能同时存在多个折线图). 后续会根据需要实现多坐标系, 所以多坐标系对应
        // 一个List<CategoryData>.


        // 折线图数据封装
        CategoryData lineData = new CategoryData();
        lineData.setSeriesName("时速");
        lineData.add(new Node("0-30MPH", 20));
        lineData.add(new Node("30-60MPH", 30));
        lineData.add(new Node("60-80MPH", 25));
        lineData.add(new Node("80-100MPH", 15));
        lineData.add(new Node("100-120MPH", 12));
        lineData.add(new Node("120-140MPH", 4));
        lineData.add(new Node("100MPH以上", 2));

        // 绘制折线图, 可设置折线图宽高
        DrawLineChart drawLineChart = DrawChartFactory.INSTANCE.createLine(700, 2000);
        // 得到折线图 IO,
        InputStream line = drawLineChart.create("时速-时间关系表", lineData);

        // 柱状图数据封装,同折线图
        CategoryData barData = new CategoryData();
        barData.setSeriesName("时间区间");
        barData.add(new Node("0-6点", 3));
        barData.add(new Node("6-10点", 35));
        barData.add(new Node("10-14点", 8));
        barData.add(new Node("14-18点", 11));
        barData.add(new Node("18-20点", 39));
        barData.add(new Node("20-24点", 15));

        // 绘制柱状图
        DrawBarChart drawBarChart = DrawChartFactory.INSTANCE.createBar(700, 2000);
        // 得到柱状图 IO
        InputStream bar = drawBarChart.create("时间区间-累计小时", barData);

        // 将得到的折线图与柱状图图片 IO 上传 阿里云 ECS 服务器, 并返回两个统计图的网络图片链接
        String lineUrl = UploadUtil.uploadImage(line, "drawLineChart.jpg");
        String barUrl = UploadUtil.uploadImage(bar, "drawBarChart.jpg");

        // 开始封装数据, 该 Map 等着的数据用于 freemarker 模板生成 HTML 文本,
        // 该数据对应 车主及车辆数据报告 模板, 即 resource 文件夹下的 templates/report.ftl 文件模板
        // 另外, Map 的 key 不能做修改, 可修改的只有 val
        Map<String, Object> data = new HashMap<>(1);
        data.put("reportVO", reportVO());
        data.put("lineChartImgUrl", lineUrl);
        data.put("barChartImgUrl", barUrl);

        // 指定调用模板, 当前只有 车主及车辆数据报告 模板
        String html = FreemarkerUtil.genFtl2String("report.ftl", data);

        // 可打印 HTML 文本信息
        System.out.println(html);

        // 这里是直接在本地生成了 PDF 文件,Html2PDF 类提供多个方法, 另外可直接使用 OutputStream 实现下载功能
        // 具体见 Html2PDF 工具类, 可根据实际需要做适当扩展
        Html2PDF.writeStringToPDF(html, "C:\\Users\\MinGRn\\Desktop\\新建文件夹\\车主及车辆数据报告.pdf");
    }

    // 演示直接将绘制的统计图以图片的形式保存在本地
    public static void downloadChartImg() throws IOException {
        // 数据封装, 同上
        CategoryData barData = new CategoryData();
        barData.setSeriesName("时间区间");
        barData.add(new Node("0-6点", 3));
        barData.add(new Node("6-10点", 35));
        barData.add(new Node("10-14点", 8));
        barData.add(new Node("14-18点", 11));
        barData.add(new Node("18-20点", 39));
        barData.add(new Node("20-24点", 15));

        // 绘制统计图
        DrawBarChart drawBarChart = DrawChartFactory.INSTANCE.createBar(700, 2000);
        // 生成 IO
        InputStream bar = drawBarChart.create("时间区间-累计小时", barData);

        // 转BufferedImage
        BufferedImage image = ImageIO.read(bar);

        // 保存图片
        ImageIO.write(image, "JPG", new File("C:\\Users\\MinGRn\\Desktop\\新建文件夹\\bar.jpg"));
    }

    /**
     * OwnerAndCarReportVO 数据封装, 该类对应 车主及车辆数据报告 模板
     * 需要注意在该类内部的 故障码集合 和 违章信息集合
     */
    private static OwnerAndCarReportVO reportVO() {

        // 下面的数据都是非必填项, 如果有数据空缺在模板页面中已做空字符处理
        OwnerAndCarReportVO reportVO = new OwnerAndCarReportVO();
        reportVO.setOrderNum("65203135920180000000");
        reportVO.setReportTime("2019/5/8");
        reportVO.setDateTime("（2019-01 至 2019-02）");
        reportVO.setOwnerName("马晨迪");
        reportVO.setGender("男");
        reportVO.setAge(27);
        reportVO.setPhone("13800000000");
        reportVO.setIdCard("34122100000000000");
        reportVO.setFrameNum("LDCC43X3390936092");
        reportVO.setPlateNum("浙A88888888");
        reportVO.setCarAge(5);
        reportVO.setTrademark("宝马");
        reportVO.setModel("x5");
        reportVO.setColor("青春红");
        reportVO.setBrakeOut(66);
        reportVO.setOilOut(105);
        reportVO.setAvgDriverDurable(1.8);
        reportVO.setAvgMileage(33);
        reportVO.setTotalMileage(1726);
        reportVO.setAvgOil(8.9);
        reportVO.setRescue(2);
        reportVO.setWashCar(5);
        reportVO.setDesignatedDriver(2);
        reportVO.setAccidentDriver(1);
        reportVO.setMaintain(1);
        reportVO.setInspect(0);

        // 这里设置故障码集合
        reportVO.addFaultCodeVO(new FaultCodeVO("2019/1/23", "P0106"));
        reportVO.addFaultCodeVO(new FaultCodeVO("2019/2/6", "P0115"));

        // 这里设置违章信息集合
        reportVO.addIllegalRecordVO(new IllegalRecordVO("2019/1/10", "高速道路超速"));
        reportVO.addIllegalRecordVO(new IllegalRecordVO("22019/2/14", "直线变道"));

        return reportVO;
    }
}
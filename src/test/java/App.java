
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
 * 测试用例
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 2019/6/5 19:12
 */
@SuppressWarnings("unchecked")
public class App {

    public static void main(String[] args) throws IOException {
        // 测试生成统计图片
        downloadChartImg();

        // 测试生成PDF
        genPDF();
    }

    public static void genPDF() throws IOException {

        CategoryData lineData = new CategoryData();
        lineData.setSeriesName("时速");
        lineData.add(new Node("0-30MPH", 20));
        lineData.add(new Node("30-60MPH", 30));
        lineData.add(new Node("60-80MPH", 25));
        lineData.add(new Node("80-100MPH", 15));
        lineData.add(new Node("100-120MPH", 12));
        lineData.add(new Node("120-140MPH", 4));
        lineData.add(new Node("100MPH以上", 2));

        DrawLineChart drawLineChart = DrawChartFactory.INSTANCE.createLine(700, 2000);
        InputStream lineIO = drawLineChart.create("时速-时间关系表", lineData);

        CategoryData barData = new CategoryData();
        barData.setSeriesName("时间区间");
        barData.add(new Node("0-6点", 3));
        barData.add(new Node("6-10点", 35));
        barData.add(new Node("10-14点", 8));
        barData.add(new Node("14-18点", 11));
        barData.add(new Node("18-20点", 39));
        barData.add(new Node("20-24点", 15));

        DrawBarChart drawBarChart = DrawChartFactory.INSTANCE.createBar(700, 2000);
        InputStream barIO = drawBarChart.create("时间区间-累计小时", barData);


        // 将 lineIO 和 barIO 图片流上传至合适的服务器,并返回图片链接, 用于 PDF 展示统计图图片使用
        String lineUrl = AliUploadUtil.uploadImage(lineIO, "drawLineChart.jpg");
        String barUrl = AliUploadUtil.uploadImage(barIO, "drawBarChart.jpg");


        Map<String, Object> data = new HashMap<>(1);
        data.put("reportVO", reportVO());
        data.put("lineChartImgUrl", lineUrl);
        data.put("barChartImgUrl", barUrl);

        // 指定调用模板
        String html = FreemarkerUtil.genFtl2String("report.ftl", data);
        System.out.println(html);

        Html2PDF.writeStringToPDF(html, "C:\\Users\\MinGRn\\Downloads\\IMG\\车主及车辆数据报告.pdf");
    }

    public static void downloadChartImg() throws IOException {
        CategoryData barData = new CategoryData();
        barData.setSeriesName("时间区间");
        barData.add(new Node("0-6点", 3));
        barData.add(new Node("6-10点", 35));
        barData.add(new Node("10-14点", 8));
        barData.add(new Node("14-18点", 11));
        barData.add(new Node("18-20点", 39));
        barData.add(new Node("20-24点", 15));

        DrawBarChart drawBarChart = DrawChartFactory.INSTANCE.createBar(700, 2000);
        InputStream bar = drawBarChart.create("时间区间-累计小时", barData);

        BufferedImage image = ImageIO.read(bar);

        ImageIO.write(image, "JPG", new File("C:\\Users\\MinGRn\\Downloads\\IMG\\bar1.jpg"));
    }

    private static OwnerAndCarReportVO reportVO(){
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
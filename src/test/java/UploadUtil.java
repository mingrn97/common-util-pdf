
import java.io.*;
import java.util.Random;

/**
 * 文件上传工具测试用例
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 2019/6/5 20:26
 */
public class UploadUtil {
    private UploadUtil() {
    }

    /**
     * 图片上传
     *
     * @param is  输入流
     * @param key 存储文件名称
     */
    public static String uploadImage(InputStream is, String key) {

        // 这里仅仅是告诉你需要将图片上传, 并返回图片链接
        return new Random().nextInt(10) > 5 ? "https://test-one-road.oss.aliyuncs.com/REPORT/drawLineChart.jpg" : "https://test-one-road.oss.aliyuncs.com/REPORT/drawBarChart.jpg";
    }
}
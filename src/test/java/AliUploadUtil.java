
import java.io.*;
import java.util.Random;

/**
 * ali云文件存储服务器工具类
 *
 * @author zhang.shilin <br > 27/09/2018 11:04
 * @Email zhang.shilin@yilutong.com
 * @see #uploadImage 图片上传
 */
public class AliUploadUtil {
    private AliUploadUtil() {
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
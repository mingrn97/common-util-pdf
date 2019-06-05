package com.mingrn.commons.pdf;

import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * 图片转化base64后再UrlEncode结果
 * <p>
 * 扩展:
 * Base64编码图片可作为 HTML 使用,如下示例:
 * <pre>{@code
 *     // CSS中使用
 *     .bag {
 *         background-image: url(data:image/gif;base64,<base64编码字符>)
 *     }
 *
 *     // HTML <img /> 使用:
 *     <img src="data:image/gif;base64,<base64编码字符>" />
 * }</pre>
 * <p>
 * 上面的示例中使用到: <code>data:image/gif;base64,base64</code> 意思是gif图片数据. 其他还有如数据:
 * <pre>{@code
 *   data:,                                   文本数据
 *   data:text/plain,                         文本数据
 *   data:text/html,                          HTML代码
 *   data:text/html;base64,                   base64编码的HTML代码
 *   data:text/css,                           CSS代码
 *   data:text/css;base64,                    base64编码的CSS代码
 *   data:text/javascript,                    Javascript代码
 *   data:text/javascript;base64,             base64编码的Javascript代码
 *   data:image/png;base64,                   base64编码的png图片数据
 *   data:image/jpeg;base64,                  base64编码的jpeg图片数据
 *   data:image/x-icon;base64,                base64编码的icon图片数据
 * }</pre>
 *
 * @author MinGR
 */
public class BaseImg64Utils {


    /**
     * 将图片转换成base64格式进行存储
     *
     * @param imagePath IMG地址
     * @return base64 IMG 字符串
     */
    public static String base64(String imagePath) throws IOException {
        String type = imagePath.contains(".") ? StringUtils.substring(imagePath, imagePath.lastIndexOf(".") + 1) : "";

        BufferedImage image = ImageIO.read(new File(imagePath));

        return base64(image, type);
    }

    /**
     * 将图片转换成base64格式进行存储
     *
     * @param img  IMG IO
     * @param type IMG 类型, png, jpg ...
     * @return base64 IMG 字符串
     */
    public static String base64(InputStream img, String type) throws IOException {

        BufferedImage image = ImageIO.read(img);

        return base64(image, type);
    }

    /**
     * Base64 编码
     *
     * @param image IMG
     * @param type  IMG 类型
     * @return base64 IMG 字符串
     */
    public static String base64(BufferedImage image, String type) {
        String imageString = null;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();
            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }
}
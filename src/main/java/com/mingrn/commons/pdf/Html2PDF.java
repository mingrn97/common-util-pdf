package com.mingrn.commons.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * {@link #writeStringToPDF(String, String)} 接受输入流形式的 html 文件,然后将 pdf 写入到输出流中.
 * 最后输出到指定的 {@code outputPath} 路径.
 * <p>
 * {@link #writeToOutputStreamAsPDF(InputStream, OutputStream)} 接受输入流形式的 html 文件,然后将
 * PDF写入到输出流中.
 * <p>
 * 而 {@link #writeStringToOutputStreamAsPDF(String, OutputStream)} 方法则接受文本形式的 html 文件,
 * 方便做一些模板替换的预处理工作,当然也可以结合 vm,fm 等模板引擎进行模板文件数据渲染,请自行了解.
 * <p>
 * 另外, <code>OutputStream</code> 输出流可作为文件输出流写入到生成 PDF 文件,也可以作为 web 环境下的
 * <code>response</code> 提供 PDF 文档显示与下载功能.
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 2019/6/5 16:45
 */
public class Html2PDF {

    public static void writeStringToPDF(String html, String outputPath) {
        try (OutputStream os = new FileOutputStream(outputPath)) {
            writeToOutputStreamAsPDF(new ByteArrayInputStream(html.getBytes()), os);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeStringToOutputStreamAsPDF(String html, OutputStream os) {
        writeToOutputStreamAsPDF(new ByteArrayInputStream(html.getBytes()), os);
    }

    public static void writeToOutputStreamAsPDF(InputStream html, OutputStream os) {
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter pdfWriter = PdfWriter.getInstance(document, os);
            document.open();
            XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
            worker.parseXHtml(pdfWriter, document, html, StandardCharsets.UTF_8, new AsianFontProvider());
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * 用于中文显示的 Provider
 */
class AsianFontProvider extends XMLWorkerFontProvider {
    @Override
    public Font getFont(final String fontName, String encoding, float size, final int style) {
        try {
            BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            return new Font(bfChinese, size, style);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.getFont(fontName, encoding, size, style);
    }
}




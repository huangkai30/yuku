package com.lastcompany.haiwaicang.util;

//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.pdf.BaseFont;
//import org.xhtmlrenderer.pdf.ITextFontResolver;
//import org.xhtmlrenderer.pdf.ITextRenderer;

public class PDFUtil
{
    /**
     * HTML代码转PDF文档
     *
     * @param content 待转换的HTML代码
     * @param storagePath 保存为PDF文件的路径
     */
//    public static void parsePdf(String content, String storagePath) {
//        FileOutputStream os = null;
//        try {
//            File file = new File(storagePath);
//            if(!file.exists()) {
//                file.createNewFile();
//            }
//            os = new FileOutputStream(file);
//
//            ITextRenderer renderer = new ITextRenderer();
//            //解决中文支持问题
//            ITextFontResolver resolver = renderer.getFontResolver();
//            resolver.addFont("/static/font/ARIALUNI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//            renderer.setDocumentFromString(content);
//            // 解决图片的相对路径问题,图片路径必须以file开头
//            // renderer.getSharedContext().setBaseURL("file:/");
//            renderer.layout();
//            renderer.createPDF(os);
//
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            if(null != os) {
//                try {
//                    os.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}

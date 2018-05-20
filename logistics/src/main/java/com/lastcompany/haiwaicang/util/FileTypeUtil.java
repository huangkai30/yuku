package com.lastcompany.haiwaicang.util;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class FileTypeUtil {

	public static boolean isImage(InputStream in) {
		ImageInputStream image;
		try {
			image = ImageIO.createImageInputStream(in);
			Iterator<?> iter = ImageIO.getImageReaders(image);
			if (iter.hasNext()) {//文件不是图片 
				return true;
			}
			return false;
		} catch (IOException e) {
			return false;
		}
	}

	public static boolean isRgbOrCmyk(InputStream file) throws IOException {
		boolean isRgb=true;//true是Rgb否则是Cmyk
		//创建输入流
		ImageInputStream input = ImageIO.createImageInputStream(file);
		Iterator readers = ImageIO.getImageReaders(input);
		if (readers == null || !readers.hasNext()) {
			throw new RuntimeException("No ImageReaders found");
		}
		ImageReader reader = (ImageReader) readers.next();
		reader.setInput(input);
		//获取文件格式
		BufferedImage image;
		try {
			// 尝试读取图片 (包括颜色的转换).
			reader.read(0); // RGB
			isRgb=true;
		} catch (IIOException e) {
			// 读取Raster (没有颜色的转换).
			reader.readRaster(0, null);// CMYK
			isRgb=false;
		}
		return  isRgb;
	}
}

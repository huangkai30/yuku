package com.lastcompany.haiwaicang.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class AuctionIDProduce {
	public static Long getPaymentID(){
		int r1=(int)(Math.random()*(10));//产生2个0-9的随机数
		int r2=(int)(Math.random()*(10));
		long now = System.currentTimeMillis();//一个13位的时间戳
		String paymentID =String.valueOf(r1)+String.valueOf(r2)+String.valueOf(now);// 订单ID
		return  Long.valueOf(paymentID);
	} 
	
	
	public static String getUUID(){
		 UUID uuid = UUID.randomUUID();
		 return uuid.toString().replace("-", "");
	}
	
	public static String getOrderContractID(){
		int r1=(int)(Math.random()*(10));//产生2个0-9的随机数
		int r2=(int)(Math.random()*(10));
		long now = System.currentTimeMillis();//一个13位的时间戳
		String paymentID =String.valueOf(r1)+String.valueOf(r2)+String.valueOf(now);// 订单ID
		return paymentID;
	} 
	
	public static String getPaymentOrderId(){
		int r1=(int)(Math.random()*(10));//产生4个0-9的随机数
		int r2=(int)(Math.random()*(10));
		int r3=(int)(Math.random()*(10));
		int r4=(int)(Math.random()*(10));
		long now = System.currentTimeMillis();//一个13位的时间戳
		String paymentID =String.valueOf(r1)+String.valueOf(r2)+String.valueOf(r3)+String.valueOf(r4)+String.valueOf(now);// 订单ID
		return  paymentID;
	}
	
	public static Long getSerialNumber(){
		int r1=(int)(Math.random()*(10));//产生2个0-9的随机数
		int r2=(int)(Math.random()*(10));
		SimpleDateFormat sf = new SimpleDateFormat("YYYYMMddHHmmss");
		String time = sf.format(new Date());
		String paymentID = time+String.valueOf(r1)+String.valueOf(r2);
		return  Long.valueOf(paymentID);
	}
}

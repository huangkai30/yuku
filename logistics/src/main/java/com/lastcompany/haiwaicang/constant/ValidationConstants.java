package com.lastcompany.haiwaicang.constant;

/**
 * 校验常量。
 * 
 */
public class ValidationConstants {
	public static final String COMMON_ID_REGEX = "\\d{1,20}";

	// email为任意字符串,只要中间包含一个.
	public static final String USER_EMAIL_REGEX = "([a-zA-Z0-9_.-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-]+)+";
	// password为任意非空白字符，长度为6到30
	public static final String USER_PASSWORD_REGEX = "\\S{6,30}";
	// 账户为任意非空白字符，长度为2到20
	public static final String USER_NICK_NAME_REGEX = ".{2,40}";
	// 真实姓名为任意字符，长度为3到40
	public static final String USER_REAL_NAME_REGEX = ".{3,40}";
	// 手机号码为0、1开头+10位数字或2-9+9或10位数字
	//public static final String USER_PHONE_REGEX = "(0\\d{10})|(1\\d{10})|([2-9]\\d{9,10})";
	//public static final String USER_PHONE_REGEX = "([0-9]\\d{9,14})";
	public static final String USER_PHONE_REGEX = ".{10,18}";//因为格式能包含+（）-等符号，这里就只能限制长度了
	// qq号码为5到12位数字组成
	public static final String USER_QQ_REGEX = "\\d{0,20}";
	// 国家为任意字符，长度为0到50
	public static final String USER_COUNTRY_REGEX = ".{0,50}";
	// 地址信息
	public static final String USER_ADDRESS_REGEX = ".{0,150}";

	// 任意字符，2到10个
	public static final String CONSIGNEE_NAME_REGEX = ".{2,10}";
	// 任意字符，2到10个
	public static final String CONSIGNEE_PROVINCE_REGEX = ".{2,10}";
	// 任意字符，2到10个
	public static final String CONSIGNEE_CITY_REGEX = ".{2,10}";
	// 任意字符，2到10个
	public static final String CONSIGNEE_DISTRICT_REGEX = ".{2,10}";
	// 任意字符，2到100个
	public static final String CONSIGNEE_STREET_ADDRESS_REGEX = ".{2,100}";
	// 数字，5到10个
	public static final String CONSIGNEE_ZIP_CODE_REGEX = "\\d{5,10}";
	// 数字，11个
	public static final String CONSIGNEE_PHONE_REGEX = USER_PHONE_REGEX;//".{0,20}";
	// 任意字符，0到15个
	public static final String CONSIGNEE_TELEPHONE_REGEX = USER_PHONE_REGEX;//".{0,20}";
	// 11到18个字符，最后一个可能为x，其他字符均为数字
	public static final String CONSIGNEE_CARD_ID = "[\\d]{10,17}(\\d|x|X)";

	public static final String MESSAGE_CONTENT_REGEX = ".{2,200}";

	public static final String ERROR_ORDER_CONTENT_REGEX = ".{2,200}";

	public static final String ERROR_TORDER_CONTENT_REGEX = ".{2,200}";

	public static final String ORDER_ID_REGEX = ".{2,30}";

	public static final String PRE_TRANSPORT_NUMBER = "\\d{8,}";
	public static final String PRE_COMPANY_NAME = "\\S{1,10}";
	public static final String PRE_GOODS_INFO = ".{1,500}";

	public static final String EMPLOYEE_ACCOUNT_REGEX = ".{2,20}";
	public static final String EMPLOYEE_PASSWORD_REGEX = "\\S{6,20}";
	public static final String EMPLOYEE_STORE_ID_REGEX = ".{0,20}";
	public static final String EMPLOYEE_STORE_NAME_REGEX = ".{0,20}";
	public static final String EMPLOYEE_PHONE = USER_PHONE_REGEX;//".{0,20}";

	public static final String CREDIT_NAME_REGEX = ".{1,50}";
	public static final String CREDIT_ZIP_CODE_REGEX = "\\d{4,10}";
	public static final String CREDIT_ADDRESS_REGEX = ".{1,100}";
	public static final String CREDIT_NO_REGEX = ".{5,30}";
	public static final String CREDIT_CODE_REGEX = ".{1,10}";
	public static final String CREDIT_PROVINCE_REGEX = ".{1,90}";
	public static final String CREDIT_CITY_REGEX = ".{1,90}";
	public static final String CREDIT_EXPIRE_YEAR = "\\d{1,10}";
	public static final String CREDIT_EXPIRE_MONTH = "((0)?[1-9])|(1[0-2])";
	public static final String CREDIT_TYPE_REGEX = ".{1,10}";
	
	
	// 任意字符，2到50个
	public static final String CALL_ORDER_NAME_REGEX = ".{2,50}";
	// 任意字符，2到100个
	public static final String CALL_ORDER_PROVINCE_REGEX = ".{2,100}";
	// 任意字符，2到100个
	public static final String CALL_ORDER_CITY_REGEX = ".{2,100}";
	// 任意字符，2到100个
	public static final String CALL_ORDER_DISTRICT_REGEX = ".{2,100}";
	// 任意字符，2到100个
	public static final String CALL_ORDER_STREET_ADDRESS_REGEX = ".{2,255}";
	// 数字，5到10个
	public static final String CALL_ORDER_ZIP_CODE_REGEX = "\\d{5,10}";
	// 数字，11个
	public static final String CALL_ORDER_PHONE_REGEX = USER_PHONE_REGEX;//".{0,20}";
}

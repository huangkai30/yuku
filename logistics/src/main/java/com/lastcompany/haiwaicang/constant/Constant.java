package com.lastcompany.haiwaicang.constant;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 开发框架基础架构的公共常量设置类
 *
 */
public class Constant {

//	public static final int temp_houseid = 13;
	public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	//member constant
	public static final String SESSION_MEMBER_USERID = "session_member_user_id";
	public static final String SESSION_MEMBER_USERNAME = "session_member_user_name";

	public static final String SESSION_MEMBER_PHONE = "session_member_phone";//用户的电话
	public static final String SESSION_MEMBER_EMAIL= "session_member_email";//用户的邮箱
	public static final String SECURITY_CODE_NEED_NUM_RECORD_MEMBER ="security_code_need_num_recode_member";//记录用户登次数，超过一定值必须输入验证码
	public static final int SECURITY_CODE_NEED_NUM_MEMBER = 3;//超过此值，将要求输入验证码
	public static final String KAPTCHA_SESSION_MEMBER_KEY = "kaptcha_session_member_key";




	//操作类型，0表示添加商品，1表示进库，2表示出库，3表示修改商品信息,4表示修改会员信息,5修改用户密码,6删除商品
	public static final String HANDLE_RECORDS_TYPE_0="0";//
	public static final String HANDLE_RECORDS_TYPE_1="1";//
	public static final String HANDLE_RECORDS_TYPE_2="2";//
	public static final String HANDLE_RECORDS_TYPE_3="3";//
	public static final String HANDLE_RECORDS_TYPE_4="4";//
	public static final String HANDLE_RECORDS_TYPE_5="5";//
	public static final String HANDLE_RECORDS_TYPE_6="6";//


	//house constant
	public static final String SESSION_HOUSE_USERID = "session_house_user_id";//userID
	public static final String SESSION_SUBHOUSE_USERID = "session_subhouse_user_id";//subhouseID

	public static final String SESSION_ADMIN_USERID = "session_admin_user_id";//adminId
	public static final String SESSION_SUBADMIN_USERID = "session_subadmin_user_id";//subAdminId

	public static final String SESSION_HOUSE_PHONE = "session_house_phone";//用户的电话
	public static final String SESSION_HOUSE_EMAIL= "session_house_email";//用户的邮箱
	public static final String SECURITY_CODE_NEED_NUM_RECORD_HOUSE ="security_code_need_num_recode_house";//记录用户登次数，超过一定值必须输入验证码
	public static final int SECURITY_CODE_NEED_NUM_HOUSE = 3;//超过此值，将要求输入验证码
	public static final String KAPTCHA_SESSION_HOUSE_KEY = "kaptcha_session_house_key";

	public static final String SECURITY_CODE_NEED_NUM_RECORD_ADMIN ="security_code_need_num_recode_admin";//记录用户登次数，超过一定值必须输入验证码
	public static final int SECURITY_CODE_NEED_NUM_ADMIN = 3;//超过此值，将要求输入验证码
	public static final String KAPTCHA_SESSION_ADMIN_KEY = "kaptcha_session_admin_key";

	public static final String KAPTCHA_CONTACT_US_KEY = "kaptcha_contact_us_key";

	public static final String LOGIN_ACCOUNT_TYPE = "LOGIN_ACCOUNT_TYPE"; //1.MEMBER`  2.HOUSE 3.sub_house
	public static final String LOGIN_ADMIN_ACCOUNT_TYPE = "LOGIN_ADMIN_ACCOUNT_TYPE"; //2.ADMIN 3.SUB_ADMIN

	public static final long RESET_PWD_TOKEN_TIME_OF_HOUR = 24L;
	public static final long RESET_PWD_TOKEN_TIME = RESET_PWD_TOKEN_TIME_OF_HOUR * 60 * 60; // 一天，多少秒

	public static final String AUTO_SEND_FORGET_PASSWORD = "Bidlife Reset Password";
	public static final String AUTO_SEND_REGIST_MEMBER = "Bidlife Registration Confirm";

	public static final String SECURITY_CODE_KEY = "SECURITY_CODE_KEY";//验证码


	public static final Integer SPACE_LENGTH = 10; //用户空间

	/**失败标识-文字*/
	public static final String FAIL_TEXT = "FAIL";
	/**成功标识-文字*/
	public static final String SUCCESS_TEXT = "SUCCESS";
	/**整个应用0表示失败*/
	public static final String FAIL="0";
	/**整个应用1表示成功*/
	public static final String SECCUESS="1";
	/**未登录*/
	public static final String NO_LOGIN = "-1";
	/**未授权*/
	public static final String NO_AUTHORITY = "-2";

	//操作类型，1用户登陆，2后台登陆
	public static final String LOGIN_TYPE_USER="1";
	public static final String LOGIN_TYPE_ADMIN="2";


	/**整个应用0表示否*/
	public static final int NO = 0;
	/**整个应用1表示是*/
	public static final int YES = 1;
	
	/**默认的分页每页记录数*/
	public static final int DEFAULT_PAGE_SIZE = 10;

	public final static String BASE_URL_NET = "http://www.bidlife.net/";

//	public final static String BASE_URL_COM = "http://www.bidlife.com/";
	public final static String BASE_URL_COM = "http://47.89.247.164:8080/";

	public final static int AUCTION_STATUS_CREATED = 1;//auction已经创建成功标志

	public static Map<String,Set<String>> ONLINE_BIDDERS = new ConcurrentHashMap<>();//在线bidder人数


//	public final static String CURRENCY_URL = "http://download.finance.yahoo.com/d/quotes.csv?e=.csv&f=sl1d1t1&s=CNYUSD=x+CNYAUD=x+CNYBRL=x+CNYCAD=x+CNYCHF=x+CNYCZK=x+CNYDKK=x+CNYEUR=x+CNYGBP=x+CNYHKD=x+CNYIDR=x+CNYINR=x+CNYJPY=x+CNYKRW=x+CNYMXN=x+CNYMYR=x+CNYNZD=x+CNYPHP=x+CNYSEK=x+CNYSGD=x+CNYTWD=x+CNYZAR=x" +
//			"+USDCNY=x+USDAUD=x+USDBRL=x+USDCAD=x+USDCHF=x+USDCZK=x+USDDKK=x+USDEUR=x+USDGBP=x+USDHKD=x+USDIDR=x+USDINR=x+USDJPY=x+USDKRW=x+USDMXN=x+USDMYR=x+USDNZD=x+USDPHP=x+USDSEK=x+USDSGD=x+USDTWD=x+USDZAR=x" +
//			"+AUDUSD=x+AUDCNY=x+AUDBRL=x+AUDCAD=x+AUDCHF=x+AUDCZK=x+AUDDKK=x+AUDEUR=x+AUDGBP=x+AUDHKD=x+AUDIDR=x+AUDINR=x+AUDJPY=x+AUDKRW=x+AUDMXN=x+AUDMYR=x+AUDNZD=x+AUDPHP=x+AUDSEK=x+AUDSGD=x+AUDTWD=x+AUDZAR=x" +
//			"+BRLUSD=x+BRLAUD=x+BRLCNY=x+BRLCAD=x+BRLCHF=x+BRLCZK=x+BRLDKK=x+BRLEUR=x+BRLGBP=x+BRLHKD=x+BRLIDR=x+BRLINR=x+BRLJPY=x+BRLKRW=x+BRLMXN=x+BRLMYR=x+BRLNZD=x+BRLPHP=x+BRLSEK=x+BRLSGD=x+BRLTWD=x+BRLZAR=x" +
//			"+CADUSD=x+CADAUD=x+CADBRL=x+CADCNY=x+CADCHF=x+CADCZK=x+CADDKK=x+CADEUR=x+CADGBP=x+CADHKD=x+CADIDR=x+CADINR=x+CADJPY=x+CADKRW=x+CADMXN=x+CADMYR=x+CADNZD=x+CADPHP=x+CADSEK=x+CADSGD=x+CADTWD=x+CADZAR=x" +
//			"+CHFUSD=x+CHFAUD=x+CHFBRL=x+CHFCAD=x+CHFCNY=x+CHFCZK=x+CHFDKK=x+CHFEUR=x+CHFGBP=x+CHFHKD=x+CHFIDR=x+CHFINR=x+CHFJPY=x+CHFKRW=x+CHFMXN=x+CHFMYR=x+CHFNZD=x+CHFPHP=x+CHFSEK=x+CHFSGD=x+CHFTWD=x+CHFZAR=x" +
//			"+CZKUSD=x+CZKAUD=x+CZKBRL=x+CZKCAD=x+CZKCHF=x+CZKCNY=x+CZKDKK=x+CZKEUR=x+CZKGBP=x+CZKHKD=x+CZKIDR=x+CZKINR=x+CZKJPY=x+CZKKRW=x+CZKMXN=x+CZKMYR=x+CZKNZD=x+CZKPHP=x+CZKSEK=x+CZKSGD=x+CZKTWD=x+CZKZAR=x" +
//			"+DKKUSD=x+DKKAUD=x+DKKBRL=x+DKKCAD=x+DKKCHF=x+DKKCZK=x+DKKCNY=x+DKKEUR=x+DKKGBP=x+DKKHKD=x+DKKIDR=x+DKKINR=x+DKKJPY=x+DKKKRW=x+DKKMXN=x+DKKMYR=x+DKKNZD=x+DKKPHP=x+DKKSEK=x+DKKSGD=x+DKKTWD=x+DKKZAR=x" +
//			"+EURUSD=x+EURAUD=x+EURBRL=x+EURCAD=x+EURCHF=x+EURCZK=x+EURDKK=x+EURCNY=x+EURGBP=x+EURHKD=x+EURIDR=x+EURINR=x+EURJPY=x+EURKRW=x+EURMXN=x+EURMYR=x+EURNZD=x+EURPHP=x+EURSEK=x+EURSGD=x+EURTWD=x+EURZAR=x" +
//			"+GBPUSD=x+GBPAUD=x+GBPBRL=x+GBPCAD=x+GBPCHF=x+GBPCZK=x+GBPDKK=x+GBPEUR=x+GBPCNY=x+GBPHKD=x+GBPIDR=x+GBPINR=x+GBPJPY=x+GBPKRW=x+GBPMXN=x+GBPMYR=x+GBPNZD=x+GBPPHP=x+GBPSEK=x+GBPSGD=x+GBPTWD=x+GBPZAR=x" +
//			"+HKDUSD=x+HKDAUD=x+HKDBRL=x+HKDCAD=x+HKDCHF=x+HKDCZK=x+HKDDKK=x+HKDEUR=x+HKDGBP=x+HKDCNY=x+HKDIDR=x+HKDINR=x+HKDJPY=x+HKDKRW=x+HKDMXN=x+HKDMYR=x+HKDNZD=x+HKDPHP=x+HKDSEK=x+HKDSGD=x+HKDTWD=x+HKDZAR=x" +
//			"+IDRUSD=x+IDRAUD=x+IDRBRL=x+IDRCAD=x+IDRCHF=x+IDRCZK=x+IDRDKK=x+IDREUR=x+IDRGBP=x+IDRHKD=x+IDRCNY=x+IDRINR=x+IDRJPY=x+IDRKRW=x+IDRMXN=x+IDRMYR=x+IDRNZD=x+IDRPHP=x+IDRSEK=x+IDRSGD=x+IDRTWD=x+IDRZAR=x" +
//			"+INRUSD=x+INRAUD=x+INRBRL=x+INRCAD=x+INRCHF=x+INRCZK=x+INRDKK=x+INREUR=x+INRGBP=x+INRHKD=x+INRIDR=x+INRCNY=x+INRJPY=x+INRKRW=x+INRMXN=x+INRMYR=x+INRNZD=x+INRPHP=x+INRSEK=x+INRSGD=x+INRTWD=x+INRZAR=x" +
//			"+JPYUSD=x+JPYAUD=x+JPYBRL=x+JPYCAD=x+JPYCHF=x+JPYCZK=x+JPYDKK=x+JPYEUR=x+JPYGBP=x+JPYHKD=x+JPYIDR=x+JPYINR=x+JPYCNY=x+JPYKRW=x+JPYMXN=x+JPYMYR=x+JPYNZD=x+JPYPHP=x+JPYSEK=x+JPYSGD=x+JPYTWD=x+JPYZAR=x" +
//			"+KRWUSD=x+KRWAUD=x+KRWBRL=x+KRWCAD=x+KRWCHF=x+KRWCZK=x+KRWDKK=x+KRWEUR=x+KRWGBP=x+KRWHKD=x+KRWIDR=x+KRWINR=x+KRWJPY=x+KRWCNY=x+KRWMXN=x+KRWMYR=x+KRWNZD=x+KRWPHP=x+KRWSEK=x+KRWSGD=x+KRWTWD=x+KRWZAR=x" +
//			"+MXNUSD=x+MXNAUD=x+MXNBRL=x+MXNCAD=x+MXNCHF=x+MXNCZK=x+MXNDKK=x+MXNEUR=x+MXNGBP=x+MXNHKD=x+MXNIDR=x+MXNINR=x+MXNJPY=x+MXNKRW=x+MXNCNY=x+MXNMYR=x+MXNNZD=x+MXNPHP=x+MXNSEK=x+MXNSGD=x+MXNTWD=x+MXNZAR=x" +
//			"+MYRUSD=x+MYRAUD=x+MYRBRL=x+MYRCAD=x+MYRCHF=x+MYRCZK=x+MYRDKK=x+MYREUR=x+MYRGBP=x+MYRHKD=x+MYRIDR=x+MYRINR=x+MYRJPY=x+MYRKRW=x+MYRMXN=x+MYRCNY=x+MYRNZD=x+MYRPHP=x+MYRSEK=x+MYRSGD=x+MYRTWD=x+MYRZAR=x" +
//			"+NZDUSD=x+NZDAUD=x+NZDBRL=x+NZDCAD=x+NZDCHF=x+NZDCZK=x+NZDDKK=x+NZDEUR=x+NZDGBP=x+NZDHKD=x+NZDIDR=x+NZDINR=x+NZDJPY=x+NZDKRW=x+NZDMXN=x+NZDMYR=x+NZDCNY=x+NZDPHP=x+NZDSEK=x+NZDSGD=x+NZDTWD=x+NZDZAR=x" +
//			"+PHPUSD=x+PHPAUD=x+PHPBRL=x+PHPCAD=x+PHPCHF=x+PHPCZK=x+PHPDKK=x+PHPEUR=x+PHPGBP=x+PHPHKD=x+PHPIDR=x+PHPINR=x+PHPJPY=x+PHPKRW=x+PHPMXN=x+PHPMYR=x+PHPNZD=x+PHPCNY=x+PHPSEK=x+PHPSGD=x+PHPTWD=x+PHPZAR=x" +
//			"+SEKUSD=x+SEKAUD=x+SEKBRL=x+SEKCAD=x+SEKCHF=x+SEKCZK=x+SEKDKK=x+SEKEUR=x+SEKGBP=x+SEKHKD=x+SEKIDR=x+SEKINR=x+SEKJPY=x+SEKKRW=x+SEKMXN=x+SEKMYR=x+SEKNZD=x+SEKPHP=x+SEKCNY=x+SEKSGD=x+SEKTWD=x+SEKZAR=x" +
//			"+SGDUSD=x+SGDAUD=x+SGDBRL=x+SGDCAD=x+SGDCHF=x+SGDCZK=x+SGDDKK=x+SGDEUR=x+SGDGBP=x+SGDHKD=x+SGDIDR=x+SGDINR=x+SGDJPY=x+SGDKRW=x+SGDMXN=x+SGDMYR=x+SGDNZD=x+SGDPHP=x+SGDSEK=x+SGDCNY=x+SGDTWD=x+SGDZAR=x" +
//			"+TWDUSD=x+TWDAUD=x+TWDBRL=x+TWDCAD=x+TWDCHF=x+TWDCZK=x+TWDDKK=x+TWDEUR=x+TWDGBP=x+TWDHKD=x+TWDIDR=x+TWDINR=x+TWDJPY=x+TWDKRW=x+TWDMXN=x+TWDMYR=x+TWDNZD=x+TWDPHP=x+TWDSEK=x+TWDSGD=x+TWDCNY=x+TWDZAR=x" +
//			"+ZARUSD=x+ZARAUD=x+ZARBRL=x+ZARCAD=x+ZARCHF=x+ZARCZK=x+ZARDKK=x+ZAREUR=x+ZARGBP=x+ZARHKD=x+ZARIDR=x+ZARINR=x+ZARJPY=x+ZARKRW=x+ZARMXN=x+ZARMYR=x+ZARNZD=x+ZARPHP=x+ZARSEK=x+ZARSGD=x+ZARTWD=x+ZARCNY=x";

			public final static String[] CURRENCY_URL ={"CNYUSD=x","CNYAUD=x","CNYBRL=x","CNYCAD=x","CNYCHF=x","CNYCZK=x","CNYDKK=x","CNYEUR=x","CNYGBP=x","CNYHKD=x","CNYIDR=x","CNYINR=x","CNYJPY=x","CNYKRW=x","CNYMXN=x","CNYMYR=x","CNYNZD=x","CNYPHP=x","CNYSEK=x","CNYSGD=x","CNYTWD=x",
					"CNYZAR=x","USDCNY=x","USDAUD=x","USDBRL=x","USDCAD=x","USDCHF=x","USDCZK=x","USDDKK=x","USDEUR=x","USDGBP=x","USDHKD=x","USDIDR=x","USDINR=x","USDJPY=x","USDKRW=x","USDMXN=x","USDMYR=x","USDNZD=x","USDPHP=x","USDSEK=x","USDSGD=x","USDTWD=x",
					"USDZAR=x","AUDUSD=x","AUDCNY=x","AUDBRL=x","AUDCAD=x","AUDCHF=x","AUDCZK=x","AUDDKK=x","AUDEUR=x","AUDGBP=x","AUDHKD=x","AUDIDR=x","AUDINR=x","AUDJPY=x","AUDKRW=x","AUDMXN=x","AUDMYR=x","AUDNZD=x","AUDPHP=x","AUDSEK=x","AUDSGD=x","AUDTWD=x",
					"AUDZAR=x","BRLUSD=x","BRLAUD=x","BRLCNY=x","BRLCAD=x","BRLCHF=x","BRLCZK=x","BRLDKK=x","BRLEUR=x","BRLGBP=x","BRLHKD=x","BRLIDR=x","BRLINR=x","BRLJPY=x","BRLKRW=x","BRLMXN=x","BRLMYR=x","BRLNZD=x","BRLPHP=x","BRLSEK=x","BRLSGD=x","BRLTWD=x",
					"BRLZAR=x","CADUSD=x","CADAUD=x","CADBRL=x","CADCNY=x","CADCHF=x","CADCZK=x","CADDKK=x","CADEUR=x","CADGBP=x","CADHKD=x","CADIDR=x","CADINR=x","CADJPY=x","CADKRW=x","CADMXN=x","CADMYR=x","CADNZD=x","CADPHP=x","CADSEK=x","CADSGD=x","CADTWD=x",
					"CADZAR=x","CHFUSD=x","CHFAUD=x","CHFBRL=x","CHFCAD=x","CHFCNY=x","CHFCZK=x","CHFDKK=x","CHFEUR=x","CHFGBP=x","CHFHKD=x","CHFIDR=x","CHFINR=x","CHFJPY=x","CHFKRW=x","CHFMXN=x","CHFMYR=x","CHFNZD=x","CHFPHP=x","CHFSEK=x","CHFSGD=x","CHFTWD=x","CHFZAR=x","CZKUSD=x","CZKAUD=x","CZKBRL=x","CZKCAD=x","CZKCHF=x","CZKCNY=x","CZKDKK=x","CZKEUR=x","CZKGBP=x","CZKHKD=x","CZKIDR=x","CZKINR=x","CZKJPY=x","CZKKRW=x","CZKMXN=x","CZKMYR=x","CZKNZD=x","CZKPHP=x","CZKSEK=x","CZKSGD=x","CZKTWD=x","CZKZAR=x",
					"DKKUSD=x","DKKAUD=x","DKKBRL=x","DKKCAD=x","DKKCHF=x","DKKCZK=x","DKKCNY=x","DKKEUR=x","DKKGBP=x","DKKHKD=x","DKKIDR=x","DKKINR=x","DKKJPY=x","DKKKRW=x","DKKMXN=x","DKKMYR=x","DKKNZD=x","DKKPHP=x","DKKSEK=x","DKKSGD=x","DKKTWD=x","DKKZAR=x","EURUSD=x","EURAUD=x","EURBRL=x","EURCAD=x","EURCHF=x","EURCZK=x","EURDKK=x","EURCNY=x","EURGBP=x","EURHKD=x","EURIDR=x","EURINR=x","EURJPY=x","EURKRW=x","EURMXN=x","EURMYR=x","EURNZD=x","EURPHP=x","EURSEK=x","EURSGD=x","EURTWD=x","EURZAR=x",
					"GBPUSD=x","GBPAUD=x","GBPBRL=x","GBPCAD=x","GBPCHF=x","GBPCZK=x","GBPDKK=x","GBPEUR=x","GBPCNY=x","GBPHKD=x","GBPIDR=x","GBPINR=x","GBPJPY=x","GBPKRW=x","GBPMXN=x","GBPMYR=x","GBPNZD=x","GBPPHP=x","GBPSEK=x","GBPSGD=x","GBPTWD=x","GBPZAR=x","HKDUSD=x","HKDAUD=x","HKDBRL=x","HKDCAD=x","HKDCHF=x","HKDCZK=x","HKDDKK=x","HKDEUR=x","HKDGBP=x","HKDCNY=x","HKDIDR=x","HKDINR=x","HKDJPY=x","HKDKRW=x","HKDMXN=x","HKDMYR=x","HKDNZD=x","HKDPHP=x","HKDSEK=x","HKDSGD=x","HKDTWD=x","HKDZAR=x",
					"IDRUSD=x","IDRAUD=x","IDRBRL=x","IDRCAD=x","IDRCHF=x","IDRCZK=x","IDRDKK=x","IDREUR=x","IDRGBP=x","IDRHKD=x","IDRCNY=x","IDRINR=x","IDRJPY=x","IDRKRW=x","IDRMXN=x","IDRMYR=x","IDRNZD=x","IDRPHP=x","IDRSEK=x","IDRSGD=x","IDRTWD=x","IDRZAR=x","INRUSD=x","INRAUD=x","INRBRL=x","INRCAD=x","INRCHF=x","INRCZK=x","INRDKK=x","INREUR=x","INRGBP=x","INRHKD=x","INRIDR=x","INRCNY=x","INRJPY=x","INRKRW=x","INRMXN=x","INRMYR=x","INRNZD=x","INRPHP=x","INRSEK=x","INRSGD=x","INRTWD=x","INRZAR=x",
					"JPYUSD=x","JPYAUD=x","JPYBRL=x","JPYCAD=x","JPYCHF=x","JPYCZK=x","JPYDKK=x","JPYEUR=x","JPYGBP=x","JPYHKD=x","JPYIDR=x","JPYINR=x","JPYCNY=x","JPYKRW=x","JPYMXN=x","JPYMYR=x","JPYNZD=x","JPYPHP=x","JPYSEK=x","JPYSGD=x","JPYTWD=x","JPYZAR=x","KRWUSD=x","KRWAUD=x","KRWBRL=x","KRWCAD=x","KRWCHF=x","KRWCZK=x","KRWDKK=x","KRWEUR=x","KRWGBP=x","KRWHKD=x","KRWIDR=x","KRWINR=x","KRWJPY=x","KRWCNY=x","KRWMXN=x","KRWMYR=x","KRWNZD=x","KRWPHP=x","KRWSEK=x","KRWSGD=x","KRWTWD=x","KRWZAR=x",
					"MXNUSD=x","MXNAUD=x","MXNBRL=x","MXNCAD=x","MXNCHF=x","MXNCZK=x","MXNDKK=x","MXNEUR=x","MXNGBP=x","MXNHKD=x","MXNIDR=x","MXNINR=x","MXNJPY=x","MXNKRW=x","MXNCNY=x","MXNMYR=x","MXNNZD=x","MXNPHP=x","MXNSEK=x","MXNSGD=x","MXNTWD=x","MXNZAR=x","MYRUSD=x","MYRAUD=x","MYRBRL=x","MYRCAD=x","MYRCHF=x","MYRCZK=x","MYRDKK=x","MYREUR=x","MYRGBP=x","MYRHKD=x","MYRIDR=x","MYRINR=x","MYRJPY=x","MYRKRW=x","MYRMXN=x","MYRCNY=x","MYRNZD=x","MYRPHP=x","MYRSEK=x","MYRSGD=x","MYRTWD=x","MYRZAR=x",
					"NZDUSD=x","NZDAUD=x","NZDBRL=x","NZDCAD=x","NZDCHF=x","NZDCZK=x","NZDDKK=x","NZDEUR=x","NZDGBP=x","NZDHKD=x","NZDIDR=x","NZDINR=x","NZDJPY=x","NZDKRW=x","NZDMXN=x","NZDMYR=x","NZDCNY=x","NZDPHP=x","NZDSEK=x","NZDSGD=x","NZDTWD=x","NZDZAR=x","PHPUSD=x","PHPAUD=x","PHPBRL=x","PHPCAD=x","PHPCHF=x","PHPCZK=x","PHPDKK=x","PHPEUR=x","PHPGBP=x","PHPHKD=x","PHPIDR=x","PHPINR=x","PHPJPY=x","PHPKRW=x","PHPMXN=x","PHPMYR=x","PHPNZD=x","PHPCNY=x","PHPSEK=x","PHPSGD=x","PHPTWD=x","PHPZAR=x",
					"SEKUSD=x","SEKAUD=x","SEKBRL=x","SEKCAD=x","SEKCHF=x","SEKCZK=x","SEKDKK=x","SEKEUR=x","SEKGBP=x","SEKHKD=x","SEKIDR=x","SEKINR=x","SEKJPY=x","SEKKRW=x","SEKMXN=x","SEKMYR=x","SEKNZD=x","SEKPHP=x","SEKCNY=x","SEKSGD=x","SEKTWD=x","SEKZAR=x","SGDUSD=x","SGDAUD=x","SGDBRL=x","SGDCAD=x","SGDCHF=x","SGDCZK=x","SGDDKK=x","SGDEUR=x","SGDGBP=x","SGDHKD=x","SGDIDR=x","SGDINR=x","SGDJPY=x","SGDKRW=x","SGDMXN=x","SGDMYR=x","SGDNZD=x","SGDPHP=x","SGDSEK=x","SGDCNY=x","SGDTWD=x","SGDZAR=x",
					"TWDUSD=x","TWDAUD=x","TWDBRL=x","TWDCAD=x","TWDCHF=x","TWDCZK=x","TWDDKK=x","TWDEUR=x","TWDGBP=x","TWDHKD=x","TWDIDR=x","TWDINR=x","TWDJPY=x","TWDKRW=x","TWDMXN=x","TWDMYR=x","TWDNZD=x","TWDPHP=x","TWDSEK=x","TWDSGD=x","TWDCNY=x","TWDZAR=x","ZARUSD=x","ZARAUD=x","ZARBRL=x","ZARCAD=x","ZARCHF=x","ZARCZK=x","ZARDKK=x","ZAREUR=x","ZARGBP=x","ZARHKD=x","ZARIDR=x","ZARINR=x","ZARJPY=x","ZARKRW=x","ZARMXN=x","ZARMYR=x","ZARNZD=x","ZARPHP=x","ZARSEK=x","ZARSGD=x","ZARTWD=x","ZARCNY=x"};

}

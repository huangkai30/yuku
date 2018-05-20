package com.lastcompany.haiwaicang.constant;

public interface ErrorCode {
    public static final String SUCCESS_CODE = "200";
    public static final String SHOW_EXCEPTION = "600";
    public static final String REQUEST_ALL_EXCEPTION = "601";
    public static final String PARAMETER_ERROR = "603";
    public static final String VALIDATE_CODE_ERROR = "604";
    public static final String TOKEN_ERROR = "605";
    public static final String TOKEN_INSERT_ERROR = "606";
    public static final String NEED_LOGIN="607";
    public static final String PAYMENT_EXCEPTION = "608";

    public static final String EXCEL_ERROR="800";

    // 会员
    public static final String USER_ID_EMPTY = "12000";
    public static final String USER_ID_ERROR = "12001";
    public static final String USER_NICK_NAME_ERROR = "12002";
    public static final String USER_PASSWORD_ERROR = "12003";
    public static final String USER_REAL_NAME_ERROR = "12004";
    public static final String USER_PHONE_ERROR = "12005";
    public static final String USER_EMAIL_ERROR = "12006";
    public static final String USER_QQ_ERROR = "12007";
    public static final String USER_RECOMMENDER_ERROR = "12008";
    public static final String USER_COUNTRY_ERROR = "12009";
    public static final String USER_ADDRESS_ERROR = "12020";
    public static final String USER_ID_EXISTS = "12010";
    public static final String USER_NAME_EXISTS = "12011";
    public static final String USER_NAME_NOT_EXISTS = "12012";
    public static final String USER_EMAIL_EXISTS = "12013";
    public static final String USER_EMAIL_NOT_EXISTS = "12014";
    public static final String USER_LOGIN_ACCOUNT_EMPTY = "12015";
    public static final String USER_LOGIN_ACCOUNT_ERROR = "12016";
    public static final String USER_INSERT_ERROR = "12017";
    public static final String USER_DELETE_ERROR = "12018";
    public static final String USER_MODIFY_FAILURE = "12019";

    public static final String ABSENTEE_BIDDER_DENY = "12020";
}

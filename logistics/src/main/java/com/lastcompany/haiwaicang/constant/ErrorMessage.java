package com.lastcompany.haiwaicang.constant;

public interface ErrorMessage {


    String SYSTEM_ERROR = "System Error";
    String KAPTCHA_ERROR = "KAPTCHA Error";
    String UPDATE_ERROR = "Update Error";

    public interface Member {
        String FORBIDDEN = "Member is forbidden";
        String EMPTY_NAME = "Name is required";
        String EMPTY_USERNAME = "Username is required";
        String EMPTY_EMAIL = "Email is required";
        String EMPTY_PASSWORD = "Password is required";
        String USERNAME_ERROR = "UserName/Password error";
        String PASSWORD_ERROR = "UserName/Password error";
        String NOT_EXIST = "Username is not exist";
        String RECOMMENDER_NOT_EXIST = "Recommender is not exist";
        String REPEAT_NAME = "Username is duplicated";
        String REPEAT_EMAIL = "EMAIL is duplicated";
        String EMAIL_FORMAT_ERROR = "Email Formation error";
        String MEMBER_MODIFY_FAILURE = "Update error";
        String MEMBER_PASSWROD_SAME = "New password cannot be the same as your current password";
    }

    public interface House {
        String EMPTY_NAME = "Name is required";
        String EMPTY_USERNAME = "User name is required";
        String EMPTY_EMAIL = "Email is required";
        String EMPTY_PASSWORD = "Password is required";
        String USERNAME_PASSWORD_ERROR = "UserName/Password error";
        String PASSWORD_ERROR = "Password error";
        String NOT_EXIST = "House is not exist";
        String REPEAT_NAME = "House is duplicated";
        String HOUSE_SUBACCOUNT_LIMIT10 = "Sub account is limit the maximum 10";
        String NOT_ACTIVE = "House status is not activated";
        String MAINACCOUNT_NOT_ACTIVE = "House main account is not activated";
        String HOUSE_PASSWROD_SAME = "New password cannot be the same as your current password";
    }

    public interface Admin {
        String EMPTY_NAME = "Name is required";
        String EMPTY_USERNAME = "User name is required";
        String EMPTY_EMAIL = "Email is required";
        String EMPTY_PASSWORD = "Password is required";
        String USERNAME_PASSWORD_ERROR = "UserName/Password error";
        String PASSWORD_ERROR = "Password error";
        String NOT_EXIST = "Admin is not exist";
        String REPEAT_NAME = "Admin is duplicated";
        String HOUSE_SUBACCOUNT_LIMIT10 = "Sub account is limit the maximum 10";


    }

    public interface Auction {
        String NOT_EXIST = "Auction is not exist";
        String EMPTY_HOUSEID = "House ID is required";
        String REPEAT_NAME = "Auction Name is duplicated";
        String IMAGE_REQUIRED = "Image is required";
        String ITEM_LESS_THAN_50 = "The item counts must be at least ";
        String ITEM_LESS_THAN_1500 = "The item counts must less than ";
    }

    public interface Bidding {
        String NOT_EXIST = "Bidding is not exist";
        String SAVE_ERROR = "Bidding save error";
    }



    public interface BuyerPremium {
        String NOT_EXIST = "BuyerPremium is not exist";
        String OVER_DEFAULT = "BuyerPremium over size, must less than ";
    }

    public interface AuctionItem {
        String NOT_EXIST = "AuctionItem is not exist";
        String REPEAT_NAME = "Name is duplicated";
        String LOTNUMBER_REQUIRED = "LotNumber is required";
        String LOTNUMBER_DUPLICATED = "LotNumber is duplicated";
        String LOTNUMBER_FORMAT_ERROR = "LotNumber format error";
        String TITLE_REQUIRED = "Title is required";
        String LOWEST_REQUIRED = "LowEst is required";
        String HIGHEST_REQUIRED = "HighEst is required";
        String STARTPRICE_REQUIRED = "StartPrice is required";
        String RESERVEPRICE_REQUIRED = "ReservePrice is required";
        String TYPE_ERROR = "Type error";
        String LOWEST_ERROR = "LowEst error";
        String HIGHEST_ERROR = "HighEst error";
        String STARTPRICE_ERROR = "StartPrice error";
        String RESERVEPRICE_ERROR = "ReservePrice error";
        String LOWEST_MORE_HIGHEST = "Lowest more than highest";
        String IMAGE_TOO_MANY = "Limit up to fifteen figures";
    }

    public interface AuctionItemConsign {
        String NOT_EXIST = "AuctionItem is not exist";
        String REPEAT_NAME = "Name is duplicated";
        String LOTNUMBER_REQUIRED = "LotNumber is required";
        String LOTNUMBER_DUPLICATED = "LotNumber is duplicated";
        String LOTNUMBER_FORMAT_ERROR = "LotNumber format error";
        String TITLE_REQUIRED = "Title is required";
        String LOWEST_REQUIRED = "LowEst is required";
        String HIGHEST_REQUIRED = "HighEst is required";
        String STARTPRICE_REQUIRED = "StartPrice is required";
        String RESERVEPRICE_REQUIRED = "ReservePrice is required";
        String TYPE_ERROR = "Type error";
        String LOWEST_ERROR = "LowEst error";
        String HIGHEST_ERROR = "HighEst error";
        String STARTPRICE_ERROR = "StartPrice error";
        String RESERVEPRICE_ERROR = "ReservePrice error";
        String LOWEST_MORE_HIGHEST = "Lowest more than highest";
        String IMAGE_TOO_MANY = "Limit up to fifteen figures";
    }

    public interface Increment {
        String NOT_EXIST = "Increment is not exist";
        String REPEAT_NAME = "Increment is duplicated";
    }

    public interface Policy {
        String NOT_EXIST = "Policy is not exist";
    }
    public interface AddressBook {
        String NOT_EXIST = "Policy is not exist";
        String REPEAT_NAME = "Address is duplicated";

    }

    public interface PreHouse {
        String NOT_EXIST = "PreHouse is not exist";

    }

    public interface AbsenteeBid {
        String NOT_EXIST = "AbsenteeBid is not exist";
        String SAVE_ERROR = "AbsenteeBid save error";
        String DENY = "Your bid is NOT accepted because your bidder registration of this auction had been denied. You may contact the auction house for more detail regarding to your registration.";
    }
    public interface WonItem {
        String NOT_EXIST = "WonItem is not exist";
        String SAVE_ERROR = "WonItem save error";
    }

    public interface Type {
        String REPEAT_NAME = "TypeNo is duplicated";
    }
    public interface AdIndexImage {
        String REPEAT_NAME = "AdIndexImage is duplicated";
    }
    public interface HouseCostTransaction {
        String PAYMENT_AMOUNT_GREAT_THAN = "The payment amount can not be greater than 2000";
    }


}

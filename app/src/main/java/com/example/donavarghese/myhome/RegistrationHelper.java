package com.example.donavarghese.myhome;

import android.provider.BaseColumns;

public final class RegistrationHelper {

    public static class UserEntry implements BaseColumns {
        public static final String IPADDRESS = "IPADDRESS";
        public static final String PASSWORD = "PASSWORD";
        public static final String PASSWORDHINT = "HINT";
        public static final String TABLE_NAME = "User_Data";
        public static final String USERAGE = "AGE";
        public static final String USEREMAIL = "EMAIL";
        public static final String USERNAME = "USERNAME";
        public static final String USER_FULLNAME = "FULLNAME";
    }

    private RegistrationHelper() {
    }
}

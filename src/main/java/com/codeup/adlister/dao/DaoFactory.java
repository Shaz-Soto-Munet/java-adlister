package com.codeup.adlister.dao;

public class DaoFactory {
    private static Ads adsDao;
    private static Authors authorsDao;
    private static Users usersDao;
    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Authors getAuthorsDao(){
        if (authorsDao == null) {
            authorsDao = new AuthorsDao(config);
        }
        return authorsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao();
        }
        return usersDao;
    }

}

package com.company;

public class Main {

    public static void main(String[] args) {
        String[] columns = new String[] {
                "USERNAME", "PASSWORD", "FIRST_NAME",
                "LAST_NAME","ADDRESS1", "ADDRESS2",
                "FULLNAME", "CREDITCARD", "EXPDATE",
        };

        UserGenerator generator = new UserGenerator(columns);

        int userNum = 100;
        String userDataFilePath =
                "C:\\Users\\timof\\Documents\\VuGen\\Scripts\\Solution1\\WebTours1\\Users.dat";
        generator.createUsersDataFile(userNum, userDataFilePath);

        String webTourUsersPath =
                "D:\\WebTours\\cgi-bin\\users";
        generator.createWebTourUsers(userDataFilePath, webTourUsersPath);
    }
}

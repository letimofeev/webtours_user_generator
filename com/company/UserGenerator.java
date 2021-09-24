package com.company;

import java.io.*;
import java.util.ArrayList;

public class UserGenerator {

    /*
     * File content template with user data in WebTours application
     *
     * File format:
     *
     * password
     * firstName;lastName
     * streetAddress
     * city
     */
    private final String template = "%s\n%s;%s\n%s\n%s\n;";

    /*
     * An array with names of columns of file with user data
     */
    private final String[] columns;

    public UserGenerator(String[] columns) {
        this.columns = columns;
    };

    public void createUsersDataFile(int num, String path) {
        try {
            FileWriter fw = new FileWriter(path, false);

            String columnNamesString = String.join(",", columns);
            fw.write(columnNamesString + "\n");

            for (int i = 0; i < num; ++i) {
                ArrayList<String> userData = new ArrayList<>();

                for (var columnName: columns) {
                    userData.add(columnName.toLowerCase() + i);
                }

                String rowContent = String.join(",", userData);
                fw.write(rowContent + "\n");
            }
            fw.close();
        }

        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void createWebTourUsers(String userDataPath, String webTourUserFolderPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(userDataPath))) {
            String line = reader.readLine();  // skip the first line with the column names

            while (true) {
                line = reader.readLine();

                if (line == null)
                    break;
                else {
                    String[] rowContentArr = line.split(",");
                    String userFileContent = String.format(template,
                            rowContentArr[1],
                            rowContentArr[2],
                            rowContentArr[3],
                            rowContentArr[4],
                            rowContentArr[5]);

                    FileWriter userFile = new FileWriter(
                            webTourUserFolderPath + "\\" + rowContentArr[0], false);
                    userFile.write(userFileContent);
                    userFile.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

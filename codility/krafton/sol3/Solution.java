package com.example.codility.krafton.sol3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Solution {
    public String solution(String S) {
        List<FileInfo> fileInfoList = new ArrayList<>();
        String[] fileDataLines = S.split("\n");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (int i = 0; i < fileDataLines.length; i++) {
            String fileRawData = fileDataLines[i];
            String[] fileDataSplit = fileRawData.split(", ");
            String fileNameOriginal = fileDataSplit[0];
            String cityName = fileDataSplit[1];
            String dateTimeStr = fileDataSplit[2];

            LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, dateFormatter);
            fileInfoList.add(new FileInfo(i, fileNameOriginal, cityName, dateTime));
        }

        Map<String, List<FileInfo>> cityFileMap = new HashMap<>();
        for (FileInfo fileInfo : fileInfoList) {
            cityFileMap.computeIfAbsent(fileInfo.cityName, k -> new ArrayList<>()).add(fileInfo);
        }

        Map<Integer, String> renamedFileMap = new HashMap<>();
        for (Map.Entry<String, List<FileInfo>> cityEntry : cityFileMap.entrySet()) {
            List<FileInfo> cityFileList = cityEntry.getValue();
            cityFileList.sort(Comparator.comparing(file -> file.dateTime));

            int count = 1;
            for (FileInfo file : cityFileList) {
                String extension = file.getFileExtension();
                String newFileName;
                if (cityFileList.size() >= 10) {
                    newFileName = cityEntry.getKey() + String.format("%02d", count) + "." + extension;
                } else {
                    newFileName = cityEntry.getKey() + count + "." + extension;
                }
                renamedFileMap.put(file.originalIdx, newFileName);
                count++;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < fileDataLines.length; i++) {
            stringBuilder.append(renamedFileMap.get(i)).append("\n");
        }

        return stringBuilder.toString().trim();
    }

    private static class FileInfo {
        int originalIdx;
        String fileNameOriginal;
        String cityName;
        LocalDateTime dateTime;

        public FileInfo(int originalIdx, String fileNameOriginal, String cityName, LocalDateTime dateTime) {
            this.originalIdx = originalIdx;
            this.fileNameOriginal = fileNameOriginal;
            this.cityName = cityName;
            this.dateTime = dateTime;
        }

        public String getFileExtension() {
            return this.fileNameOriginal.substring(this.fileNameOriginal.lastIndexOf(".") + 1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String testData = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n"
                + "john.png, London, 2015-06-20 15:13:22\n"
                + "myFriends.png, Warsaw, 2013-09-05 14:07:13\n"
                + "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n"
                + "pisatower.jpg, Paris, 2015-07-22 23:59:59\n"
                + "BOB.jpg, London, 2015-08-05 00:02:03\n"
                + "notredame.png, Paris, 2015-09-01 12:00:00\n"
                + "me.jpg, Warsaw, 2013-09-06 15:40:22\n"
                + "a.png, Warsaw, 2016-02-13 13:33:50\n"
                + "b.jpg, Warsaw, 2016-01-02 15:12:22\n"
                + "c.jpg, Warsaw, 2016-01-02 14:34:30\n"
                + "d.jpg, Warsaw, 2016-01-02 15:15:01\n"
                + "e.png, Warsaw, 2016-01-02 09:49:09\n"
                + "f.png, Warsaw, 2016-01-02 10:55:32\n"
                + "g.jpg, Warsaw, 2016-02-29 22:13:11";

        System.out.println(sol.solution(testData));

    }
}
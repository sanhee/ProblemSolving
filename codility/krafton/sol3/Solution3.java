package com.example.codility.krafton.sol3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

public class Solution3 {
    public String solution(String S) {
        List<FileInfo> fileInfoList = new ArrayList<>();
        String[] fileLine = S.split("\n");

        int idx = 0;
        for (String file : fileLine) {
            String[] f = file.split(", ");

            String extension = f[0].split("\\.")[1];
            String cityName = f[1];
            LocalDateTime dateTime = FileInfo.getDateTime(f[2]);

            fileInfoList.add(new FileInfo(cityName, extension, dateTime, idx));
            idx++;
        }

        Map<String, List<FileInfo>> map = new HashMap<>();

        for (FileInfo fileInfo : fileInfoList) {
            map.computeIfAbsent(fileInfo.cityName, k -> new ArrayList<>()).add(fileInfo);
        }

        Map<Integer, String> map2 = new HashMap<>();

        for (Map.Entry<String, List<FileInfo>> m : map.entrySet()) {
            List<FileInfo> value = m.getValue();
            value.sort(Comparator.comparing(file -> file.dateTime));

            for (int i = 0; i < value.size(); i++) {
                FileInfo fileInfo = value.get(i);
                int len = String.valueOf(value.size()).length();
                String newIdx = String.format("%0"+len+"d", i + 1);
                String newFileName = fileInfo.cityName + newIdx + fileInfo.extension;

                map2.put(fileInfo.originalIndex, newFileName);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i< fileLine.length; i++) {
            sb.append(map2.get(i)).append(System.lineSeparator());
        }




        return sb.toString().trim();
    }


    class FileInfo {
        String cityName;
        String extension;
        LocalDateTime dateTime;
        Integer originalIndex;

        public FileInfo(String c, String e, LocalDateTime d, Integer o) {
            this.cityName = c;
            this.extension = e;
            this.dateTime = d;
            this.originalIndex = o;
        }

        public static LocalDateTime getDateTime(String dateTimeString) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return LocalDateTime.parse(dateTimeString, formatter);
        }
    }


    public static void main(String[] args) {
        Solution3 sol = new Solution3();

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
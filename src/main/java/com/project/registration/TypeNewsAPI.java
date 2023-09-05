package com.project.registration;

public class TypeNewsAPI {
    public static void main(String[] args) {
        String[][] news = NewsApi.getNews();
        if (news != null) {
            for (int i = 0; i < news.length; i++) {
                for (int j = 0; j < news[i].length; j++) {
                    System.out.println(news[i][j]);
                }
            }
        } else {
            System.out.println("Unable to retrieve news.");
        }
    }
}
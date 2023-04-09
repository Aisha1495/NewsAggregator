package org.example;

import okhttp3.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Articles";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";
    private static final String INSERT_SQL = "INSERT INTO Articles (Title, Author, Date, Category, Content) VALUES (?, ?, ?, ?, ?)";

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        Request request = new Request.Builder()
                .url("https://api.nytimes.com/svc/search/v2/articlesearch.json?q=election&api-key=" + System.getenv("API_KEY"))
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

    public static void insertArticle(Article article) {
//        try (Connection conn = DriverManager.getConnection(URL, root, 12345);
//             PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL)) {
//            pstmt.setString(1, article.getTitle());
//            pstmt.setString(2, article.getAuthor());
//            pstmt.setDate(3, article.getDate());
//            pstmt.setString(4, article.getCategory());
//            pstmt.setString(5, article.getContent());
//            pstmt.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
    }

}

package org.example;

import okhttp3.*;

import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Articles";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";
    private static final String INSERT_SQL = "INSERT INTO Articles (Title, Author, Date, Category, Content) VALUES (?, ?, ?, ?, ?)";

    private static final String SELECT_BY_KEYWORD = "SELECT * FROM Articles WHERE Title LIKE ? OR Content LIKE ?";

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



    public static List<Article> searchByKeyword(String keyword) {
        List<Article> articles = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_KEYWORD)) {
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Article article = new Article(
                        rs.getString("Title"),
                        rs.getString("Author"),
                        rs.getDate("Date"),
                        rs.getString("Category"),
                        rs.getString("Content")
                );
                articles.add(article);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return articles;
    }

    }



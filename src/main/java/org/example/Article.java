package org.example;

import java.util.Date;

public class Article {
    private String title;
    private String author;
    private Date date;
    private String category;
    private String content;

    public Article(String title, String author, Date date, String category, String content) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.category = category;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                ", category='" + category + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}


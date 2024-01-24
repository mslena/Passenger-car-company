package org.example.Classes;

public class Post {
    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public int getId_category_post() {
        return id_category_post;
    }

    public void setId_category_post(int id_category_post) {
        this.id_category_post = id_category_post;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    int id_post, id_category_post;
String name;
}

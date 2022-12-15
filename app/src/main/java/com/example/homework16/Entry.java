package com.example.homework16;

import android.media.Image;

import androidx.appcompat.app.AppCompatActivity;

public class Entry{
    private boolean liked=false;
    private String author;
    private int authorArtid;
    private int memeid;
    private int likes;
    private int comments;
    private int views;
    Entry(String author,int authorArtid,int memeid){
        likes=0;
        comments=0;
        views=0;
        this.author=author;
        this.authorArtid=authorArtid;
        this.memeid=memeid;
    }

    public int getMemeid() {
        return memeid;
    }

    public int getAuthorArtid() {
        return authorArtid;
    }

    public String getAuthor() {
        return author;
    }

    public void setLiked() {
        liked = !liked;
    }
    public boolean getLiked(){
        return liked;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getLikes() {
        return likes;
    }
}

package br.com.oliveiraemanoel.cats4all.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("datetime")
    private int datetime;
    @SerializedName("cover")
    private String cover;
    @SerializedName("account_url")
    private String account_url;
    @SerializedName("account_id")
    private int account_id;
    @SerializedName("privacy")

    private String privacy;
    @SerializedName("layout")
    private String layout;
    @SerializedName("views")
    private int views;
    @SerializedName("link")
    private String link;
    @SerializedName("ups")
    private int ups;
    @SerializedName("downs")
    private int downs;
    @SerializedName("points")
    private int points;
    @SerializedName("score")
    private int score;
    @SerializedName("is_album")
    private boolean is_album;
    @SerializedName("vote")
    private String vote;
    @SerializedName("comment_count")
    private int comment_count;
    @SerializedName("images_count")
    private int images_count;
    @SerializedName("images")
    private List<Images> images;


    public void Data(String id, String title, String description, int datetime, String cover, String account_url, int account_id, String privacy, String layout, int views, String link, int ups, int downs, int points, int score, boolean is_album, String vote, int comment_count, int images_count, List<Images> images) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.datetime = datetime;
        this.cover = cover;
        this.account_url = account_url;
        this.account_id = account_id;
        this.privacy = privacy;
        this.layout = layout;
        this.views = views;
        this.link = link;
        this.ups = ups;
        this.downs = downs;
        this.points = points;
        this.score = score;
        this.is_album = is_album;
        this.vote = vote;
        this.comment_count = comment_count;
        this.images_count = images_count;
        this.images = images;
    }

    public List<Images> getImages(){
        return this.images;
    }

}

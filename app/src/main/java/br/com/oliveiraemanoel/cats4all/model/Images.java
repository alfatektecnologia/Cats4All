package br.com.oliveiraemanoel.cats4all.model;

public class Images {
    private String id;

    private String title;

    private String description;

    private int datetime;

    private String type;

    private boolean animated;

    private int width;

    private int height;

    private int size;

    private int views;

    private float bandwidth;

    private String link;

    public Images(Images images) {
    }

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDatetime(int datetime){
        this.datetime = datetime;
    }
    public int getDatetime(){
        return this.datetime;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setAnimated(boolean animated){
        this.animated = animated;
    }
    public boolean getAnimated(){
        return this.animated;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public int getWidth(){
        return this.width;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public int getHeight(){
        return this.height;
    }
    public void setSize(int size){
        this.size = size;
    }
    public int getSize(){
        return this.size;
    }
    public void setViews(int views){
        this.views = views;
    }
    public int getViews(){
        return this.views;
    }
    public void setBandwidth(float bandwidth){
        this.bandwidth = bandwidth;
    }
    public float getBandwidth(){
        return this.bandwidth;
    }
    public void setLink(String link){
        this.link = link;
    }
    public String getLink(){
        return this.link;
    }

    public Images(String id, String title, String description, int datetime, String type, boolean animated, int width, int height, int size, int views, float bandwidth, String link) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.datetime = datetime;
        this.type = type;
        this.animated = animated;
        this.width = width;
        this.height = height;
        this.size = size;
        this.views = views;
        this.bandwidth = bandwidth;
        this.link = link;
    }

    public Images() {
    }
}

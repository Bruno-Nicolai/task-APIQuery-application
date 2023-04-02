package bruno.nicolai.app_api_query.models;

public class Photo {

    private Album album;
    private int id;
    private String title, url, thumbnailUrl;

    public Photo(Album album, int id, String title, String url, String thumbnailUrl) {
        this.album = album;
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

}

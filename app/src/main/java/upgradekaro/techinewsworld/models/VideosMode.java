package upgradekaro.techinewsworld.models;

/**
 * Created by cred-user-6 on 1/4/17.
 */

public class VideosMode {
    String name;
    String videoid;

    public VideosMode(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoid() {
        return videoid;
    }

    public void setVideoid(String videoid) {
        this.videoid = videoid;
    }

    public VideosMode(String name, String videoid) {
        this.name = name;
        this.videoid = videoid;
    }
}

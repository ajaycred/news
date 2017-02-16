package upgradekaro.techinewsworld.models;

/**
 * Created by cred-user-6 on 15/2/17.
 */

public class Sites {
    String link;
    String name;
    String image;

    public Sites() {
    }

    public String getLink() {

        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Sites(String link, String name, String image) {
        this.link = link;
        this.name = name;
        this.image = image;
    }
}

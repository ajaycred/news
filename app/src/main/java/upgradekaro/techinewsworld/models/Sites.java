package upgradekaro.techinewsworld.models;

/**
 * Created by cred-user-6 on 15/2/17.
 */

public class Sites {
    String link;
    String name;
    String image;
    String color;


    public Sites() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public Sites(String link, String name, String image,String color) {
        this.link = link;
        this.name = name;
        this.image = image;
        this.color=color;
   }
}

package upgradekaro.techinewsworld.models;

/**
 * Created by cred-user-6 on 26/12/16.
 */

public class Favmodel {
    String favlink;
    String favlinktitle;

    public Favmodel() {

    }

    public Favmodel(String favlink, String favlinktitle) {

        this.favlink = favlink;
        this.favlinktitle = favlinktitle;
    }

    public String getFavlinktitle() {
        return favlinktitle;
    }

    public void setFavlinktitle(String favlinktitle) {
        this.favlinktitle = favlinktitle;
    }

    public String getFavlink() {
        return favlink;
    }

    public void setFavlink(String favlink) {
        this.favlink = favlink;
    }
}

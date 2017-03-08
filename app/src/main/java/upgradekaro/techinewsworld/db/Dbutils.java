package upgradekaro.techinewsworld.db;

/**
 * Created by cred-user-6 on 8/3/17.
 */

public class Dbutils {
    public static final String Db_id="id";
    public static final String Db_table_fav="favouratetable";
    public static final String Db_fav_link="favouratelink";
    public static final String Db_fav_link_name="linkname";

    //common texts

    public static final String create_table_text=" CREATE TABLE IF NOT EXISTS ";
    public static final String int_and_auto="INTEGER PRIMARY KEY AUTOINCREMENT ,";


    //create table queries
    public static String Create_Table_Favourates=create_table_text+" "+Db_table_fav+" ( "+Db_id +" "+int_and_auto+""+" "+Db_fav_link_name+" TEXT ,"+Db_fav_link+" TEXT )";

}

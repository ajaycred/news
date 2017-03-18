package upgradekaro.techinewsworld.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cred-user-6 on 8/3/17.
 */

public class Dbhelper extends SQLiteOpenHelper {
    private static String Dbname="technews.db";
    private static int Dbversion=1;
    private SQLiteDatabase database;
    public Dbhelper(Context context) {
        super(context,Dbname,null,Dbversion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Dbutils.Create_Table_Favourates);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +Dbutils.Create_Table_Favourates);
    }

    public Boolean AddFavlinkData(String link,String linkname){
        openDatabase();
        ContentValues cv=new ContentValues();
        cv.put(""+Dbutils.Db_fav_link,link);
        cv.put(""+Dbutils.Db_fav_link_name,linkname);
        database.insert(Dbutils.Db_table_fav,null,cv);
        database.close();
        return true;
    }


    public SQLiteDatabase openDatabase() {
        database = this.getWritableDatabase();
        return database;
    }
    public Cursor getDatafromfavTable() {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM "+Dbutils.Db_table_fav, null);
        return cursor;
    }

    public void Deleterowfromfavtable(String favlinktitle) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(""+Dbutils.Db_table_fav, Dbutils.Db_fav_link_name+"=?", new String[]{favlinktitle});
    }
}

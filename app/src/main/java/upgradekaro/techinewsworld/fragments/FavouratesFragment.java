package upgradekaro.techinewsworld.fragments;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

import upgradekaro.techinewsworld.R;
import upgradekaro.techinewsworld.adapter.Favouritelinkadapter;
import upgradekaro.techinewsworld.db.Dbhelper;
import upgradekaro.techinewsworld.db.Dbutils;
import upgradekaro.techinewsworld.models.Favmodel;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavouratesFragment extends Fragment {
    ListView fragFavlistview;
    Dbhelper dbhelper;
    AdView adViewfav;
    Favmodel favmodel;
    Favouritelinkadapter favouritelinkadapter;
    ArrayList links = new ArrayList();
    ArrayList<Favmodel> arrayList = new ArrayList<>();
    String favlinktitle;
    String favlink;

    public FavouratesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        arrayList.clear();
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_favourates, container, false);
        fragFavlistview = (ListView) v.findViewById(R.id.fragfav_lstview_links);
          //adViewfav= (AdView) v.findViewById(R.id.adview_fav);
         AdRequest adRequestfav=new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
       // adViewfav.loadAd(adRequestfav);
        favouritelinkadapter = new Favouritelinkadapter(arrayList, getContext());
        fragFavlistview.setAdapter(favouritelinkadapter);
        favouritelinkadapter.notifyDataSetChanged();
        dbhelper = new Dbhelper(getContext());
        Cursor c = dbhelper.getDatafromfavTable();
        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    favlinktitle = c.getString(c.getColumnIndex(""+ Dbutils.Db_fav_link_name));
                    favlink = c.getString(c.getColumnIndex(""+Dbutils.Db_fav_link));
                    favmodel = new Favmodel(favlink, favlinktitle);
                    links.add(favlink);
                    arrayList.add(favmodel);
                } while (c.moveToNext());
            }
        }
        return v;
    }

}

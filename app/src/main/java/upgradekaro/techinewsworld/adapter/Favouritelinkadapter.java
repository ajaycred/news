package upgradekaro.techinewsworld.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import upgradekaro.techinewsworld.R;
import upgradekaro.techinewsworld.db.Dbhelper;
import upgradekaro.techinewsworld.fragments.FavouratesFragment;
import upgradekaro.techinewsworld.fragments.WebviewFragment;
import upgradekaro.techinewsworld.models.Favmodel;
import upgradekaro.techinewsworld.utils.NetworkChecker;

/**
 * Created by cred-user-6 on 26/12/16.
 */

public class Favouritelinkadapter extends BaseAdapter {
    ArrayList<Favmodel> arrayList;
    String applink="https://play.google.com/store/apps/details?id=upgradekaro.personalgsmarenauoapp";
    Context context;
    Dbhelper dbhelper;

    public Favouritelinkadapter(ArrayList<Favmodel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.favlinkitem, null);
        final TextView tvlinktitle = (TextView) convertView.findViewById(R.id.favitem_tv_title);
        ImageView sharefavlink = (ImageView) convertView.findViewById(R.id.favitem_iv_share);
        ImageView openFavlink = (ImageView) convertView.findViewById(R.id.favitem_iv_open);
        ImageView deletefavlink = (ImageView) convertView.findViewById(R.id.favitem_iv_delete);
        final Favmodel favmodel = arrayList.get(position);
        tvlinktitle.setText("" + favmodel.getFavlinktitle());
        sharefavlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Intent shareintent = new Intent(Intent.ACTION_SEND);
                shareintent.setType("text/plain");
                shareintent.putExtra(Intent.EXTRA_SUBJECT, "");
                shareintent.putExtra(Intent.EXTRA_TEXT, ""+favmodel.getFavlink()+"\n Download app for more info \n"+applink);
                context.startActivities(new Intent[]{Intent.createChooser(shareintent, "share via")});


            }
        });
        openFavlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NetworkChecker.isInternetAvailable(context)) {
                    WebviewFragment webFragment = new WebviewFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("clickeditem", "" + favmodel.getFavlink());
                    webFragment.setArguments(bundle);
                    FragmentTransaction ft = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.activitymain_container,webFragment);
                    ft.addToBackStack(null);
                    ft.commit();
                } else {
                    Toast.makeText(context, "Switch On Your Internet", Toast.LENGTH_SHORT).show();
                }
            }
        });
        deletefavlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbhelper = new Dbhelper(context);
                dbhelper.Deleterowfromfavtable("" + favmodel.getFavlinktitle());
                FavouratesFragment favouratesFragment = new FavouratesFragment();
                FragmentTransaction ft = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.activitymain_container, favouratesFragment);
                ft.commit();

            }
        });
        return convertView;
    }

}

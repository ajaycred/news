package upgradekaro.techinewsworld.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import upgradekaro.techinewsworld.R;
import upgradekaro.techinewsworld.fragments.WebviewFragment;
import upgradekaro.techinewsworld.models.Sites;

/**
 * Created by cred-user-6 on 16/2/17.
 */

public class Listada extends BaseAdapter {
    ArrayList<Sites> arrayList;
    Context context;

    public Listada(ArrayList<Sites> arrayList, Context context) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.papertile, null);
        initcomponents(convertView, position);
        return convertView;
    }

    private void initcomponents(View convertView, int position) {
        LinearLayout roundlay = (LinearLayout) convertView.findViewById(R.id.lnr_backgroud);
        RelativeLayout relayroundlay = (RelativeLayout) convertView.findViewById(R.id.rel_paper_back);
        CardView itemcard = (CardView) convertView.findViewById(R.id.card_background);
        ImageView logo = (ImageView) convertView.findViewById(R.id.paper_logo);
        TextView newsname = (TextView) convertView.findViewById(R.id.tv_newsname);
        final Sites sites = arrayList.get(position);
        roundlay.setBackgroundColor(Color.parseColor("" + sites.getColor()));
        relayroundlay.setBackgroundColor(Color.parseColor("" + sites.getColor()));
        Picasso.with(context).load("" + sites.getImage()).into(logo);
        newsname.setText("" + sites.getName());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "" + sites.getLink(), Toast.LENGTH_SHORT).show();
                WebviewFragment webviewFragment=new WebviewFragment();
                FragmentTransaction fragmentTransaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
                Bundle clickeditem=new Bundle();
                clickeditem.putString("clickeditem",""+sites.getLink());
                webviewFragment.setArguments(clickeditem);
                fragmentTransaction.replace(R.id.activity_main,webviewFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }

}

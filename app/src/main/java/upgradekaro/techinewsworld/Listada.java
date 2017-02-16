package upgradekaro.techinewsworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

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
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.papertile,null);
        TextView  newsname= (TextView) convertView.findViewById(R.id.tv_newsname);
        Sites sites=arrayList.get(position);
        newsname.setText(""+sites.getName());
        return convertView;
    }
}

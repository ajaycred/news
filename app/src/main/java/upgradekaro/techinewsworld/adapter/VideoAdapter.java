package upgradekaro.techinewsworld.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.ArrayList;

import upgradekaro.techinewsworld.R;
import upgradekaro.techinewsworld.models.VideosMode;

/**
 * Created by cred-user-6 on 1/4/17.
 */

public class VideoAdapter extends BaseAdapter {
    Context context;
    ArrayList<VideosMode> arrayList;
    String[] names={"one","two","three","Four","five","six","seven","Eight","nine","eleven","twelve"};

    public VideoAdapter(Context context, ArrayList<VideosMode> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
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
        convertView = inflater.inflate(R.layout.videopreviewcard, null);
        TextView texttitle= (TextView) convertView.findViewById(R.id.videoprcard_txttitle);
        final YouTubeThumbnailView tubeThumbnailView= (YouTubeThumbnailView) convertView.findViewById(R.id.videoprcard_ytbtumbnail);
        VideosMode videosMode=arrayList.get(position);
        texttitle.setText(videosMode.getVideoid()+"\n"+videosMode.getName());
        return convertView;
    }

}

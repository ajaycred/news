package upgradekaro.techinewsworld.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import upgradekaro.techinewsworld.R;
import upgradekaro.techinewsworld.models.Sites;

/**
 * Created by cred-user-6 on 19/12/16.
 */

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.NewsViewHolder>
{
    Context context;
    View view;
  //  Sites sites;

    public RecAdapter(Context context, ArrayList<Sites> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    ArrayList<Sites> arrayList;
    String[] news={"times of india ","Decan Chronical","The hindu","India Today","Hans India ","Sport Start","times of india ","Decan Chronical","The hindu","India Today","Hans India ","Sport Start","times of india ","Decan Chronical","The hindu","India Today","Hans India ","Sport Start"};
    String[] colors={"#424c59","#8c4d79","#b19d19","#3a3568","#8b3a3a","#4b330e","#4b330e","#395880","395880","#8c4d79","#b19d19","#3a3568","#8b3a3a","#4b330e","#4b330e","#395880","#424c59","#8c4d79"};
   // int[] paperlogo={R.mipmap.tv,R.mipmap.chronic,R.mipmap.hindu,R.mipmap.chronic,R.mipmap.indiatoday,R.mipmap.ss,R.mipmap.tv,R.mipmap.hindu,R.mipmap.hindu,R.mipmap.chronic,R.mipmap.indiatoday,R.mipmap.ss,R.mipmap.tv,R.mipmap.chronic,R.mipmap.hindu,R.mipmap.hindu,R.mipmap.indiatoday,R.mipmap.ss};


    @Override
    public RecAdapter.NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view=LayoutInflater.from(parent.getContext()).inflate(R.layout.papertile,parent,false);
        NewsViewHolder newsholder=new NewsViewHolder(view);
        return newsholder;
    }

    @Override
    public void onBindViewHolder(final RecAdapter.NewsViewHolder holder, final int position) {
        holder.sites=arrayList.get(position);
    //    holder.tvnews.setText(news[position]);
       holder.tvnews.setText(""+holder.sites.getName());
     //   Log.d("ssc",""+arrayList.get(position).getName());
        holder.relpaperback.setBackgroundColor(Color.parseColor(colors[position]));
        holder.layout.setBackgroundColor(Color.parseColor(colors[position]));
       // holder.logo.setImageResource(paperlogo[position]);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"position : "+position,Toast.LENGTH_LONG).show();
              //  Sites sites=arrayList.get(position);
             //   Toast.makeText(v.getContext(),""+sites.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        //return arrayList.size();
        return news.length;
    }

    public class NewsViewHolder  extends RecyclerView.ViewHolder{
        TextView tvnews;
        Sites sites;
        RelativeLayout relpaperback;
        LinearLayout layout;
        ImageView logo;
        CardView cardView;
        public NewsViewHolder(View itemView) {
            super(itemView);
            relpaperback= (RelativeLayout) itemView.findViewById(R.id.rel_paper_back);
            layout= (LinearLayout) itemView.findViewById(R.id.lnr_backgroud);
            tvnews= (TextView) itemView.findViewById(R.id.tv_newsname);
            logo= (ImageView) itemView.findViewById(R.id.paper_logo);
            cardView= (CardView) itemView.findViewById(R.id.card_background);

        }
    }
}
package upgradekaro.techinewsworld.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import upgradekaro.techinewsworld.R;
import upgradekaro.techinewsworld.adapter.VideoAdapter;
import upgradekaro.techinewsworld.models.VideosMode;

/**
 * A simple {@link Fragment} subclass.
 */
public class Videos extends Fragment {
    GridView maingrid;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    ArrayList<VideosMode> arrayList=new ArrayList<>();
    public Videos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_videos, container, false);
        Initcomponents(v);
        FireBaseProcessforVideo(reference);
        return v;
    }

    private void Initcomponents(View v) {
        maingrid= (GridView) v.findViewById(R.id.main_grid);
        firebaseDatabase.getInstance();
        reference=firebaseDatabase.getInstance().getReferenceFromUrl("https://news-paper-36b6a.firebaseio.com/technewsvideos");
    }

    private void FireBaseProcessforVideo(DatabaseReference databaseReference){
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("checksnap",""+dataSnapshot);
                for(DataSnapshot objects:dataSnapshot.getChildren()){
                    VideosMode vid=objects.getValue(VideosMode.class);
                    arrayList.add(vid);
                    Log.d("sites",vid.getName()+"\n"+vid.getVideoid());
                    SettingAdapter();
                  //  pgdailogloading.dismiss();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void SettingAdapter() {
        VideoAdapter voad=new VideoAdapter(getContext(),arrayList);
        maingrid.setAdapter(voad);
    }

}

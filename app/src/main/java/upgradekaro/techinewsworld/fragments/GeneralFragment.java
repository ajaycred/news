package upgradekaro.techinewsworld.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import upgradekaro.techinewsworld.Listada;
import upgradekaro.techinewsworld.R;
import upgradekaro.techinewsworld.models.Sites;


/**
 * A simple {@link Fragment} subclass.
 */
public class GeneralFragment extends Fragment {

    FirebaseDatabase firebaseDatabase;
    ProgressDialog pgdailogloading;
    ListView listView;
    ArrayList<Sites> arrayList=new ArrayList<>();
    DatabaseReference reference;
    public GeneralFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_general, container, false);
        initcomponents(view);
        Traillistners(reference);
        SettingAdapter();
        return view;
    }

    private void initcomponents(View view) {
        firebaseDatabase.getInstance();
        reference=firebaseDatabase.getInstance().getReference("technewslinks");
        listView= (ListView) view.findViewById(R.id.listy);
        pgdailogloading=new ProgressDialog(getContext());
        pgdailogloading.setMessage("Just a snap hold on...");
        pgdailogloading.show();
    }
    private void Traillistners(DatabaseReference databaseReference){
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("checksnap",""+dataSnapshot);
                for(DataSnapshot objects:dataSnapshot.getChildren()){
                    Sites sites=objects.getValue(Sites.class);
                    arrayList.add(sites);
                    Log.d("sites",sites.getName()+"\n"+sites.getLink());
                    SettingAdapter();
                    pgdailogloading.dismiss();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void SettingAdapter(){
        Listada adapter=new Listada(arrayList,getContext());
        listView.setAdapter(adapter);
    }

}

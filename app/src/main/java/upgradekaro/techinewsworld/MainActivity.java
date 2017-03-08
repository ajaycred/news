package upgradekaro.techinewsworld;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import upgradekaro.techinewsworld.fragments.GeneralFragment;
import upgradekaro.techinewsworld.models.Sites;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    ProgressDialog pgdailogloading;
    ListView listView;
    ArrayList<Sites> arrayList=new ArrayList<>();
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseDatabase.getInstance();
        GeneralFragment fragment=new GeneralFragment();
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activitymain_container,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
     //   reference=firebaseDatabase.getInstance().getReference("technewslinks");
    //    initcomponents();
  //      SettingAdapter();
       // FireBaseProcess(reference);
  //      Traillistners(reference);
    }

    private void initcomponents() {
        listView= (ListView) findViewById(R.id.listy);
        pgdailogloading=new ProgressDialog(MainActivity.this);
        pgdailogloading.setMessage("Just a snap hold on...");
        pgdailogloading.show();
        LinearLayoutManager layout=new LinearLayoutManager(MainActivity.this);
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
    private void FireBaseProcess(DatabaseReference databaseReference){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot objects:dataSnapshot.getChildren()){
                  Sites sites=objects.getValue(Sites.class);
                    arrayList.add(sites);
                    Log.d("sites",sites.getName()+"\n"+sites.getLink());
                    SettingAdapter();
                }

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
      //  SettingAdapter();
    }

    private void SettingAdapter(){
        Listada adapter=new Listada(arrayList,MainActivity.this);
        listView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}

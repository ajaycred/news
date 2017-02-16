package upgradekaro.techinewsworld;

import android.os.Bundle;
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

import upgradekaro.techinewsworld.models.Sites;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    ListView listView;
    ArrayList<Sites> arrayList=new ArrayList<>();
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseDatabase.getInstance();
        reference=firebaseDatabase.getInstance().getReference("technewslinks");
        initcomponents();
        FireBaseProcess(reference);
    }

    private void initcomponents() {
        listView= (ListView) findViewById(R.id.listy);
        LinearLayoutManager layout=new LinearLayoutManager(MainActivity.this);
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
        SettingAdapter();
    }

    private void SettingAdapter(){
        Listada adapter=new Listada(arrayList,MainActivity.this);
        listView.setAdapter(adapter);
    }
}

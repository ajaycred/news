package upgradekaro.techinewsworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import upgradekaro.techinewsworld.models.Sites;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseDatabase.getInstance();
        reference=firebaseDatabase.getInstance().getReference("technewslinks");
        initcomponents();
        FireBaseProcess(reference);
        SettingAdapter();
    }

    private void initcomponents() {
        recyclerView= (RecyclerView) findViewById(R.id.recyler);
        LinearLayoutManager layout=new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layout);
    }
    private void FireBaseProcess(DatabaseReference databaseReference){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot objects:dataSnapshot.getChildren()){
                    Log.e("Datasnap",""+objects);
                    Sites sites=objects.getValue(Sites.class);
                    Log.d("sites",""+sites.getLink());
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void SettingAdapter(){
        RecAdapter adapter=new RecAdapter(MainActivity.this);
        recyclerView.setAdapter(adapter);
    }
}

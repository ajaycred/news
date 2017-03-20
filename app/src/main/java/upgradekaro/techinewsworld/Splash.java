package upgradekaro.techinewsworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Splash extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Splashe splash=new Splashe();
        firebaseDatabase.getInstance();
        reference=firebaseDatabase.getInstance().getReference("technewslinks");
        splash.start();
    }
    class Splashe extends Thread{
        public void run(){
            try {
                Thread.sleep(1000);
                Intent inte=new Intent(Splash.this,MainActivity.class);
                startActivity(inte);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finish();
        }
    }
}

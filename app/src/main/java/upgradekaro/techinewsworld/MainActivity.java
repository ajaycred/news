package upgradekaro.techinewsworld;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.FirebaseDatabase;

import upgradekaro.techinewsworld.fragments.GeneralFragment;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DrawerLayout sidemenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseDatabase.getInstance();
        init();
        FragmentProcess();
    }

    private void init() {
        sidemenu= (DrawerLayout) findViewById(R.id.drawer);
    }

    public void FragmentProcess() {
        GeneralFragment fragment = new GeneralFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activitymain_container, fragment);
     //   fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
      //  finish();
        super.onBackPressed();
    }

}

package upgradekaro.techinewsworld;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

import upgradekaro.techinewsworld.adapter.PageviewAdapter;
import upgradekaro.techinewsworld.fragments.FavouratesFragment;
import upgradekaro.techinewsworld.fragments.Feeds;
import upgradekaro.techinewsworld.fragments.GeneralFragment;
import upgradekaro.techinewsworld.fragments.Videos;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FirebaseDatabase firebaseDatabase;
    DrawerLayout sidemenu;
    NavigationView navigationview;
    //toolbarbuttons
    ImageView toolbar_menuopen;
    //side menu elements
    ImageView sidemenuivmenuclose;
    TextView sidemenuweb,sidemenunews,sidemenuvideos,sidemenufavour,sidemenucategory;

    //view pager and tablayout
    TabLayout mainlaytablayout;
    ViewPager mainlayviewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseDatabase.getInstance();
        init();
        clicks();
        Tablayoutsetup();
   //     GeneralFragment fragment = new GeneralFragment();
      //  FragmentProcess(fragment,false);
    }

    private void init() {
        sidemenu= (DrawerLayout) findViewById(R.id.drawer);
        toolbar_menuopen= (ImageView) findViewById(R.id.maintool_imgmenu);
        navigationview= (NavigationView) findViewById(R.id.navigation_view);
        sidemenuivmenuclose= (ImageView) findViewById(R.id.sidemenu_ivclosemenu);
        sidemenuweb= (TextView) findViewById(R.id.sidemenu_tvmenuweb);
        sidemenunews= (TextView) findViewById(R.id.sidemenu_tvmenunews);
        sidemenuvideos= (TextView) findViewById(R.id.sidemenu_tvmenuvideos);
        sidemenufavour= (TextView) findViewById(R.id.sidemenu_tvmenufavourite);
        sidemenucategory= (TextView) findViewById(R.id.sidemenu_tvmenucategory);
        mainlaytablayout= (TabLayout) findViewById(R.id.mainlay_tablayout);
        mainlayviewpager= (ViewPager) findViewById(R.id.mainlay_viewpager);
    }

    private void clicks() {
        toolbar_menuopen.setOnClickListener(this);
        sidemenuivmenuclose.setOnClickListener(this);
        sidemenuweb.setOnClickListener(this);
        sidemenucategory.setOnClickListener(this);
        sidemenunews.setOnClickListener(this);
        sidemenuvideos.setOnClickListener(this);
        sidemenufavour.setOnClickListener(this);
    }


    public void FragmentProcess(Fragment fragment,Boolean backstack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activitymain_container, fragment);
        if(backstack==true){
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
      //  finish();
        if(sidemenu.isDrawerOpen(navigationview)){
            sidemenu.closeDrawers();
        }
        else {
            super.onBackPressed();
        }

    }

    @Override
    public void onClick(View v) {
        if(v==toolbar_menuopen){
            sidemenu.openDrawer(navigationview);
        }
        if(v==sidemenuivmenuclose){
            sidemenu.closeDrawer(navigationview);
        }
        if(v==sidemenuweb){

        }
        if(v==sidemenucategory){

        }
        if(v==sidemenuvideos){

        }
        if(v==sidemenunews){

        }
        if(v==sidemenufavour){
            sidemenu.closeDrawer(navigationview);
            Log.e("clickedonfav","fav");
            FavouratesFragment favfragment=new FavouratesFragment();
            FragmentProcess(favfragment,true);
        }
    }


    public  void Tablayoutsetup(){
        PageviewAdapter pageviewAdapter=new PageviewAdapter(getSupportFragmentManager());
        pageviewAdapter.addfragment(new Videos(),"Tech videos");
        pageviewAdapter.addfragment(new FavouratesFragment(),"favourates");
        pageviewAdapter.addfragment(new GeneralFragment(),"general");
        pageviewAdapter.addfragment(new Feeds(),"news Feeds");
        mainlayviewpager.setAdapter(pageviewAdapter);
        mainlaytablayout.setupWithViewPager(mainlayviewpager);
    }
}

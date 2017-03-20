package upgradekaro.techinewsworld.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by cred-user-6 on 20/3/17.
 */

public class PageviewAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments=new ArrayList<>();
    ArrayList<String> title=new ArrayList<>();

    public void addfragment(Fragment frag, String titleofpage) {
        this.fragments.add(frag);
        this.title.add(titleofpage);
    }
    public PageviewAdapter(FragmentManager fragmngr) {
        super(fragmngr);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}

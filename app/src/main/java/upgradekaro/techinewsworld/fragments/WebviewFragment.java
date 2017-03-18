package upgradekaro.techinewsworld.fragments;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

import upgradekaro.techinewsworld.R;
import upgradekaro.techinewsworld.db.Dbhelper;
import upgradekaro.techinewsworld.db.Dbutils;


/**
 * A simple {@link Fragment} subclass.
 */
public class WebviewFragment extends Fragment implements View.OnClickListener {
    WebView WebFragWebview;
    Toolbar customwebtoolbar;
    String weblink,presenturl;
    ProgressBar fragwebprogress;
    ImageView webfragtoolbarshare,webfragtoolbarfav,webfragtoolbarbackarrow;
    Dbhelper dbhelper;
    Boolean Favlinkexsist=false;
    public WebviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_web, container, false);
        initcomponents(view);
        Bundle linkarguments=getArguments();
        weblink=linkarguments.getString("clickeditem");
        WebSettingsForWebView();
        WebFragWebview.loadUrl(weblink);
        Clicks();
        return view;
    }
    private void WebSettingsForWebView() {
        WebFragWebview.getSettings().setJavaScriptEnabled(true);
        WebFragWebview.getSettings().setLoadsImagesAutomatically(true);
        WebFragWebview.getSettings().getAllowFileAccess();
        WebFragWebview.setWebViewClient(new WebViewClient());
        WebFragWebview.canGoBack();
        WebFragWebview.setWebChromeClient(new WebChromeClient(){
            public void onProgressChanged(WebView view,int progress){
                Log.e("progress",""+progress);
                fragwebprogress.setProgress(progress);
                if(progress>=100){
                    fragwebprogress.setVisibility(View.GONE);
                }
            }
        });
        /**
         * setonkey listener will make roll back of clicks in webview
         */
        WebFragWebview.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    WebView webView = (WebView) v;
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_BACK:
                            if (webView.canGoBack()) {
                                webView.goBack();
                                return true;
                            }
                            break;
                    }
                }

                return false;
            }
        });
    }
    public  void initcomponents(View v){
        WebFragWebview= (WebView) v.findViewById(R.id.webfrag_webview);
        fragwebprogress= (ProgressBar) v.findViewById(R.id.fragweb_progress);
        customwebtoolbar= (Toolbar) v.findViewById(R.id.toolbar_webview);
        webfragtoolbarfav= (ImageView) v.findViewById(R.id.webfragtoolbar_imgfav);
        webfragtoolbarshare= (ImageView) v.findViewById(R.id.webfragtoolbar_imgshare);
        webfragtoolbarbackarrow= (ImageView) v.findViewById(R.id.webfragtoolbar_imgbackarrow);
        dbhelper=new Dbhelper(getContext());
    }

    public void Clicks(){
        webfragtoolbarfav.setOnClickListener(this);
        webfragtoolbarshare.setOnClickListener(this);
        webfragtoolbarbackarrow.setOnClickListener(this);
    }

    public void Shareintent(){
        final Intent shareintent = new Intent(Intent.ACTION_SEND);
        shareintent.setType("text/plain");
        shareintent.putExtra(Intent.EXTRA_SUBJECT, "");
        shareintent.putExtra(Intent.EXTRA_TEXT, ""+presenturl);
        getContext().startActivities(new Intent[]{Intent.createChooser(shareintent, "share via")});
    }

    @Override
    public void onClick(View v) {
        if(v==webfragtoolbarfav){
            presenturl=WebFragWebview.getOriginalUrl().toString();
            Log.e("runningfav","tested");
            Dboperationwrite(presenturl,"trail");
            Favlinkexsist=true;
            if(Favlinkexsist==true){
                webfragtoolbarfav.setImageResource(R.drawable.heart_off);
            }

        }
        if(v==webfragtoolbarshare){
            Log.e("runningshare","tested");
            Shareintent();
            Dboperationread();
        }
        if (v==webfragtoolbarbackarrow){
                getActivity().getSupportFragmentManager().popBackStackImmediate();
        }
    }

    public void Dboperationwrite(String favlink,String linkname){
        dbhelper.AddFavlinkData(favlink,linkname);
    }

    public void Dboperationread(){
        Cursor recfav=dbhelper.getDatafromfavTable();
        if (recfav!=null){
            if (recfav.moveToFirst()){
                do {
                    Log.e("database data",""+recfav.getString(recfav.getColumnIndex(""+ Dbutils.Db_fav_link)));
                }
                while (recfav.moveToNext());
            }
        }
    }

}


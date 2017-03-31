package upgradekaro.techinewsworld.activity;

import android.os.Bundle;
import android.view.WindowManager;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

import upgradekaro.techinewsworld.R;

public class Basictestact extends YouTubeBaseActivity{
    //YouTubePlayerView youTubePlayerView;
    YouTubePlayerFragment youTubePlayerView;

    String trailid = "srH-2pQdKhg&t=193s";
   //  String apikeyyoutube="AIzaSyBIP8W4TB3qsnQjYH88ahM9BTevZWGJ9F8";
    String apikeyyoutube = "AIzaSyBn6Vwvl0wAihdvVfAG29Iwh8uwkdVlT-w";
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_youtube);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        youTubePlayerView = (YouTubePlayerFragment)getFragmentManager()
                .findFragmentById(R.id.youtube_playerview);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if(!b){
                    youTubePlayer.loadVideo("23UiMaJmW5c");
                }

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        youTubePlayerView.initialize("AIzaSyBIP8W4TB3qsnQjYH88ahM9BTevZWGJ9F8",onInitializedListener);
    }
}

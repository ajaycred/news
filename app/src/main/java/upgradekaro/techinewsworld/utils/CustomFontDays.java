package upgradekaro.techinewsworld.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by cred-user-6 on 29/12/16.
 */

public class CustomFontDays extends TextView {
    public CustomFontDays(Context context, AttributeSet attribute) {
        super(context, attribute);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/Days.otf"));
    }
}

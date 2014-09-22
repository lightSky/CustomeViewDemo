package sky.light.com.customeviewdemo;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

import infiniteviewpager.Logger;

/**
 * Created by xushuai on 2014/9/22.
 * Just for test, you can use ImageView directly.
 */
public class MyImageView extends ImageView {
    private static final String DEBUG_TAG = "ImageView__ActionEvent";

    public MyImageView(Context context) {
        super(context);
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);

        switch(action) {
            case (MotionEvent.ACTION_DOWN):
                Logger.d(DEBUG_TAG, "onTouchEvent Action was DOWN");
                break;
            case (MotionEvent.ACTION_MOVE):
                Logger.d(DEBUG_TAG, "onTouchEvent Action was MOVE");
                break;
            case (MotionEvent.ACTION_UP):
                Logger.d(DEBUG_TAG, "onTouchEvent Action was UP");
                break;
        }

        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = MotionEventCompat.getActionMasked(ev);

        switch(action) {
            case (MotionEvent.ACTION_DOWN):
                Logger.d(DEBUG_TAG, "onIntercept Action was DOWN");
                break;
            case (MotionEvent.ACTION_MOVE):
                Logger.d(DEBUG_TAG, "onIntercept Action was MOVE");
                break;
            case (MotionEvent.ACTION_UP):
                Logger.d(DEBUG_TAG, "onIntercept Action was UP");
                break;
        }

        return super.dispatchTouchEvent(ev);
    }
}

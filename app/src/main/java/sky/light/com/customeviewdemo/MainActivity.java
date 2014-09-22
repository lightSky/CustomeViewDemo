package sky.light.com.customeviewdemo;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import infiniteviewpager.AutoScrollViewPager;
import infiniteviewpager.Logger;
import viewpagerindicator.CirclePageIndicator;


public class MainActivity extends ActionBarActivity {
    private static final String DEBUG_TAG = "Activity__ActionEvent";
    private PageAdapter mAdapter;
    private AutoScrollViewPager mAutoScrollViewPager;
    private CirclePageIndicator mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        mAdapter = new PageAdapter(this);
        mAutoScrollViewPager = (AutoScrollViewPager)findViewById(R.id.view_pager);
        mAutoScrollViewPager.setAdapter(mAdapter);
        mAutoScrollViewPager.setInterval(2000);

        mIndicator = (CirclePageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mAutoScrollViewPager);
        mIndicator.setViewCount(4);
        mIndicator.setSnap(true);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        mAutoScrollViewPager.startAutoScroll();
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

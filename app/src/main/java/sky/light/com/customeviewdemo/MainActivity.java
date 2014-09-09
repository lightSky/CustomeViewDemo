package sky.light.com.customeviewdemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;

import infiniteviewpager.AutoScrollViewPager;
import viewpagerindicator.CirclePageIndicator;


public class MainActivity extends ActionBarActivity {
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
}

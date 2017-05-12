package com.codebrat.pagertabs;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    ViewPager viewPager;
    TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabs = (TabLayout) findViewById(R.id.tabLayout);

        setupViewPager(viewPager);
        tabs.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        PageAdapter adapter = new PageAdapter(getFragmentManager());
        adapter.addFragment(new TabOne(), "Tab One");
        adapter.addFragment(new TabTwo(), "Tab Two");
        viewPager.setAdapter(adapter);
    }
}

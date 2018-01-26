package com.project.padc.nyinyi.padctedtalks.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.project.padc.nyinyi.padctedtalks.R;
import com.project.padc.nyinyi.padctedtalks.TedTalksApp;
import com.project.padc.nyinyi.padctedtalks.adapters.ViewPagerAdapter;
import com.project.padc.nyinyi.padctedtalks.data.models.TedModel;
import com.project.padc.nyinyi.padctedtalks.fragments.PlayListFragments;
import com.project.padc.nyinyi.padctedtalks.fragments.TalksFragments;
import com.project.padc.nyinyi.padctedtalks.fragments.TedPodCastFragment;
import com.project.padc.nyinyi.padctedtalks.network.response.TalksResponse;
import com.project.padc.nyinyi.padctedtalks.utils.TedConstants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tabs)
    TabLayout tab;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this,this);

        setUpViewPager(viewPager);
        viewPager.setOffscreenPageLimit(3);
        tab.setupWithViewPager(viewPager);

        tab.getTabAt(0).setIcon(R.drawable.selector_ted_news);
        tab.getTabAt(1).setIcon(R.drawable.selector_ted_play_list);
        tab.getTabAt(2).setIcon(R.drawable.selector_ted_headset);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new TalksFragments(this), "");
        adapter.addFragment(new PlayListFragments(this), "");
        adapter.addFragment(new TedPodCastFragment(this), "");
        viewPager.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}

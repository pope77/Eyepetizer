package com.example.eyepetizer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.eyepetizer.discover.DiscoverFragment;
import com.example.eyepetizer.home.HomeFragment;
import com.example.eyepetizer.follow.FollowFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author popeg
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottomNavigationView_home)
    BottomNavigationView bottomNavigationViewHome;
    @BindView(R.id.viewPager_home)
    ViewPager viewPagerHome;
    MenuItem menuItem;

    /**
     * 导航栏待复位icon位置
     */
    private int resetPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        //初始化导航栏
        initNaviBar();
    }

    /**
     * 初始化导航栏方法
     */
    private void initNaviBar() {

        //设置ViewPager监听
        viewPagerHome.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationViewHome.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigationViewHome.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        //设置导航栏监听
        bottomNavigationViewHome.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navi_home:
                        resetNaviIcon(resetPos);
                        resetPos = 0;
                        viewPagerHome.setCurrentItem(0);
                        menuItem.setIcon(R.mipmap.ic_home_selected);
                        break;
                    case R.id.navi_discover:
                        resetNaviIcon(resetPos);
                        resetPos = 1;
                        viewPagerHome.setCurrentItem(1);
                        menuItem.setIcon(R.mipmap.ic_community_selected);
                        break;
                    case R.id.navi_follow:
                        resetNaviIcon(resetPos);
                        resetPos = 2;
                        viewPagerHome.setCurrentItem(2);
                        menuItem.setIcon(R.mipmap.ic_notice_selected);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
        bottomNavigationViewHome.getMenu().getItem(resetPos).setIcon(R.mipmap.ic_home_selected);

        //准备fragment
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new DiscoverFragment());
        fragments.add(new FollowFragment());

        //适配器
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager(), fragments);
        viewPagerHome.setAdapter(adapter);

    }

    /**
     * 重置导航栏图标
     */
    private void resetNaviIcon(int resetPos) {

        switch (resetPos) {
            case 0:
                MenuItem home = bottomNavigationViewHome.getMenu().findItem(R.id.navi_home);
                home.setIcon(R.mipmap.ic_home);
                break;
            case 1:
                MenuItem community = bottomNavigationViewHome.getMenu().findItem(R.id.navi_discover);
                community.setIcon(R.mipmap.ic_community);
                break;
            case 2:
                MenuItem notice = bottomNavigationViewHome.getMenu().findItem(R.id.navi_follow);
                notice.setIcon(R.mipmap.ic_notice);
                break;
            default:
                break;
        }


    }
}

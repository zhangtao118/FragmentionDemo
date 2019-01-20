package com.example.admin.fragmentiondemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import me.yokeyword.fragmentation_swipeback.SwipeBackActivity;

public class MainActivity extends SwipeBackActivity {

    HomeFragment homeFragment;
    DashboardFragment dashboardFragment;
    NotificationFragment notificationFragment;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    showHideFragment( homeFragment );
                    return true;
                case R.id.navigation_dashboard:
                    showHideFragment( dashboardFragment );
                    return true;
                case R.id.navigation_notifications:
                    showHideFragment( notificationFragment );
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        BottomNavigationView navigation = (BottomNavigationView) findViewById( R.id.navigation );
        navigation.setOnNavigationItemSelectedListener( mOnNavigationItemSelectedListener );

        homeFragment = findFragment( HomeFragment.class );
        if (homeFragment == null) {
            homeFragment = HomeFragment.newInstance( "HomeFragment", "第一张" );
            dashboardFragment = DashboardFragment.newInstance( "DashboardFragment", "第二张" );
            notificationFragment = NotificationFragment.newInstance( "NotificationFragment", "第三张" );
            loadMultipleRootFragment( R.id.fl_container, 0, homeFragment, dashboardFragment, notificationFragment );
        } else {
            dashboardFragment = findFragment( DashboardFragment.class );
            notificationFragment = findFragment( NotificationFragment.class );
        }


    }

}

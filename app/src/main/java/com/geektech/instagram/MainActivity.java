package com.geektech.instagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.geektech.instagram.add.AddFragment;
import com.geektech.instagram.home.HomeFragment;
import com.geektech.instagram.like.LikeFragment;
import com.geektech.instagram.profile.ProfileFragment;
import com.geektech.instagram.search.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
 BottomNavigationView bottomNavigationView;
 FragmentContainerView fragmentContainerView;
 public List list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.main_bottom_navigation);
        fragmentContainerView=findViewById(R.id.fragment_container_view);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.menu_home:
                        openFragment(new HomeFragment());
                        break;
                    case R.id.menu_search:
                        openFragment(new SearchFragment());
                        break;
                        case R.id.menu_add:
                            openFragment(new AddFragment());
                            break;
                         case R.id.menu_like:
                             openFragment(new LikeFragment());
                             break;
                             case R.id.menu_profile:
                                 openFragment(new ProfileFragment());
                                 break;
                }
                return true;
            }
        });
    }
    private void openFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
        .replace(R.id.fragment_container_view,fragment)
                .commit();
    }
}
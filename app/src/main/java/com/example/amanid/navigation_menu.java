package com.example.amanid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import  android.widget.Button;
import android.os.Bundle;

import com.example.amanid.databinding.ActivityNavigationMenuBinding;

public class navigation_menu extends AppCompatActivity {
    public ActivityNavigationMenuBinding binding;
// test

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_menu);
        binding = ActivityNavigationMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new homeFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch(item.getItemId()){

                case R.id.home:
                    replaceFragment(new homeFragment());
                    break;
                case R.id.payments:
                    replaceFragment(new paymentsFragment());

                    break;
                case R.id.transfer:
                    replaceFragment(new transferFragment());

                    break;
                case R.id.explore:
                    replaceFragment(new exploreFragment());

                    break;
            }
            return true;
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}


package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import com.example.myapplication.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity{
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFrament(new HomeFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.home) {
                replaceFrament(new HomeFragment());
            } else if (itemId == R.id.profile) {
            } else if (itemId == R.id.category) {
                replaceFrament(new CategoryFragment());
            } else if (itemId == R.id.cart) {
                replaceFrament(new CartFragment());
            }
            return true;
        });
    }
    private void replaceFrament(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}
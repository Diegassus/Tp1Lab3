package com.example.trabajopractico1login.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.trabajopractico1login.R;
import com.example.trabajopractico1login.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        binding.btnLogin.setOnClickListener(view -> {
            viewModel.login(binding.etUsername.getText().toString(), binding.etPassword.getText().toString());
        });

        binding.btnRegistrarse.setOnClickListener(view -> {
            viewModel.registrar();
        });
    }


}
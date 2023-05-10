package com.example.trabajopractico1login.ui.registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.example.trabajopractico1login.databinding.ActivityRegistroBinding;

public class RegistroActivity extends AppCompatActivity {
    private ActivityRegistroBinding binding;
    private RegistroActivityViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(RegistroActivityViewModel.class);

        viewModel.getUser().observe(this, user -> {
            binding.etApellido.setText(user.getApellido());
            binding.etCorreo.setText(user.getEmail());
            binding.etDni.setText(user.getDni()+"");
            binding.etNombre.setText(user.getNombre());
            binding.etClave.setText(user.getPassword());
        });

        Intent intent = getIntent();
        if(intent.getBooleanExtra("logueado",false)){
            viewModel.cargarUser();
        }

        binding.btnCargar.setOnClickListener(view -> {
            viewModel.registrar(binding.etDni.getText().toString(), binding.etNombre.getText().toString(), binding.etApellido.getText().toString(), binding.etCorreo.getText().toString(), binding.etClave.getText().toString());
        });
    }
}
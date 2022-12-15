package com.example.homework16;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.homework16.databinding.ActivityMainBinding;
import com.example.homework16.databinding.CommentsElprimoBinding;

public class ElprimoActivity extends AppCompatActivity {
    CommentsElprimoBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CommentsElprimoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ElprimoActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.texttitle.setText(binding.texttitle.getText().toString()+" "+getIntent().getSerializableExtra("Text"));
    }
}

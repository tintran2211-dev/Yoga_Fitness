package com.example.bt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Menu extends AppCompatActivity {
    Button btn1_menu,btn2_menu,btn3_menu,btn4_menu;
    FirebaseAuth fire1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Anhxa();
    }
    private void Anhxa(){
        btn1_menu = findViewById(R.id.btn1_menu);
        btn2_menu = findViewById(R.id.btn2_menu);
        btn3_menu = findViewById(R.id.btn3_menu);
        btn4_menu = findViewById(R.id.btn4_menu);
        fire1 = FirebaseAuth.getInstance();

        btn1_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(Menu.this,Exerc_menu.class);
                startActivity(it1);
            }
        });
        btn4_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fire1.signOut();
                Intent intent = new Intent(Menu.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
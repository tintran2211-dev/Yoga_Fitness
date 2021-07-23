package com.example.bt2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import Object.User;

public class Detail extends AppCompatActivity {
    TextView textView,textView1;
    ImageView imageView;
    Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailexers);

        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
       User user= (User) bundle.get("object_user");

        textView = findViewById(R.id.txt1_detail);
        textView1 = findViewById(R.id.txt2_detail);
        imageView = findViewById(R.id.img_detail);
        button = findViewById(R.id.btn_detail);

        textView.setText(user.getTieude());
        imageView.setImageResource(user.getAnh());
    }
}

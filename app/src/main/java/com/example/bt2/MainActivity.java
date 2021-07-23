package com.example.bt2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button button_login1, button_login2;
    EditText edt_login1, edt_login2;
    TextView txt_login;
    FirebaseAuth fire1;
    AlertDialog.Builder reset_alert;
    LayoutInflater inflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_login1 = findViewById(R.id.edt_login1);
        edt_login2 = findViewById(R.id.edt_login2);
        button_login1 = findViewById(R.id.button_login1);
        button_login2 = findViewById(R.id.button_login2);
        txt_login       = findViewById(R.id.txt_login);
        fire1           = FirebaseAuth.getInstance();
        reset_alert     = new AlertDialog.Builder(this);
        inflater        = this.getLayoutInflater();

        button_login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tk = edt_login1.getText().toString();
                String mk = edt_login2.getText().toString();
                if (edt_login1.getText().toString().isEmpty()) {
                    edt_login1.setError("Xin mời nhập Email");
                    return;
                }
                if (edt_login2.getText().toString().isEmpty()) {
                    edt_login2.setError("Xin mời nhập Password");
                    return;
                }
                fire1.signInWithEmailAndPassword(tk, mk).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        startActivity(new Intent(getApplicationContext(), Menu.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        button_login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });
        txt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start dialog
                View view = inflater.inflate(R.layout.forgot_password, null);

                reset_alert.setTitle("Reset Forgot Password")
                        .setMessage("Enter Your Email to get Password reset link.")
                        .setPositiveButton("Reset", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText edt_frg = view.findViewById(R.id.edt_frg);
                                if (edt_frg.getText().toString().isEmpty()) {
                                    edt_frg.setError("Nhập email!");
                                    return;
                                }
                                fire1.sendPasswordResetEmail(edt_frg.getText().toString())
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Toast.makeText(MainActivity.this, "Reset Email Sent", Toast.LENGTH_SHORT).show();
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }).setNegativeButton("Cancel", null)
                        .setView(view)
                        .create().show();
            }
        });
    }

}
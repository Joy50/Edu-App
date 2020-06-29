package com.joy50.kendrobinduadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private Button loginBtn;
    private EditText userEmail;
    private EditText userPassword;
    private ProgressBar loader;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private TextView forgotPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Initilize button
        loginBtn = findViewById(R.id.login_btn);
        //Initilize Edittext
        userEmail = findViewById(R.id.user_email);
        userPassword = findViewById(R.id.user_password);

        //progressbar initialization
        loader = findViewById(R.id.progressBar);
        loader.setVisibility(View.GONE);

        //Initialize Firebase Auth
        auth = FirebaseAuth.getInstance();

        //Set clicklistener
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo:Login System
                String emailAddress = userEmail.getText().toString();
                String password = userPassword.getText().toString();
                loader.setVisibility(View.VISIBLE);
                loginBtn.setEnabled(false);
                if(!emailAddress.isEmpty()){
                    if (Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()){
                        if(!password.isEmpty()){
                            auth.signInWithEmailAndPassword(emailAddress,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        user = auth.getCurrentUser();
                                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                                        finish();
                                        loginBtn.setEnabled(true);
                                    }else {
                                        Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();
                                        loginBtn.setEnabled(true);
                                        loader.setVisibility(View.GONE);
                                    }
                                }
                            });
                        }else {
                            loader.setVisibility(View.GONE);
                            loginBtn.setEnabled(true);
                            Toast.makeText(LoginActivity.this, "Password is empty", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        loader.setVisibility(View.GONE);
                        loginBtn.setEnabled(true);
                        Toast.makeText(getApplicationContext(),"Email Address is not valid",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    loader.setVisibility(View.GONE);
                    loginBtn.setEnabled(true);
                    Toast.makeText(getApplicationContext(),"Email is empty",Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            }
        });*/

        forgotPassword = findViewById(R.id.forgot_password);
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ForgetPasswordActivity.class));
            }
        });

    }
}
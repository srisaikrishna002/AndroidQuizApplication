package com.example.quizapp;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    Button about;
    EditText editText;
    public static final String EXTRA_NAME="name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        about=findViewById(R.id.button2);
        editText=findViewById(R.id.idName);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=editText.getText().toString();
                int count=name.length();
                if(count != 0) {
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra(EXTRA_NAME,name);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Enter Your Name", Toast.LENGTH_SHORT).show();
                }

            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AboutActivity.class);
                startActivity(intent);
            }
        });
    }
}
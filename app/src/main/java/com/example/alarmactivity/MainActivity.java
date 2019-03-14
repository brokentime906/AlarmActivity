package com.example.alarmactivity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] items ={"망고","바나나","커피"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button listButton =(Button) findViewById(R.id.listButton);
        listButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("리스트");
                builder.setItems(items,new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface a, int i){
                        Toast.makeText(getApplicationContext(),items[i],Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog a = builder.create();
                a.show();
            }
        });

        Button exitButton = (Button) findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("정말로 종료?");
                builder.setTitle("종료 알림창")
                        .setCancelable(false)
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener(){
                          @Override
                            public void onClick(DialogInterface di, int i){
                              finish();
                          }
                        })
                        .setNegativeButton("No",new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dia, int i ){
                                dia.cancel();
                            }
                        });
                AlertDialog al = builder.create();
                al.show();
            }
        });
    }






}

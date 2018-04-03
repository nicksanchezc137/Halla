package com.example.hp.halla;

import android.annotation.TargetApi;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
EditText username,password;
Button login,create;
Toolbar toolbar;





    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.actionbar) ;
        toolbar.setTitle("Login");
        username = (EditText) findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);

        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"password is "+ password.getText(),Toast.LENGTH_SHORT).show();

            }
        });
        create = (Button)findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setTitle("Create Account");
                //hide the log in fragment
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.hide(getFragmentManager().findFragmentById(R.id.fragment1));
                ft.commit();

                //show the create fragment
                FragmentTransaction ft2 = getFragmentManager().beginTransaction();
                ft2.show(getFragmentManager().findFragmentById(R.id.fragment2));
                ft2.commit();
            }
        });
    }
}

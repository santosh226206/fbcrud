package com.example.fbcrud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText vid=findViewById(R.id.vid);
        EditText name=findViewById(R.id.name);
        EditText aadharno=findViewById(R.id.aadharno);
        Button button=findViewById(R.id.button);
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("vote");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s=aadharno.getText().toString().trim();
                    String s1=name.getText().toString().trim();
                    String s2=vid.getText().toString().trim();

                    user obj=new user(s2,s1);
                    myRef.child(s).setValue(obj);
                    /*Map<String,Object> taskMap = new HashMap<>();
                    taskMap.put("age", "12");
                    taskMap.put("gender", "male");
                    taskMap.put("age", "45");
                    taskMap.put("gender", "female");
                    myRef.push().setValue(taskMap);*/
                    //myRef.setValue(taskMap);

                }

            });

    }

    // Adding Logout Functionality
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this, Login_Activity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                return true;


        }
        return false;
    }


}
package org.nicolas.exampledatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView departmentTv = findViewById(R.id.departmentTv);
        final TextView jobTitleTv = findViewById(R.id.jobTitleTv);
        final TextView nameTv = findViewById(R.id.nameTv);

        new Nodes().credentials().child("00030").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Credentials credentials = dataSnapshot.getValue(Credentials.class);
                departmentTv.setText(credentials.getDeparment());
                jobTitleTv.setText(credentials.getJobTitle());
                nameTv.setText(credentials.getName());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
    }
}

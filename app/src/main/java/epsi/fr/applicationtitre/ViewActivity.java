package epsi.fr.applicationtitre;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Remi on 18/06/2019.
 */

public class ViewActivity extends AppCompatActivity {

    private ListView mListView;
    DatabaseReference databaseReference;
    List<epsi.fr.applicationtitre.Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_retrieved);

        databaseReference = FirebaseDatabase.getInstance().getReference("taches");
        mListView = (ListView) findViewById(R.id.list_view);

        tasks = new ArrayList<>();
    }

    @Override
    public void onStart() {
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot taskDataSnapshot : dataSnapshot.getChildren()) {

                    epsi.fr.applicationtitre.Task task = taskDataSnapshot.getValue(epsi.fr.applicationtitre.Task.class);
                    tasks.add(task);
                }
                epsi.fr.applicationtitre.TaskInfoAdapter taskInfoAdapter = new epsi.fr.applicationtitre.TaskInfoAdapter(ViewActivity.this, tasks);
                mListView.setAdapter(taskInfoAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void GoToMenu(View view){
        startActivity(new Intent(ViewActivity.this, MenuActivity.class));
    }
}

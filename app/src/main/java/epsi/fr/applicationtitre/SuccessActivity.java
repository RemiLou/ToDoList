package epsi.fr.applicationtitre;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Remi on 22/05/2019.
 */

public class SuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success);
    }

    public void SendData(epsi.fr.applicationtitre.Task person){
        /*FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference mDatabaseReference = mDatabase.getReference();
        mDatabaseReference = mDatabase.getReference().child("name");
        mDatabaseReference.setValue("Donald Duck");
        mDatabaseReference = mDatabase.getReference().child("user");
        mDatabaseReference.setValue(person);*/
    }

    public void GoToMenu(View view){
        startActivity(new Intent(SuccessActivity.this, MenuActivity.class));
    }
}

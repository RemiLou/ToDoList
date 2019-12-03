package epsi.fr.applicationtitre;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Remi on 22/05/2019.
 */

public class FailureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.failure);
    }

    public void GoToCreate(View view){
        startActivity(new Intent(FailureActivity.this, CreateActivity.class));
    }
}

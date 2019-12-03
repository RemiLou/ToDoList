package epsi.fr.applicationtitre;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Remi on 18/06/2019.
 */

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }

    public void GoToCreateMenu(View view){
        startActivity(new Intent(MenuActivity.this, CreateActivity.class));
    }

    public void GoToViewMenu(View view){
        startActivity(new Intent(MenuActivity.this, ViewActivity.class));
    }
}

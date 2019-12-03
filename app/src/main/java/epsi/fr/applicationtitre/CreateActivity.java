package epsi.fr.applicationtitre;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Locale;

public class CreateActivity extends AppCompatActivity {

    // FireBase
    DatabaseReference databaseReference;
    // Button and text
    private TextView mDisplayData;
    private TextView mButtonData;
    private Button mButtonSend;
    private Button mButtonBackToMenu;
    private TextView mNameTask;
    private TextView mDescriptionTask;

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private static final String TAG = "CreateActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create);

        databaseReference = FirebaseDatabase.getInstance().getReference("taches");

        mButtonSend = (Button)findViewById(R.id.send);
        mButtonBackToMenu = (Button)findViewById(R.id.retour);
        mNameTask = (TextView)findViewById(R.id.name);
        mDescriptionTask = (TextView)findViewById(R.id.description);

        mButtonBackToMenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                GoToMenu();
            }
        });

        mButtonSend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addTask();
            }
        });

        mDisplayData = (TextView)findViewById(R.id.dateDisplay);
        mButtonData = (TextView)findViewById(R.id.dateButton);

        mButtonData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                Locale.setDefault(Locale.FRANCE);

                DatePickerDialog dialog = new DatePickerDialog(
                        CreateActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;

                String sDay = String.valueOf(day);
                String sMonth = String.valueOf(month);
                if (day < 10)
                    sDay = "0" + day;
                if (month < 10)
                    sMonth = "0" + month;

                String date = sDay + "/" + sMonth + "/" + year;
                mDisplayData.setText(date);
            }
        };
    }

    public void addTask(){

        String nameTask = mNameTask.getText().toString();
        String descriptionTask = mDescriptionTask.getText().toString();
        String dateTask = mDisplayData.getText().toString();

        if (!TextUtils.isEmpty(nameTask) && !TextUtils.isEmpty(descriptionTask)){

            String id = databaseReference.push().getKey();

            epsi.fr.applicationtitre.Task task = new epsi.fr.applicationtitre.Task(id, nameTask, dateTask, descriptionTask);

            databaseReference.child(id).setValue(task);

            GoToSuccess();
        }else{

            // inflate the layout of the popup window
            LayoutInflater inflater = (LayoutInflater)
                    getSystemService(LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.popup_error, null);

            // create the popup window
            int width = LinearLayout.LayoutParams.WRAP_CONTENT;
            int height = LinearLayout.LayoutParams.WRAP_CONTENT;
            boolean focusable = true; // lets taps outside the popup also dismiss it
            final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

            // show the popup window
            // which view you pass in doesn't matter, it is only used for the window tolken
            popupWindow.showAtLocation(mButtonBackToMenu ,Gravity.CENTER, 0, 0);

            // dismiss the popup window when touched
            popupView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    popupWindow.dismiss();
                    return true;
                }
            });
        }
    }

    public void GoToMenu(){
        startActivity(new Intent(CreateActivity.this, MenuActivity.class));
    }

    public void GoToSuccess(){
        startActivity(new Intent(CreateActivity.this, SuccessActivity.class));
    }

    public void GoToFailure(){
        startActivity(new Intent(CreateActivity.this, FailureActivity.class));
    }
}

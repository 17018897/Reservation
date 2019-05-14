package sg.edu.rp.c346.reservation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etMobile;
    EditText etPax;
    CheckBox cbSmoke;
    DatePicker dp;
    TimePicker tp;
    Button btnConfirm;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etMobile = findViewById(R.id.editTextMobile);
        etPax = findViewById(R.id.editTextSize);

        cbSmoke = findViewById(R.id.checkBoxSmoke);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);

        btnConfirm = findViewById(R.id.buttonConfirm);
        btnReset = findViewById(R.id.buttonReset);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence text = "";

                String msg = "";
                if (cbSmoke.isChecked()){
                    msg = "Smoking Area!";
                }else{
                    msg = "Non-Smoking Area!";
                }
                text ="Name: " + etName.getText().toString()
                        +"\n" + "MobileNo: " + etMobile.getText().toString()
                        +"\n" + "Pax: " + etPax.getText().toString()
                        +"\n" + "Time: " + tp.getCurrentHour() + ":" + tp.getCurrentMinute()
                        +"\n" + "Date: " + dp.getDayOfMonth() + "/" + (dp.getMonth()+1) + "/" + dp.getYear()
                        +"\n" + "Area: " + msg;


                Toast.makeText(MainActivity.this,text,Toast.LENGTH_SHORT).show();
        }
            });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etPax.setText("");
                etMobile.setText("");
                etName.setText("");
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                dp.updateDate(2019,5,1);
                cbSmoke.setChecked(false);
            }
        });
    }
}

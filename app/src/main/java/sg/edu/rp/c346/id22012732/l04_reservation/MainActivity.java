package sg.edu.rp.c346.id22012732.l04_reservation;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends Activity {

    EditText enterName;
    EditText enterPhoneNumber;
    EditText enterGroupSize;
    DatePicker datePicker;
    TimePicker timePicker;
    RadioGroup tableType;
    RadioButton smoking;
    RadioButton nonSmoking;
    Button confirmButton;
    Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterName = findViewById(R.id.enterName);
        enterPhoneNumber = findViewById(R.id.enterPhoneNumber);
        enterGroupSize = findViewById(R.id.enterGroupSize);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        tableType = findViewById(R.id.tableType);
        smoking = findViewById(R.id.radioButtonSmoking);
        nonSmoking = findViewById(R.id.radioButtonNonSmoking);
        confirmButton = findViewById(R.id.buttonConfirm);
        resetButton = findViewById(R.id.buttonReset);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JUNE, 1);
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), null);
        timePicker.setCurrentHour(7);
        timePicker.setCurrentMinute(30);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = enterName.getText().toString();
                String phoneNumber = enterPhoneNumber.getText().toString();
                String groupSize = enterGroupSize.getText().toString();
                String date = datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getYear();
                String time = timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute();
                String tableTypeText = smoking.isChecked() ? "Smoking" : "Non-smoking";
                String message = "Reservation Details:\nName: " + name + "\nMobile Number: " + phoneNumber + "\nGroup Size: " + groupSize + "\nDate: " + date + "\nTime: " + time + "\nTable Type: " + tableTypeText;
                Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 200);
                toast.show();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterName.setText("");
                enterPhoneNumber.setText("");
                enterGroupSize.setText("");
                smoking.setChecked(true);
                nonSmoking.setChecked(false);
                Calendar calendar = Calendar.getInstance();
                calendar.set(2020, Calendar.JUNE, 1);
                datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), null);
                timePicker.setCurrentHour(7);
                timePicker.setCurrentMinute(30);
            }
        });
    }
}
package presarklenke.com.securitylock.ui;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import presarklenke.com.securitylock.R;

public class NewEvent extends Activity implements View.OnClickListener, TimePickerDialog.OnTimeSetListener {
    boolean clicked_start_time = true;
    private TextView startTimePicked, endTimePicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        ((LinearLayout)findViewById(R.id.new_event_start_time)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.new_event_end_time)).setOnClickListener(this);
        startTimePicked =((TextView)findViewById(R.id.new_event_text_view_start_time_picked));
        endTimePicked = ((TextView)findViewById(R.id.new_event_text_view_end_time_picked));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_event, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.new_event_start_time:
                clicked_start_time = true;
                showTimePickerDialog();
                break;
            case R.id.new_event_end_time:
                clicked_start_time = false;
                showTimePickerDialog();
                break;
        }
    }

    private void showTimePickerDialog() {
        Calendar c = Calendar.getInstance();
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);
        new TimePickerDialog(this, this, mHour, mMinute, false).show();

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        if (clicked_start_time) {
            startTimePicked.setText(String.valueOf(convertTime(hourOfDay, minute)));
        } else {
            endTimePicked.setText(String.valueOf(hourOfDay) + ':' + String.valueOf(minute));
        }
    }

    private String convertTime(int hourOfDay, int minute) {
        boolean isPM = false;
        if(hourOfDay > 12) {
            hourOfDay-=12;
            isPM = true;
        }
        return String.valueOf(hourOfDay) + ":" + String.valueOf(minute) + " " + (isPM ? "PM" : "AM");
    }
}

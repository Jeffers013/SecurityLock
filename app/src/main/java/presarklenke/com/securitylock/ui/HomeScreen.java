package presarklenke.com.securitylock.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import presarklenke.com.securitylock.R;

public class HomeScreen extends ActionBarActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ((Button)findViewById(R.id.screen_home_add_event_button)).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch(item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "You pressed settings", Toast.LENGTH_SHORT).show();
            break;
            case R.id.action_about:
                //TODO tell them all about us and how awesome we are.
                Intent i = new Intent(this, About.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * This method shows a generic android dialog that lets the user pick between
     * creating anew event or using an existing one from their calendar.
      */
     private void showEventOptionsdialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.options_title)
                .setItems(R.array.new_event_options, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0) {
                            Intent intent = new Intent(HomeScreen.this, NewEvent.class);
                            HomeScreen.this.startActivity(intent);
                        } else {
                            //TODO figure out how to get calendar events.
//                            Intent calIntent = new Intent(Intent.Action);
//                            calIntent.putExtra("title", "Some title");
//                            calIntent.putExtra("description", "Some description");
//                            HomeScreen.this.startActivityForResult(calIntent, HomeScreenCalendarRequestID);
                        }
                    }
                }).create();
        builder.show();
    }

    @Override
    public void onClick(View v) {
        //switch on the id that was clicked. Each view has an id associated with it in the R.java class.
        switch(v.getId()) {
            case R.id.screen_home_add_event_button:
                /*We will spawn a dialog here. It will ask how we want to create the event. A brand
                new event or from an already existing appointment */
                showEventOptionsdialog();
                break;
        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        switch (resultCode) {
//            case HomeScreenCalendarRequestID:
//                Toast.makeText(getApplicationContext(), "Testing", Toast.LENGTH_LONG).show();
//                break;
//        }
//    }
}

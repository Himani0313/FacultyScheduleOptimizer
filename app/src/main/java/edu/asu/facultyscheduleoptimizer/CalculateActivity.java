package edu.asu.facultyscheduleoptimizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.google.api.client.util.DateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import edu.asu.facultyscheduleoptimizer.dummy.DummyContent;
import edu.asu.facultyscheduleoptimizer.dummy.sample;

public class CalculateActivity extends AppCompatActivity {

    EditText research, teaching, service, deiservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        Bundle i = getIntent().getExtras(); //This should be getIntent();
        List<sample> eventStrings = new ArrayList<sample>();
        eventStrings = (List<sample>) i.getSerializable("eventStr");
        Log.d("From calculate activity",eventStrings.toString());
        for (int c = 0; c < eventStrings.size(); c++) {
            System.out.println(eventStrings.get(c).nameEvent);
        }
        research = (EditText)findViewById(R.id.researchhour);
        teaching = (EditText)findViewById(R.id.teachinghour);
        service = (EditText)findViewById(R.id.servicehour);
        deiservice = (EditText)findViewById(R.id.deiservicehours);
        //research.setText(edu.asu.facultyscheduleoptimizer.EventListActivity.rhour.toString());
    }
    public void caldiff(DateTime d1, DateTime d2){
        
    }
}

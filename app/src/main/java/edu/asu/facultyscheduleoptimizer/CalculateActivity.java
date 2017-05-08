package edu.asu.facultyscheduleoptimizer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import com.google.api.client.util.DateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.asu.facultyscheduleoptimizer.dummy.sample;

public class CalculateActivity extends AppCompatActivity {

    EditText research, teaching, service, deiservice;
    Long rhour = Long.valueOf(0), dhour = Long.valueOf(0), thour = Long.valueOf(0), shour= Long.valueOf(0), nhour = Long.valueOf(0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        Bundle i = getIntent().getExtras(); //This should be getIntent();
        List<sample> eventStrings = new ArrayList<sample>();
        eventStrings = (List<sample>) i.getSerializable("eventStr");
        Log.d("From calculate activity",eventStrings.toString());

        for (int c = 0; c < eventStrings.size(); c++) {
            //System.out.println(eventStrings.get(c).nameEvent);
            if(eventStrings.get(c).typeEvent.equals("Research")){
                rhour += caldiff(eventStrings.get(c).t1,eventStrings.get(c).t2);
            }
            else if(eventStrings.get(c).typeEvent.equals("Teaching")){
                thour += caldiff(eventStrings.get(c).t1,eventStrings.get(c).t2);
            }
            else if(eventStrings.get(c).typeEvent.equals("Service")){
                shour += caldiff(eventStrings.get(c).t1,eventStrings.get(c).t2);
            }
            else if(eventStrings.get(c).typeEvent.equals("DEI Service")){
                dhour += caldiff(eventStrings.get(c).t1,eventStrings.get(c).t2);
            }
            else
                nhour += caldiff(eventStrings.get(c).t1,eventStrings.get(c).t2);

        }
        research = (EditText)findViewById(R.id.researchhour);
        teaching = (EditText)findViewById(R.id.teachinghour);
        service = (EditText)findViewById(R.id.servicehour);
        deiservice = (EditText)findViewById(R.id.deiservicehours);
        research.setText(String.valueOf(rhour));
        teaching.setText(String.valueOf(thour));
        service.setText(String.valueOf(shour));
        deiservice.setText(String.valueOf(dhour));
        //research.setText(edu.asu.facultyscheduleoptimizer.EventListActivity.rhour.toString());
    }
    public long caldiff(DateTime d1, DateTime d2){
        long ans;
        if(d2.isDateOnly()){
            long time = d2.getValue() - d1.getValue();
            Log.d("hellllloo",String.valueOf(time/3600000));
            if(time == 0){
                ans = 24;
            }
            else
                ans = time/3600000;
        }
        else{
            long time = d2.getValue() - d1.getValue();
           // System.out.println(time/3600000);
            Log.d("hellllloo",String.valueOf(time/3600000));
            ans = time/3600000;
        }
        return ans;
    }
}

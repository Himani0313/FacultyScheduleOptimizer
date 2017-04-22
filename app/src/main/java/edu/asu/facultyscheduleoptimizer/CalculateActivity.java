package edu.asu.facultyscheduleoptimizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import edu.asu.facultyscheduleoptimizer.dummy.DummyContent;

public class CalculateActivity extends AppCompatActivity {

    EditText research, teaching, service, deiservice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        research = (EditText)findViewById(R.id.researchhour);
        teaching = (EditText)findViewById(R.id.teachinghour);
        service = (EditText)findViewById(R.id.servicehour);
        deiservice = (EditText)findViewById(R.id.deiservicehours);
        //research.setText(edu.asu.facultyscheduleoptimizer.EventListActivity.rhour.toString());
    }
}

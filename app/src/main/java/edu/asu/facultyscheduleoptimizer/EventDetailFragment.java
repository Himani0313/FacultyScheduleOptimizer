package edu.asu.facultyscheduleoptimizer;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.asu.facultyscheduleoptimizer.dummy.DummyContent;

import static edu.asu.facultyscheduleoptimizer.R.id.spinner;

/**
 * A fragment representing a single Event detail screen.
 * This fragment is either contained in a {@link EventListActivity}
 * in two-pane mode (on tablets) or a {@link EventDetailActivity}
 * on handsets.
 */
public class EventDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EventDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {

                appBarLayout.setTitle(mItem.getTitle());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_event_detail_fragment, container, false);
        //String[] typeofevents = {"Research","Teaching","Service","DEI Service"};
        List<String> typeofevents = new ArrayList<>(Arrays.asList("Research","Teaching","Service","DEI Service"));
        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            TextView title = (TextView) rootView.findViewById(R.id.TitleDetails);
            TextView description = (TextView) rootView.findViewById(R.id.DescriptionDetails);
            TextView startdate = (TextView) rootView.findViewById(R.id.StartDateDetails);
            TextView enddate = (TextView) rootView.findViewById(R.id.EndDateDetails);
            TextView place = (TextView) rootView.findViewById(R.id.PlaceDetails);
            TextView type = (TextView) rootView.findViewById(R.id.TYPE);
            Spinner spinner = (Spinner)rootView.findViewById(R.id.spinner);
            title.setText(mItem.getTitle());
            description.setText(mItem.getDescription());
            startdate.setText(mItem.getStartDate());
            enddate.setText(mItem.getEndDate());
            place.setText(mItem.getPlace());
            spinner.setVisibility(View.VISIBLE);
            type.setVisibility(View.VISIBLE);
            ArrayAdapter<String> myadapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item,typeofevents);
            myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(myadapter);
            type.setText(mItem.Type);
            if(mItem.Type.equals("not specified") ){
               type.setVisibility(View.GONE);
            }
            else{
                spinner.setVisibility(View.GONE);
            }
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    mItem.Type = parent.getItemAtPosition(position).toString();
                    Log.d("vvvvvvvvvvvvvv",parent.getItemAtPosition(position).toString());
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });


        }

        return rootView;
    }


}
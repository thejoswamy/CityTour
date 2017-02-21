package com.udacity.thejoswamy.citytour;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Fragament which holds Night Life places
 */
public class NightLifeFragment extends Fragment {

    public NightLifeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.places_list_layout, container, false);

        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Toit Brewpub", "Open: 12PM-11:30PM", "Indira Nagar II Stage"));
        places.add(new Place("Murphy's Brewhouse", "Open: 11AM-11PM", "Domlur Layout"));
        places.add(new Place("District 6", "Open: 12PM-12AM", "Malleshwaram, Rajajinagar"));
        places.add(new Place("Big Brewsky", "Open: 12PM-1AM", "Sarjapur Road"));
        places.add(new Place("Church Street Social", "Open: 9AM-12:30AM", "Church Street, Bengaluru"));
        places.add(new Place("1522- The Pub", "Open: 11:30AM-11:30PM", "Koramangala"));
        places.add(new Place("153 Biere Street", "Open: 12PM-11:30PM", "Whitefield"));

        PlaceAdapter placeAdapter = new PlaceAdapter(getContext(), places, R.color.category_night_life);
        ListView listView = (ListView) viewGroup.findViewById(R.id.list);
        listView.setAdapter(placeAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Place currentPlace = (Place) parent.getItemAtPosition(position);
                Uri location = Uri.parse("geo:0,0?q=" + currentPlace.getName() + " " + currentPlace.getAddress());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });

        return viewGroup;
    }

}

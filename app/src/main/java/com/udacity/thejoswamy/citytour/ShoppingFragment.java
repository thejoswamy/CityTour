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
 * Fragament which holds Shopping places
 */
public class ShoppingFragment extends Fragment {

    public ShoppingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.places_list_layout, container, false);

        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Phoenix Marketcity", "Open: 10:30AM–11PM, 2–8PM", "Mahadevpura, Bengaluru"));
        places.add(new Place("Garuda Mall", "Open: 9AM–10PM", "Ashok Nagar, Bengaluru"));
        places.add(new Place("Orion Mall", "Open: 10AM–10:45PM", "Rajajinagar"));
        places.add(new Place("Gopalan Innovation Mall", "Open: 11AM–11PM", "JP Nagar"));
        places.add(new Place("The Forum Value Mall", "Open: 9:30AM–10:30PM", "Whitefield"));
        places.add(new Place("Inorbit Mall", "Open: 11AM–9:30PM", "Whitefield"));
        places.add(new Place("The Oasis Centre", "Open: 8AM–10PM", "Koramangala"));
        places.add(new Place("The Forum", "Open: 10AM–11PM", "Koramangala"));

        PlaceAdapter placeAdapter = new PlaceAdapter(getContext(), places, R.color.category_shopping);
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

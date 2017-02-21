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
        places.add(new Place(getString(R.string.place_phoenix), getString(R.string.timing_shopping), getString(R.string.area_mahadevapura)));
        places.add(new Place(getString(R.string.place_garuda), getString(R.string.timing_shopping), getString(R.string.area_ashok_nagar)));
        places.add(new Place(getString(R.string.place_orion), getString(R.string.timing_shopping), getString(R.string.area_rajajinagar)));
        places.add(new Place(getString(R.string.place_gopalan), getString(R.string.timing_shopping), getString(R.string.area_jp_nagar)));
        places.add(new Place(getString(R.string.place_forum_value), getString(R.string.timing_shopping), getString(R.string.area_whitefield)));
        places.add(new Place(getString(R.string.place_inorbit), getString(R.string.timing_shopping), getString(R.string.area_whitefield)));
        places.add(new Place(getString(R.string.place_oasis), getString(R.string.timing_shopping), getString(R.string.area_koramangala)));
        places.add(new Place(getString(R.string.place_the_forum), getString(R.string.timing_shopping), getString(R.string.area_koramangala)));

        PlaceAdapter placeAdapter = new PlaceAdapter(getContext(), places, R.color.category_shopping);
        ListView listView = (ListView) viewGroup.findViewById(R.id.list);
        listView.setAdapter(placeAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Place currentPlace = (Place) parent.getItemAtPosition(position);
                Uri location = Uri.parse(String.format(getString(R.string.location_string),
                        currentPlace.getName(), currentPlace.getAddress()));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });

        return viewGroup;
    }

}

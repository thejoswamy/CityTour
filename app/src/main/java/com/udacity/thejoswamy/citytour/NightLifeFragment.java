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
        places.add(new Place(getString(R.string.place_toit), getString(R.string.timing_night_life), getString(R.string.area_indira_nagar_stage2), R.mipmap.image_toit));
        places.add(new Place(getString(R.string.place_murphys), getString(R.string.timing_night_life), getString(R.string.area_domlur_layout), R.mipmap.image_murphys));
        places.add(new Place(getString(R.string.place_district6), getString(R.string.timing_night_life), getString(R.string.area_rajajinagar), R.mipmap.image_district6));
        places.add(new Place(getString(R.string.place_bigbrewsky), getString(R.string.timing_night_life), getString(R.string.area_sarjapur_road), R.mipmap.image_bigbrewsky));
        places.add(new Place(getString(R.string.place_social), getString(R.string.timing_night_life), getString(R.string.area_church_street), R.mipmap.image_church_street));
        places.add(new Place(getString(R.string.place_1522), getString(R.string.timing_night_life), getString(R.string.area_koramangala), R.mipmap.image_1522));
        places.add(new Place(getString(R.string.place_biere_street), getString(R.string.timing_night_life), getString(R.string.area_whitefield), R.mipmap.image_bierre_street));

        PlaceAdapter placeAdapter = new PlaceAdapter(getContext(), places, R.color.category_night_life);
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

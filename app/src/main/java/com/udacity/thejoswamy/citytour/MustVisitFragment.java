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
 * Fragament which holds Must Visit places
 */
public class MustVisitFragment extends Fragment {

    public MustVisitFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.places_list_layout, container, false);

        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getString(R.string.place_lalbagh), getString(R.string.timing_must_visit), getString(R.string.area_mavalli), R.mipmap.l_image));
        places.add(new Place(getString(R.string.place_bangalore_palace), getString(R.string.timing_must_visit), getString(R.string.area_vasanth_nagar), R.mipmap.b_image));
        places.add(new Place(getString(R.string.place_cubbon_park), getString(R.string.timing_must_visit), getString(R.string.area_sampangi_rama_nagar), R.mipmap.c_image));
        places.add(new Place(getString(R.string.place_vitm), getString(R.string.timing_must_visit), getString(R.string.area_sampangi_rama_nagar), R.mipmap.v_image));
        places.add(new Place(getString(R.string.place_iskcon), getString(R.string.timing_must_visit), getString(R.string.place_rajaji_nagar), R.mipmap.i_image));
        places.add(new Place(getString(R.string.place_snow_city), getString(R.string.timing_must_visit), getString(R.string.area_jc_nagar), R.mipmap.s_display));
        places.add(new Place(getString(R.string.place_bull_temple), getString(R.string.timing_must_visit), getString(R.string.area_basavanagudi), R.mipmap.b_image));
        places.add(new Place(getString(R.string.place_st_basilica), getString(R.string.timing_must_visit), getString(R.string.area_shivaji_nagar), R.mipmap.s_display));
        places.add(new Place(getString(R.string.place_bannerghatta_park), getString(R.string.timing_must_visit), getString(R.string.area_bannerghatta_road), R.mipmap.b_image));
        places.add(new Place(getString(R.string.place_wonderla), getString(R.string.timing_must_visit), getString(R.string.area_mysore_road), R.mipmap.w_image));

        PlaceAdapter placeAdapter = new PlaceAdapter(getContext(), places, R.color.category_must_visit);

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

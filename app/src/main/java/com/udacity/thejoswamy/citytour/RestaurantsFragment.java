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
 * Fragament which holds Restaurant places
 */
public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.places_list_layout, container, false);


        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getString(R.string.place_vidyarthi_bhavan), getString(R.string.timing_restaurant), getString(R.string.area_basavanagudi), R.mipmap.v_image));
        places.add(new Place(getString(R.string.place_nagarjuna), getString(R.string.timing_restaurant), getString(R.string.area_indira_nagar), R.mipmap.n_image));
        places.add(new Place(getString(R.string.place_nalapaka), getString(R.string.timing_restaurant), getString(R.string.area_rajajinagar), R.mipmap.h_image));
        places.add(new Place(getString(R.string.place_fisherman_wharf), getString(R.string.timing_restaurant), getString(R.string.area_sarjapur_road), R.mipmap.t_image));
        places.add(new Place(getString(R.string.place_empire_restaurant), getString(R.string.timing_restaurant), getString(R.string.area_church_street), R.mipmap.e_image));
        places.add(new Place(getString(R.string.place_salt_mango_tree), getString(R.string.timing_restaurant), getString(R.string.area_whitefield), R.mipmap.s_display));
        places.add(new Place(getString(R.string.place_windmills), getString(R.string.timing_restaurant), getString(R.string.area_whitefield), R.mipmap.w_image));
        places.add(new Place(getString(R.string.place_barbeque), getString(R.string.timing_restaurant), getString(R.string.area_koramangala), R.mipmap.b_image));
        places.add(new Place(getString(R.string.place_truffles), getString(R.string.timing_restaurant), getString(R.string.area_koramangala), R.mipmap.t_image));

        PlaceAdapter placeAdapter = new PlaceAdapter(getContext(), places, R.color.category_restaurants);

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

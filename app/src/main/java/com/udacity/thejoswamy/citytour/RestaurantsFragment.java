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
        places.add(new Place("Vidyarthi Bhavan", "Open: 6:30–11:30AM, 2–8PM", "Basavanagudi", R.mipmap.v_image));
        places.add(new Place("Nagarjuna Restaurant", "Open: 12–4PM, 7–11PM", "Indiranagar", R.mipmap.n_image));
        places.add(new Place("Hotel Nalapaka", "Open: 7:30AM–3:30PM, 5–10:30PM", "Rajajinagar", R.mipmap.h_image));
        places.add(new Place("The Fisherman's Wharf", "Open: 12–11PM", "Sarjapur Road", R.mipmap.t_image));
        places.add(new Place("Empire Restaurant", "Open: 12PM–1AM", "Church Street, Bengaluru", R.mipmap.e_image));
        places.add(new Place("Salt Mango Tree", "Open: 12:30–11PM", "Whitefield", R.mipmap.s_display));
        places.add(new Place("Windmills Craftworks", "Open: 11:30AM-11:30PM", "Whitefield", R.mipmap.w_image));
        places.add(new Place("Barbeque Nation", "Open: 12–3:30PM, 6:30–10:30PM", "Koramangala", R.mipmap.b_image));
        places.add(new Place("TRUFFLES", "Open: 12–11PM", "Koramangala", R.mipmap.t_image));

        PlaceAdapter placeAdapter = new PlaceAdapter(getContext(), places, R.color.category_restaurants);

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

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
        places.add(new Place("Lalbagh Botanical Garden", "Open: 6AM–6PM", "Mavalli, Bengaluru", R.mipmap.l_image));
        places.add(new Place("Bangalore Palace", "Open: 10:30AM–5:30PM", "Vasanth Nagar, Bengaluru", R.mipmap.b_image));
        places.add(new Place("Cubbon Park", "Open: 24 hours", "Sampangi Rama Nagar, Bengaluru", R.mipmap.c_image));
        places.add(new Place("Visvesvaraya Industrial & Technological Museum", "Open: 10AM–6PM", "Sampangi Rama Nagar, Bengaluru", R.mipmap.v_image));
        places.add(new Place("ISKCON Bangalore", "Open: 24 hours", "Rajaji Nagar, Bengaluru", R.mipmap.i_image));
        places.add(new Place("Snow City", "Open: 10AM–8PM", "J C Nagar, Bengaluru", R.mipmap.s_display));
        places.add(new Place("Bull Temple", "Open: 6AM–6PM", "Basavanagudi", R.mipmap.b_image));
        places.add(new Place("St. Mary's Basilica", "Open: 6AM–6PM", "Shivaji Nagar", R.mipmap.s_display));
        places.add(new Place("Bannerghatta National Park", "Open: 9:30AM–4:30PM", "Bannerghatta Road", R.mipmap.b_image));
        places.add(new Place("Wonderla", "Open: 11AM–6PM", "Mysore Road, Bangalore", R.mipmap.w_image));
        places.add(new Place("Nandi Temple", "Open: 6AM–6PM", "Basavanagudi", R.mipmap.n_image));

        PlaceAdapter placeAdapter = new PlaceAdapter(getContext(), places, R.color.category_must_visit);

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

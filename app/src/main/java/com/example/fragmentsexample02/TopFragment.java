package com.example.fragmentsexample02;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class TopFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_top, container, false);

        ListView listView = view.findViewById(R.id.listView);
        String[] items = {getString(R.string.ai_activity), getString(R.string.vr_activity)};
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) { // clicked on AIActivity
                    Intent i = new Intent(getActivity(), AIActivity.class);
                    startActivity(i);
                } else if (position == 1) { // clicked on VRActivity
                    Intent i = new Intent(getActivity(), VRActivity.class);
                    startActivity(i);
                }
            }
        });

        Toast.makeText(getActivity(), R.string.top_fragment_onCreateView, Toast.LENGTH_SHORT).show();

        return view;
    }

}

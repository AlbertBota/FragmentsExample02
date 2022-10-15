package com.example.fragmentsexample02;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BottomFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_bottom, container, false);

        // Getting values from Argument
        String lifeCycleUpdates = getArguments().getString("lifeCycleUpdates");

        TextView textView = view.findViewById(R.id.textView);
        textView.setText(lifeCycleUpdates);

        Toast.makeText(getActivity(), R.string.bottom_fragment_onCreateView, Toast.LENGTH_SHORT).show();

        return view;
    }

}

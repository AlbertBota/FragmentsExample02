package com.example.fragmentsexample02;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String lifeCycleUpdates = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new TopFragment(), R.id.topFragmentContainer);


        lifeCycleUpdates = lifeCycleUpdates + getString(R.string.main_activity);
        lifeCycleUpdates = lifeCycleUpdates + "\n" + getString(R.string.onCreate_executed);
        sendUpdateToBottomFragment();

    }

    @Override
    protected void onStart() {
        super.onStart();

        lifeCycleUpdates = lifeCycleUpdates + "\n" + getString(R.string.onStart_executed);
        sendUpdateToBottomFragment();
    }

    @Override
    protected void onStop() {
        super.onStop();

        lifeCycleUpdates = lifeCycleUpdates + "\n" + getString(R.string.onStop_executed);
        sendUpdateToBottomFragment();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        lifeCycleUpdates = lifeCycleUpdates + "\n" + getString(R.string.onDestroy_executed);
        sendUpdateToBottomFragment();
    }

    private void sendUpdateToBottomFragment() {
        BottomFragment bottomFragment = new BottomFragment();
        Bundle bundle = new Bundle();
        bundle.putString("lifeCycleUpdates", lifeCycleUpdates);
        bottomFragment.setArguments(bundle);
        loadFragment(bottomFragment, R.id.bottomFragmentContainer);
    }

    private void loadFragment(Fragment fragment, int fragmentID) {
        // create a FragmentManager
        FragmentManager fm = getFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(fragmentID, fragment);
        fragmentTransaction.commit(); // save the changes
    }
}

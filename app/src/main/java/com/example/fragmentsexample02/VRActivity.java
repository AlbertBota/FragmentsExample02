package com.example.fragmentsexample02;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class VRActivity extends AppCompatActivity {

    private String lifeCycleUpdates = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_vr);

        lifeCycleUpdates = lifeCycleUpdates + getString(R.string.vr_activity);
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
        // Prevent errors while trying to leave activity and after loading fragment
        if (this.isFinishing()) {
            return;
        }

        BottomFragment bottomFragment = new BottomFragment();
        Bundle bundle = new Bundle();
        bundle.putString("lifeCycleUpdates", lifeCycleUpdates);
        bottomFragment.setArguments(bundle);
        loadFragment(bottomFragment, R.id.fragmentContainer);
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

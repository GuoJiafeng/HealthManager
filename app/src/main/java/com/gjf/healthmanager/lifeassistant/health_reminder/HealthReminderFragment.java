package com.gjf.healthmanager.lifeassistant.health_reminder;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gjf.healthmanager.R;

/**
 * Created by BlackBeard丶 on 2017/04/10.
 */

public class HealthReminderFragment extends Fragment {
    @Nullable
    private  View view;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.life_assistant_fragment_health_reminder,container,false);
        return  view;
    }
}

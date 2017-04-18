package com.gjf.healthmanager.healthrecord.health_log;

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

public class HealthLogFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view ==null){
            view = inflater.inflate(R.layout.health_record_fragment_health_log,container,false);

        }else {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }

        return view;
    }
}
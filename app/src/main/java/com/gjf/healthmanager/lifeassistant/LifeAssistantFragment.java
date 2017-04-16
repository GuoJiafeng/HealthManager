package com.gjf.healthmanager.lifeassistant;

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

public class LifeAssistantFragment  extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.life_assistant_fragment,container,false);
        return view;
    }
}

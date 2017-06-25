package com.gjf.healthmanager.testtool;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gjf.healthmanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by BlackBeard丶 on 2017/04/10.
 */

public class TestToolFragment extends Fragment {
    @BindView(R.id.tizhong)
    EditText tizhong;
    @BindView(R.id.shengao)
    EditText shengao;
    @BindView(R.id.bn)
    Button bn;
    @BindView(R.id.textview)
    TextView textview;
    Unbinder unbinder;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.test_tool_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.bn)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.bn:
                double inttizhong = Double.parseDouble(tizhong.getText().toString());
                double intshengao = Double.parseDouble(shengao.getText().toString());
                double rsult = inttizhong/(intshengao*intshengao);
                String msg = String.valueOf(rsult);
                textview.setText(msg);
        }
    }
}

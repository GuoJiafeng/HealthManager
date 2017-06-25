package com.gjf.healthmanager;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.gjf.healthmanager.healthrecord.HeathRecordFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @BindView(R.id.health_record_fragment)
    LinearLayout health_record_fragment;
    @BindView(R.id.health_analysis_fragment)
    LinearLayout health_analysis_fragment;
    @BindView(R.id.test_tool_fragment)
    LinearLayout test_tool_fragment;
    @BindView(R.id.life_assistant_fragment)
    LinearLayout life_assistant_fragment;
    @BindView(R.id.online_search_fragment)
    LinearLayout online_search_fragment;
    @BindView(R.id.system_setting_fragment)
    LinearLayout system_setting_fragment;
    @BindView(R.id.layout)
    RelativeLayout layout;

    private MainPresenter mainContract;

    private HeathRecordFragment heathRecordFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setChenjinshitongzhilan();
        initView();
    }

    private void initView() {
        // setDefault();
        mainContract = new MainPresenter(this);
        mainContract.setDefaultFragment();

    }


    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }


    @OnClick({R.id.health_record_fragment, R.id.health_analysis_fragment, R.id.life_assistant_fragment, R.id.online_search_fragment, R.id.system_setting_fragment, R.id.test_tool_fragment})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.health_record_fragment:
                mainContract.setHeathrecordFragment();
               // layout.setBackgroundColor(Color.parseColor("#c11db9"));
                break;
            case R.id.health_analysis_fragment:
                mainContract.setHealthAnalysisFragment();
              //  layout.setBackgroundColor(Color.parseColor("#c9f1cc"));
                break;
            case R.id.life_assistant_fragment:
                mainContract.setLifeAssistantFragment();
               // layout.setBackgroundColor(Color.parseColor("#cec951"));
                break;
            case R.id.online_search_fragment:
                mainContract.setOnlinSearcherFragment();
             //   layout.setBackgroundColor(Color.parseColor("#d7531f"));
                break;
            case R.id.system_setting_fragment:
                mainContract.setSystemSettingFragment();
               // layout.setBackgroundColor(Color.parseColor("#101010"));
                break;
            case R.id.test_tool_fragment:
                mainContract.setTestToolFragment();
              //  layout.setBackgroundColor(Color.parseColor("#314cc6"));
                break;
        }

    }


    @Override
    public void ShowFragment(Fragment fragment, String msg) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.activity_mian_content, fragment);
        transaction.commit();
        Log.d("ggggg", "默认");
        Toast.makeText(getApplicationContext(), "现在显示的是" + msg + "Fragment", Toast.LENGTH_LONG).show();
    }
    private void setChenjinshitongzhilan(){
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().setStatusBarColor(Color.TRANSPARENT);

        }
    }
}

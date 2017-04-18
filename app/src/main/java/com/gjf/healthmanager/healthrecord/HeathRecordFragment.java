package com.gjf.healthmanager.healthrecord;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.gjf.healthmanager.MainContract;
import com.gjf.healthmanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by BlackBeard丶 on 2017/04/10.
 */

public class HeathRecordFragment extends Fragment implements HeathRecordContract.View {
    private View view;
    private HeathRecordPresenter presenter;

    @BindView(R.id.health_record_fragment_health_log_fragment)
    TextView health_record_fragment_health_log_fragment;
    @BindView(R.id.health_record_fragment_medical_mxamination_report_fragment)
    TextView health_record_fragment_medical_mxamination_report_fragment;
    @BindView(R.id.health_record_fragment_medical_records_fragment)
    TextView health_record_fragment_medical_records_fragment;
    @BindView(R.id.health_record_fragment_questionalnair_investigation_Fragment)
    TextView health_record_fragment_questionalnair_investigation_Fragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.health_record_fragment, container, false);
            intiView();
            ButterKnife.bind(this, view);

        } else {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }

        return view;
    }

    private void intiView() {
        presenter = new HeathRecordPresenter(this);
        presenter.setShowHealthLogFragment();

    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void showFragmen(Fragment fragment) {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.health_record_content, fragment);
        transaction.commit();
    }

    @OnClick({R.id.health_record_fragment_health_log_fragment,
            R.id.health_record_fragment_medical_mxamination_report_fragment,
            R.id.health_record_fragment_medical_records_fragment,
            R.id.health_record_fragment_questionalnair_investigation_Fragment})
    public void OnClick(View view) {
        switch (view.getId()){
            case R.id.health_record_fragment_health_log_fragment:
                presenter.setShowHealthLogFragment();
                Toast.makeText(getContext(),"1",Toast.LENGTH_LONG).show();
                break;
            case R.id.health_record_fragment_medical_mxamination_report_fragment:
                presenter.setShowMedicalMxaminationReport();
                Toast.makeText(getContext(),"2",Toast.LENGTH_LONG).show();
                break;
            case R.id.health_record_fragment_medical_records_fragment:
                presenter.setShowMedicalRecords();
                Toast.makeText(getContext(),"3",Toast.LENGTH_LONG).show();
                break;
            case R.id.health_record_fragment_questionalnair_investigation_Fragment:
                presenter.setShowQuestionnairInvestigationFragment();
                Toast.makeText(getContext(),"4",Toast.LENGTH_LONG).show();
                break;

        }

    }
}

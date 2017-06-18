package com.gjf.healthmanager.healthrecord.medical_records.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gjf.healthmanager.BasePresenter;
import com.gjf.healthmanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by BlackBeard丶 on 2017/6/18.
 */

public class AddMedicalRecordsActivity extends AppCompatActivity implements AddMedicalRecordsContract.View {
    @BindView(R.id.health_record_fragment_medical_records_add_jibingmingcheng)
    EditText healthRecordFragmentMedicalRecordsAddJibingmingcheng;
    @BindView(R.id.health_record_fragment_medical_records_add_qishishijian)
    EditText healthRecordFragmentMedicalRecordsAddQishishijian;
    @BindView(R.id.health_record_fragment_medical_records_add_quanyushijian)
    EditText healthRecordFragmentMedicalRecordsAddQuanyushijian;
    @BindView(R.id.health_record_fragment_medical_records_add_yongyaojilu)
    EditText healthRecordFragmentMedicalRecordsAddYongyaojilu;
    @BindView(R.id.health_record_fragment_medical_records_add_miaoshubingqing)
    EditText healthRecordFragmentMedicalRecordsAddMiaoshubingqing;
    @BindView(R.id.health_record_fragment_medical_records_add_queding_bn)
    Button healthRecordFragmentMedicalRecordsAddQuedingBn;
    @BindView(R.id.health_record_fragment_medical_records_add_qingchu_bn)
    Button healthRecordFragmentMedicalRecordsAddQingchuBn;
    @BindView(R.id.health_record_fragment_medical_records_add_fanhui_bn)
    Button healthRecordFragmentMedicalRecordsAddFanhuiBn;
  private AddMedicalRecordsPresenter addMedicalRecordsPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_record_fragment_medical_records_add);
        ButterKnife.bind(this);
        addMedicalRecordsPresenter = new AddMedicalRecordsPresenter(this);
    }

    @OnClick({R.id.health_record_fragment_medical_records_add_queding_bn, R.id.health_record_fragment_medical_records_add_qingchu_bn, R.id.health_record_fragment_medical_records_add_fanhui_bn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.health_record_fragment_medical_records_add_queding_bn:
                addMedicalRecordsPresenter.AddMedicalExaminationReportContract(
                        healthRecordFragmentMedicalRecordsAddJibingmingcheng.getText().toString()
                ,healthRecordFragmentMedicalRecordsAddQishishijian.getText().toString()
                ,healthRecordFragmentMedicalRecordsAddQuanyushijian.getText().toString()
                ,healthRecordFragmentMedicalRecordsAddYongyaojilu.getText().toString()
                ,healthRecordFragmentMedicalRecordsAddMiaoshubingqing.getText().toString());
                finish();

                break;
            case R.id.health_record_fragment_medical_records_add_qingchu_bn:
                break;
            case R.id.health_record_fragment_medical_records_add_fanhui_bn:
                break;
        }
    }

    @Override
    public void setPresenter(BasePresenter presenter) {

    }

    @Override
    public void ShowToast(String msg) {
        Toast.makeText(getApplicationContext(),msg.toString(),Toast.LENGTH_SHORT).show();
    }
}

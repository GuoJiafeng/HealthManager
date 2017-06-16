package com.gjf.healthmanager.healthrecord.medical_mxamination_report.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gjf.healthmanager.BasePresenter;
import com.gjf.healthmanager.R;
import com.gjf.healthmanager.healthrecord.medical_mxamination_report.MedicalExaminationReportPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by BlackBeard丶 on 2017/6/16.
 */

public class AddMedicalExaminationReportContractActivity extends AppCompatActivity implements AddMedicalExaminationReportContractActivitContract.View{

    @BindView(R.id.health_record_fragment_medical_mxamination_report_add_shengao)
    EditText healthRecordFragmentMedicalMxaminationReportAddShengao;
    @BindView(R.id.health_record_fragment_medical_mxamination_report_add_tizhong)
    EditText healthRecordFragmentMedicalMxaminationReportAddTizhong;
    @BindView(R.id.health_record_fragment_medical_mxamination_report_add_shili)
    EditText healthRecordFragmentMedicalMxaminationReportAddShili;
    @BindView(R.id.health_record_fragment_medical_mxamination_report_add_xinlv)
    EditText healthRecordFragmentMedicalMxaminationReportAddXinlv;
    @BindView(R.id.health_record_fragment_medical_mxamination_report_add_xueya)
    EditText healthRecordFragmentMedicalMxaminationReportAddXueya;
    @BindView(R.id.health_record_fragment_medical_mxamination_report_add_xuetang)
    EditText healthRecordFragmentMedicalMxaminationReportAddXuetang;
    @BindView(R.id.health_record_fragment_medical_mxamination_report_add_xuezhi)
    EditText healthRecordFragmentMedicalMxaminationReportAddXuezhi;
    @BindView(R.id.health_record_fragment_medical_mxamination_report_add_waikeyichang)
    EditText healthRecordFragmentMedicalMxaminationReportAddWaikeyichang;
    @BindView(R.id.health_record_fragment_medical_mxamination_report_add_neikeyichang)
    EditText healthRecordFragmentMedicalMxaminationReportAddNeikeyichang;
    @BindView(R.id.health_record_fragment_medical_mxamination_report_add_xuechangguiyichang)
    EditText healthRecordFragmentMedicalMxaminationReportAddXuechangguiyichang;
    @BindView(R.id.health_record_fragment_medical_mxamination_report_add_queding_bn)
    Button healthRecordFragmentMedicalMxaminationReportAddQuedingBn;
    @BindView(R.id.health_record_fragment_medical_mxamination_report_add_qingchu_bn)
    Button healthRecordFragmentMedicalMxaminationReportAddQingchuBn;
    @BindView(R.id.health_record_fragment_medical_mxamination_report_add_fanhui_bn)
    Button healthRecordFragmentMedicalMxaminationReportAddFanhuiBn;

    private MedicalExaminationReportPresenter medicalExaminationReport;

    private  AddMedicalExaminationReportContractActivitPresenter addMedicalExaminationReportContractActivitPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_record_fragment_medical_mxamination_report_add);
        ButterKnife.bind(this);
        addMedicalExaminationReportContractActivitPresenter = new AddMedicalExaminationReportContractActivitPresenter(this,getApplicationContext());
       // setChenjinshitongzhilan();
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

    @OnClick({R.id.health_record_fragment_medical_mxamination_report_add_queding_bn, R.id.health_record_fragment_medical_mxamination_report_add_qingchu_bn, R.id.health_record_fragment_medical_mxamination_report_add_fanhui_bn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.health_record_fragment_medical_mxamination_report_add_queding_bn:
                addMedicalExaminationReportContractActivitPresenter.AddMedicalExaminationReportContract(
                        healthRecordFragmentMedicalMxaminationReportAddShengao.getText().toString(),
                        healthRecordFragmentMedicalMxaminationReportAddTizhong.getText().toString(),
                        healthRecordFragmentMedicalMxaminationReportAddShili.getText().toString(),
                        healthRecordFragmentMedicalMxaminationReportAddXinlv.getText().toString(),
                        healthRecordFragmentMedicalMxaminationReportAddXueya.getText().toString(),
                        healthRecordFragmentMedicalMxaminationReportAddXuetang.getText().toString(),
                        healthRecordFragmentMedicalMxaminationReportAddXuezhi.getText().toString(),
                        healthRecordFragmentMedicalMxaminationReportAddWaikeyichang.getText().toString(),
                        healthRecordFragmentMedicalMxaminationReportAddNeikeyichang.getText().toString(),
                        healthRecordFragmentMedicalMxaminationReportAddXuechangguiyichang.getText().toString()
                        );

                finish();
                break;
            case R.id.health_record_fragment_medical_mxamination_report_add_qingchu_bn:
                break;
            case R.id.health_record_fragment_medical_mxamination_report_add_fanhui_bn:
                break;
        }
    }



    @Override
    public void setPresenter(BasePresenter presenter) {

    }

    @Override
    public void ShowToast(String msg) {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
}

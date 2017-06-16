package com.gjf.healthmanager.healthrecord.medical_mxamination_report;

import android.content.ContentValues;

import com.gjf.healthmanager.entiy.MedicalExaminationReport;
import com.gjf.healthmanager.healthrecord.medical_mxamination_report.activity.AddMedicalExaminationReportContractActivity;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by BlackBeard丶 on 2017/04/10.
 */

public class MedicalExaminationReportPresenter implements MedicalExaminationReportContract.Presenter {

    private MedicalExaminationReportContract.View view;
    AddMedicalExaminationReportContractActivity addMedicalExaminationReportContractActivity;

    @Override
    public void start() {
    }

    public MedicalExaminationReportPresenter(MedicalExaminationReportContract.View addview) {
             view = addview;
    }



    @Override
    public void ShowAddMedicalExaminationReportContractActivit() {
        addMedicalExaminationReportContractActivity = new AddMedicalExaminationReportContractActivity();
        view.SwitchActivity(addMedicalExaminationReportContractActivity.getClass());
    }



    @Override
    public void SearchAllMedicalExaminationReport() {
        List<MedicalExaminationReport> list = MedicalExaminationReport.findAll(MedicalExaminationReport.class);
        view.ShowAllMedicalExaminationReport(list);
    }

    @Override
    public void EditMedicalExaminationReportContract( ContentValues valuesen,Long id) {
        DataSupport.update(MedicalExaminationReport.class, valuesen, id);
    }

    @Override
    public void DeleteMedicalExaminationReportContract(Long id) {
        DataSupport.delete(MedicalExaminationReport.class, id);
    }

    @Override
    public void ShowMedicalExaminationReport() {
     view.ShowMedicalExaminationReport();
    }
}

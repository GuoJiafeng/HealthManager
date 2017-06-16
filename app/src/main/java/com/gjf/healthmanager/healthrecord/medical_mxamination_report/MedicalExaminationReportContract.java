package com.gjf.healthmanager.healthrecord.medical_mxamination_report;

import android.content.ContentValues;

import com.gjf.healthmanager.BasePresenter;
import com.gjf.healthmanager.BaseView;
import com.gjf.healthmanager.MainContract;
import com.gjf.healthmanager.entiy.MedicalExaminationReport;

import java.util.List;

/**
 * Created by BlackBeard丶 on 2017/04/10.
 */

public interface MedicalExaminationReportContract {
    interface View extends BaseView<MainContract.Presenter> {
        void SwitchActivity(Class c);
        void ShowAllMedicalExaminationReport(List<MedicalExaminationReport> list);
        void ShowMedicalExaminationReport();


    }

    interface  Presenter extends BasePresenter {
        void ShowAddMedicalExaminationReportContractActivit();
        void SearchAllMedicalExaminationReport();
        void EditMedicalExaminationReportContract(ContentValues valuesen,Long id);
        void DeleteMedicalExaminationReportContract(Long id);
        void ShowMedicalExaminationReport();


    }
}

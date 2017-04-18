package com.gjf.healthmanager.healthrecord;

import com.gjf.healthmanager.healthrecord.health_log.HealthLogFragment;
import com.gjf.healthmanager.healthrecord.medical_mxamination_report.MedicalExaminationReportFragment;
import com.gjf.healthmanager.healthrecord.medical_records.MedicalRecordsFragment;
import com.gjf.healthmanager.healthrecord.questionnaire_investigation.QuestionnaireInvestigationFragment;

/**
 * Created by BlackBeard丶 on 2017/04/10.
 */

public class HeathRecordPresenter implements HeathRecordContract.Presenter {

    HeathRecordContract.View hearhRecordView;

    HealthLogFragment healthLogFragment;
    MedicalExaminationReportFragment medicalExaminationReportFragment;
    MedicalRecordsFragment medicalRecordsFragment;
    QuestionnaireInvestigationFragment questionnaireInvestigationFragment;
    public HeathRecordPresenter(HeathRecordContract.View hearhRecordView){
        this.hearhRecordView = hearhRecordView;
    }


    @Override
    public void start() {

    }



    @Override
    public void setShowHealthLogFragment() {
        healthLogFragment = new HealthLogFragment();
        hearhRecordView.showFragmen(healthLogFragment);

    }

    @Override
    public void setShowMedicalMxaminationReport() {
        medicalExaminationReportFragment = new MedicalExaminationReportFragment();
        hearhRecordView.showFragmen(medicalExaminationReportFragment);

    }

    @Override
    public void setShowMedicalRecords() {
        medicalRecordsFragment = new MedicalRecordsFragment();
        hearhRecordView.showFragmen(medicalRecordsFragment);

    }

    @Override
    public void setShowQuestionnairInvestigationFragment() {
        questionnaireInvestigationFragment = new QuestionnaireInvestigationFragment();
        hearhRecordView.showFragmen(questionnaireInvestigationFragment);

    }
}

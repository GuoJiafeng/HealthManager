package com.gjf.healthmanager.healthrecord.medical_records.activity;

import com.gjf.healthmanager.BasePresenter;
import com.gjf.healthmanager.BaseView;

/**
 * Created by BlackBeard丶 on 2017/6/18.
 */

public interface AddMedicalRecordsContract {

    interface View extends BaseView {
        void ShowToast(String msg);
    }

    interface Presenter extends BasePresenter {
        void AddMedicalExaminationReportContract(String jibingmingcheng ,String qishiriqi,String quanyuriqi,String yongyaojilv, String bingqingmioashu );

    }

}

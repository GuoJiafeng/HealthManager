package com.gjf.healthmanager.healthrecord.medical_mxamination_report.activity;

import com.gjf.healthmanager.BasePresenter;
import com.gjf.healthmanager.BaseView;

/**
 * Created by BlackBeard丶 on 2017/6/16.
 */

public interface AddMedicalExaminationReportContractActivitContract {
    interface  View extends BaseView{
        void ShowToast(String msg);


    }
    interface   Presenter extends BasePresenter{
        void AddMedicalExaminationReportContract(String shengao ,String tizhong,String shili,String xinlv, String xueya,String xuetang,String xuezhi,String waikeyichang,String neikeyichang,String xuechangguiyichang );

    }
}

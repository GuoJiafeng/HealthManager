package com.gjf.healthmanager.healthrecord;

import android.app.Fragment;

import com.gjf.healthmanager.BasePresenter;
import com.gjf.healthmanager.BaseView;
import com.gjf.healthmanager.MainContract;

/**
 * Created by BlackBeard丶 on 2017/04/10.
 */

public interface HeathRecordContract {
    interface View extends BaseView<MainContract.Presenter> {
        void showFragmen(Fragment fragment);

    }

    interface  Presenter extends BasePresenter {
        void setShowHealthLogFragment();
        void setShowMedicalMxaminationReport();
        void setShowMedicalRecords();
        void setShowQuestionnairInvestigationFragment();

    }
}

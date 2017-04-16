package com.gjf.healthmanager;

import android.app.Fragment;

/**
 * Created by BlackBeard丶 on 2017/04/10.
 */

public interface MainContract {
interface View extends   BaseView<Presenter>{
    void ShowFragment(Fragment fragment,String msg);

    }

    interface  Presenter extends BasePresenter{
        void setDefaultFragment();
        void setHealthAnalysisFragment();
        void setHeathrecordFragment();
        void setLifeAssistantFragment();
        void setOnlinSearcherFragment();
        void setSystemSettingFragment();
        void setTestToolFragment();

    }
}

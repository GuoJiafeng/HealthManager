package com.gjf.healthmanager.healthrecord;

import com.gjf.healthmanager.BasePresenter;
import com.gjf.healthmanager.BaseView;
import com.gjf.healthmanager.MainContract;

/**
 * Created by BlackBeard丶 on 2017/04/10.
 */

public interface HeathRecordContract {
    interface View extends BaseView<MainContract.Presenter> {

    }

    interface  Presenter extends BasePresenter {

    }
}

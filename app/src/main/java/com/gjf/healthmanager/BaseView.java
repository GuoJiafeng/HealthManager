package com.gjf.healthmanager;

/**
 * Created by BlackBeard丶 on 2017/04/10.
 */

public interface  BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}

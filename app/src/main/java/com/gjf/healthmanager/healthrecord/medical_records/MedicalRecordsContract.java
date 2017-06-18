package com.gjf.healthmanager.healthrecord.medical_records;

import android.content.ContentValues;

import com.gjf.healthmanager.BasePresenter;
import com.gjf.healthmanager.BaseView;
import com.gjf.healthmanager.entiy.MedicalRecords;

import java.util.List;

/**
 * Created by BlackBeard丶 on 2017/04/10.
 */

public interface MedicalRecordsContract {

    interface View extends BaseView{

        void SwitchActivity(Class c);
        void ShowAllMedicalRecord(List<MedicalRecords> list);
        void ShowMedicalRecord();


    }

    interface Presenter extends BasePresenter {
        void SwitchToAddMedicalRecordsActivity();
        void GetAllMedicalRecord();
        void DeleteMedicalRecord(Long id);
        void EditMedicalRecord(ContentValues valuesen, Long id);
        void GetMedicalRecord();
    }

}

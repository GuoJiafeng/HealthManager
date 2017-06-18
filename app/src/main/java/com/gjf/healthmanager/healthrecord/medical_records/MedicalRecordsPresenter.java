package com.gjf.healthmanager.healthrecord.medical_records;

import android.content.ContentValues;

import com.gjf.healthmanager.entiy.MedicalRecords;
import com.gjf.healthmanager.healthrecord.medical_records.activity.AddMedicalRecordsActivity;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by BlackBeard丶 on 2017/04/10.
 */

public class MedicalRecordsPresenter implements MedicalRecordsContract.Presenter {
    AddMedicalRecordsActivity addMedicalRecordsActivity;

    MedicalRecordsContract.View view;


    @Override
    public void start() {

    }

    public MedicalRecordsPresenter(MedicalRecordsContract.View view) {
        this.view = view;
    }

    @Override
    public void SwitchToAddMedicalRecordsActivity() {
        addMedicalRecordsActivity = new AddMedicalRecordsActivity();
        view.SwitchActivity(addMedicalRecordsActivity.getClass());

    }

    @Override
    public void GetAllMedicalRecord() {
        List<MedicalRecords> medicalRecordses = MedicalRecords.findAll(MedicalRecords.class);
        view.ShowAllMedicalRecord(medicalRecordses);
    }

    @Override
    public void DeleteMedicalRecord(Long id) {
        DataSupport.delete(MedicalRecords.class,id);
    }

    @Override
    public void EditMedicalRecord(ContentValues valuesen, Long id) {
        DataSupport.update(MedicalRecords.class, valuesen, id);
    }

    @Override
    public void GetMedicalRecord() {
        view.ShowMedicalRecord();
    }
}

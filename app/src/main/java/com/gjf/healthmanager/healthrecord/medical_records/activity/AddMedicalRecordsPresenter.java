package com.gjf.healthmanager.healthrecord.medical_records.activity;

import android.database.sqlite.SQLiteDatabase;

import com.gjf.healthmanager.entiy.MedicalRecords;

import org.litepal.tablemanager.Connector;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by BlackBeard丶 on 2017/6/18.
 */

public class AddMedicalRecordsPresenter implements AddMedicalRecordsContract.Presenter {
    private  MedicalRecords medicalRecords;
    private AddMedicalRecordsContract.View view;
    public AddMedicalRecordsPresenter(AddMedicalRecordsContract.View view) {
    this.view = view;
    }

    @Override
    public void start() {
    }

    @Override
    public void AddMedicalExaminationReportContract(String jibingmingcheng, String qishiriqi, String quanyuriqi, String yongyaojilv, String bingqingmioashu) {
        SQLiteDatabase db = Connector.getDatabase();
        medicalRecords = new MedicalRecords();
        medicalRecords.setJibingmingcheng(jibingmingcheng.toString());
        medicalRecords.setQishiriqi(qishiriqi.toString());
        medicalRecords.setQuanyuriqi(quanyuriqi.toString());
        medicalRecords.setYongyaojilv(yongyaojilv.toString());
        medicalRecords.setBingqingmiaoshu(bingqingmioashu.toString());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");
        String str=sdf.format(new Date());
        medicalRecords.setPublishdate(str.toString());
        medicalRecords.save();
        if (medicalRecords.save()){
            String msg ="存储成功！";
                    view.ShowToast(msg);
        }else {
            String msg ="存储失败！";
            view.ShowToast(msg);
        }
    }
}

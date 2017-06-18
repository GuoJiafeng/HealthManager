package com.gjf.healthmanager.healthrecord.medical_mxamination_report.activity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.gjf.healthmanager.entiy.MedicalExaminationReport;

import org.litepal.tablemanager.Connector;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by BlackBeard丶 on 2017/6/16.
 */

public class AddMedicalExaminationReportContractActivitPresenter implements AddMedicalExaminationReportContractActivitContract.Presenter{
   private  AddMedicalExaminationReportContractActivitContract.View view;
    private MedicalExaminationReport medicalExaminationReport;
    private Context context;


    public AddMedicalExaminationReportContractActivitPresenter(AddMedicalExaminationReportContractActivitContract.View mView, Context mContext) {
        this.view = mView;
        this.context = mContext;


    }

    @Override
    public void start() {

    }


    @Override
    public void AddMedicalExaminationReportContract(String shengao, String tizhong, String shili, String xinlv, String xueya, String xuetang, String xuezhi, String waikeyichang, String neikeyichang, String xuechangguiyichang) {
        SQLiteDatabase db = Connector.getDatabase();
        medicalExaminationReport  = new MedicalExaminationReport();
        medicalExaminationReport.setShenGao(shengao.toString());
        medicalExaminationReport.setTiZhong(tizhong.toString());
        medicalExaminationReport.setShiLi(shili.toString());
        medicalExaminationReport.setXinLv(xinlv.toString());
        medicalExaminationReport.setXueYa(xueya.toString());
        medicalExaminationReport.setXueTang(xuetang.toString());
        medicalExaminationReport.setXueZhi(xuezhi.toString());
        medicalExaminationReport.setNeiKeYiChang(neikeyichang.toString());
        medicalExaminationReport.setWaiKeYiChang(waikeyichang.toString());
        medicalExaminationReport.setXueChangGuiYiChang(xuechangguiyichang.toString());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");
        String str=sdf.format(new Date());
       medicalExaminationReport.setPublishdate(str.toString());
        medicalExaminationReport.save();
        if ( medicalExaminationReport.save()){
            String msg  = "存储成功！";
            view.ShowToast(msg);
        }else {
            String msg  = "存储失败！";
            view.ShowToast(msg);
        }



    }
}

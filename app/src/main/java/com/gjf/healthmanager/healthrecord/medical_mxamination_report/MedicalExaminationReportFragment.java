package com.gjf.healthmanager.healthrecord.medical_mxamination_report;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.gjf.healthmanager.BasePresenter;
import com.gjf.healthmanager.R;
import com.gjf.healthmanager.entiy.MedicalExaminationReport;
import com.gjf.healthmanager.healthrecord.medical_mxamination_report.activity.AddMedicalExaminationReportContractActivitPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by BlackBeard丶 on 2017/04/10.
 */

public class MedicalExaminationReportFragment extends Fragment implements MedicalExaminationReportContract.View {
    EditText healthRecordFragmentMedicalMxaminationReportEditShengao;
    EditText healthRecordFragmentMedicalMxaminationReportEditTizhong;
    EditText healthRecordFragmentMedicalMxaminationReportEditShili;
    EditText healthRecordFragmentMedicalMxaminationReportEditXinlv;
    EditText healthRecordFragmentMedicalMxaminationReportEditXueya;
    EditText healthRecordFragmentMedicalMxaminationReportEditXuetang;
    EditText healthRecordFragmentMedicalMxaminationReportEditXuezhi;
    EditText healthRecordFragmentMedicalMxaminationReportEditWaikeyichang;
    EditText healthRecordFragmentMedicalMxaminationReportEditNeikeyichang;
    EditText healthRecordFragmentMedicalMxaminationReportEditXuechangguiyichang;
    LinearLayout healthRecordFragmentMedicalMxaminationReportEditLayout;
    @BindView(R.id.health_record_fragment_medical_mxamination_report_add_bn)
    Button healthRecordFragmentMedicalMxaminationReportAddBn;
    @BindView(R.id.health_record_fragment_medical_mxamination_report_listview)
    ListView healthRecordFragmentMedicalMxaminationReportListview;
    private MedicalExaminationReportPresenter medicalExaminationReportPresenter;
    private AddMedicalExaminationReportContractActivitPresenter addMedicalExaminationReportContractActivitPresenter;
    Unbinder unbinder;
    private View view;

    private String shengao;
    private String TiZhong;
    private String ShiLi;
    private String XinLv;
    private String XueYa;
    private String XueTang;
    private String XueZhi;
    private String WaiKeYiChang;
    private String NeiKeYiChang;
    private String XueChangGuiYiChang;
    private int Id;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.health_record_fragment_medical_mxamination_report, container, false);
            medicalExaminationReportPresenter = new MedicalExaminationReportPresenter(this);


        } else {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);

            }
        }

        medicalExaminationReportPresenter.SearchAllMedicalExaminationReport();
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void SwitchActivity(Class c) {
        Intent intent = new Intent(getContext(), c);
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void ShowAllMedicalExaminationReport(List<MedicalExaminationReport> list) {
        List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
        for (MedicalExaminationReport listall : list) {
            HashMap<String, Object> item = new HashMap<String, Object>();
            item.put("id", listall.getId());
            item.put("ShenGao", listall.getShenGao());
            item.put("TiZhong", listall.getTiZhong());
            item.put("ShiLi", listall.getShiLi());
            item.put("XinLv", listall.getXinLv());
            item.put("XueYa", listall.getXueYa());
            item.put("XueTang", listall.getXueTang());
            item.put("XueZhi", listall.getXueZhi());
            item.put("WaiKeYiChang", listall.getWaiKeYiChang());
            item.put("NeiKeYiChang", listall.getNeiKeYiChang());
            item.put("XueChangGuiYiChang", listall.getXueChangGuiYiChang());
            item.put("publishdate", listall.getPublishdate());
            data.add(item);
        }

        //创建SimpleAdapter适配器Da将数据绑定到item显示控件上
        SimpleAdapter adapter = new SimpleAdapter(getContext(), data, R.layout.health_record_fragment_medical_mxamination_report_item,
                new String[]{"id", "publishdate"}, new int[]{R.id.health_record_fragment_medical_mxamination_report_id, R.id.health_record_fragment_medical_mxamination_report_shijian});
        //实现列表的显示
        ListView listView = (ListView) view.findViewById(R.id.health_record_fragment_medical_mxamination_report_listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new ItemClick());
    }


    @OnClick(R.id.health_record_fragment_medical_mxamination_report_add_bn)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.health_record_fragment_medical_mxamination_report_add_bn:
                medicalExaminationReportPresenter.ShowAddMedicalExaminationReportContractActivit();
        }
    }



    @Override
    public void setPresenter(BasePresenter presenter) {

    }

    class ItemClick implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ListView listView = (ListView) parent;
            HashMap<String, Object> data = (HashMap<String, Object>) listView.getItemAtPosition(position);
            Id = (int) Long.parseLong(data.get("id").toString());
            shengao = data.get("ShenGao").toString();
            TiZhong = data.get("TiZhong").toString();
            ShiLi = data.get("ShiLi").toString();
            XinLv = data.get("XinLv").toString();
            XueYa = data.get("XueYa").toString();
            XueTang = data.get("XueTang").toString();
            XueZhi = data.get("XueZhi").toString();
            WaiKeYiChang = data.get("WaiKeYiChang").toString();
            NeiKeYiChang = data.get("NeiKeYiChang").toString();
            XueChangGuiYiChang = data.get("XueChangGuiYiChang").toString();

            medicalExaminationReportPresenter.ShowMedicalExaminationReport();
        }
    }

    @Override
    public void ShowMedicalExaminationReport() {


        new AlertDialog.Builder(getActivity()).setMessage("选项")
                .setPositiveButton("编辑", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LayoutInflater inflater = getActivity().getLayoutInflater();
                        final View layout = inflater.inflate(R.layout.health_record_fragment_medical_mxamination_report_edit, (ViewGroup) view.findViewById(R.id.health_record_fragment_medical_mxamination_report_edit_layout));

                        healthRecordFragmentMedicalMxaminationReportEditShengao  = (EditText)layout.findViewById(R.id.health_record_fragment_medical_mxamination_report_edit_shengao) ;
                        healthRecordFragmentMedicalMxaminationReportEditTizhong = (EditText)layout.findViewById(R.id.health_record_fragment_medical_mxamination_report_edit_tizhong);
                        healthRecordFragmentMedicalMxaminationReportEditShili = (EditText)layout.findViewById(R.id.health_record_fragment_medical_mxamination_report_edit_shili);
                        healthRecordFragmentMedicalMxaminationReportEditXinlv = (EditText)layout.findViewById(R.id.health_record_fragment_medical_mxamination_report_edit_xinlv);
                        healthRecordFragmentMedicalMxaminationReportEditXueya = (EditText)layout.findViewById(R.id.health_record_fragment_medical_mxamination_report_edit_xueya);
                        healthRecordFragmentMedicalMxaminationReportEditXuetang = (EditText)layout.findViewById(R.id.health_record_fragment_medical_mxamination_report_edit_xuetang);
                        healthRecordFragmentMedicalMxaminationReportEditXuezhi = (EditText)layout.findViewById(R.id.health_record_fragment_medical_mxamination_report_edit_xuezhi);
                        healthRecordFragmentMedicalMxaminationReportEditWaikeyichang = (EditText)layout.findViewById(R.id.health_record_fragment_medical_mxamination_report_edit_waikeyichang);
                        healthRecordFragmentMedicalMxaminationReportEditNeikeyichang = (EditText)layout.findViewById(R.id.health_record_fragment_medical_mxamination_report_edit_neikeyichang);
                        healthRecordFragmentMedicalMxaminationReportEditXuechangguiyichang = (EditText)layout.findViewById(R.id.health_record_fragment_medical_mxamination_report_edit_xuechangguiyichang);


                        healthRecordFragmentMedicalMxaminationReportEditShengao.setText(shengao);
                        healthRecordFragmentMedicalMxaminationReportEditTizhong.setText(TiZhong);
                        healthRecordFragmentMedicalMxaminationReportEditShili.setText(ShiLi);
                        healthRecordFragmentMedicalMxaminationReportEditXinlv.setText(XinLv);
                        healthRecordFragmentMedicalMxaminationReportEditXueya.setText(XueYa);
                        healthRecordFragmentMedicalMxaminationReportEditXuetang.setText(XueTang);
                        healthRecordFragmentMedicalMxaminationReportEditXuezhi.setText(XueZhi);
                        healthRecordFragmentMedicalMxaminationReportEditWaikeyichang.setText(WaiKeYiChang);
                        healthRecordFragmentMedicalMxaminationReportEditNeikeyichang.setText(NeiKeYiChang);
                        healthRecordFragmentMedicalMxaminationReportEditXuechangguiyichang.setText(XueChangGuiYiChang);
                        new AlertDialog.Builder(getActivity()).setMessage("请输入修改内容:").setView(layout).setPositiveButton("保存", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ContentValues values1 = new ContentValues();
                                values1.put("ShenGao", healthRecordFragmentMedicalMxaminationReportEditShengao.getText().toString());
                                medicalExaminationReportPresenter.EditMedicalExaminationReportContract(values1, (long) Id);
                                ContentValues values2 = new ContentValues();
                                values1.put("TiZhong", healthRecordFragmentMedicalMxaminationReportEditTizhong.getText().toString());
                                medicalExaminationReportPresenter.EditMedicalExaminationReportContract(values2, (long) Id);
                                ContentValues values3 = new ContentValues();
                                values1.put("ShiLi", healthRecordFragmentMedicalMxaminationReportEditShili.getText().toString());
                                medicalExaminationReportPresenter.EditMedicalExaminationReportContract(values3, (long) Id);
                                ContentValues values4 = new ContentValues();
                                values1.put("XinLv", healthRecordFragmentMedicalMxaminationReportEditXinlv.getText().toString());
                                medicalExaminationReportPresenter.EditMedicalExaminationReportContract(values4, (long) Id);
                                ContentValues values5 = new ContentValues();
                                values1.put("XueTang", healthRecordFragmentMedicalMxaminationReportEditXuetang.getText().toString());
                                medicalExaminationReportPresenter.EditMedicalExaminationReportContract(values5, (long) Id);
                                ContentValues values6 = new ContentValues();
                                values1.put("XueZhi", healthRecordFragmentMedicalMxaminationReportEditXuezhi.getText().toString());
                                medicalExaminationReportPresenter.EditMedicalExaminationReportContract(values6, (long) Id);
                                ContentValues values7 = new ContentValues();
                                values1.put("WaiKeYiChang", healthRecordFragmentMedicalMxaminationReportEditWaikeyichang.getText().toString());
                                medicalExaminationReportPresenter.EditMedicalExaminationReportContract(values7, (long) Id);
                                ContentValues values8 = new ContentValues();
                                values1.put("NeiKeYiChang", healthRecordFragmentMedicalMxaminationReportEditNeikeyichang.getText().toString());
                                medicalExaminationReportPresenter.EditMedicalExaminationReportContract(values8, (long) Id);
                                ContentValues values9 = new ContentValues();
                                values1.put("XueYa", healthRecordFragmentMedicalMxaminationReportEditXueya.getText().toString());
                                medicalExaminationReportPresenter.EditMedicalExaminationReportContract(values9, (long) Id);
                                ContentValues values10 = new ContentValues();
                                values1.put("XueChangGuiYiChang", healthRecordFragmentMedicalMxaminationReportEditXuechangguiyichang.getText().toString());
                                medicalExaminationReportPresenter.EditMedicalExaminationReportContract(values10, (long) Id);


                                medicalExaminationReportPresenter.SearchAllMedicalExaminationReport();
                            }
                        }).setNegativeButton("取消", null).show();

                    }
                }).setNegativeButton("删除", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new AlertDialog.Builder(getActivity()).setMessage("真的要删除吗？").setNegativeButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        medicalExaminationReportPresenter.DeleteMedicalExaminationReportContract((long) Id);
                        medicalExaminationReportPresenter.SearchAllMedicalExaminationReport();
                    }
                }).setPositiveButton("否",null).show();


            }
        }).show();
    }
}
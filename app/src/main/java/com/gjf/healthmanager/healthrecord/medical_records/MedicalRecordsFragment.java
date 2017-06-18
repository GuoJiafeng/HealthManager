package com.gjf.healthmanager.healthrecord.medical_records;

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
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.gjf.healthmanager.BasePresenter;
import com.gjf.healthmanager.R;
import com.gjf.healthmanager.entiy.MedicalRecords;

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

public class MedicalRecordsFragment extends Fragment implements MedicalRecordsContract.View {
    @BindView(R.id.health_record_fragment_medical_records_add_bn)
    Button healthRecordFragmentMedicalRecordsAddBn;
    @BindView(R.id.health_record_fragment_medical_records_listview)
    ListView healthRecordFragmentMedicalRecordsListview;
    Unbinder unbinder;
    MedicalRecordsPresenter medicalRecordsPresenter;
    private View view;
    private int Id;
    private String jibingmingcheng;
    private String qishiriqi;
    private String quanyuriqi;
    private String yongyaojilv;
    private String bingqingmiaoshu;
    public String publishdate;
    EditText edit_jibingmingcheng;
    EditText edit_qishiriqi;
    EditText edit_quanyuriqi;
    EditText edit_yongyaojilv;
    EditText edit_bingqingmiaoshu;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.health_record_fragment_medical_records, container, false);
               medicalRecordsPresenter = new MedicalRecordsPresenter(this);
               medicalRecordsPresenter.GetAllMedicalRecord();
        } else {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void setPresenter(BasePresenter presenter) {

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void SwitchActivity(Class c) {
        Intent intent = new Intent(getContext(), c);
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void ShowAllMedicalRecord(List<MedicalRecords> list) {
        List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
        for (MedicalRecords listall : list) {
            HashMap<String, Object> item = new HashMap<String, Object>();
            item.put("id", listall.getId());
            item.put("jibingmingcheng", listall.getJibingmingcheng());
            item.put("qishiriqi", listall.getQishiriqi());
            item.put("quanyuriqi", listall.getQuanyuriqi());
            item.put("yongyaojilv", listall.getYongyaojilv());
            item.put("bingqingmiaoshu", listall.getBingqingmiaoshu());
            item.put("publishdate", listall.getPublishdate());
            data.add(item);
        }

        //创建SimpleAdapter适配器Da将数据绑定到item显示控件上
        SimpleAdapter adapter = new SimpleAdapter(getContext(), data, R.layout.health_record_fragment_medical_mxamination_report_item,
                new String[]{"id", "publishdate"}, new int[]{R.id.health_record_fragment_medical_mxamination_report_id, R.id.health_record_fragment_medical_mxamination_report_shijian});
        //实现列表的显示
        ListView listView = (ListView) view.findViewById(R.id.health_record_fragment_medical_records_listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new ItemClick());
    }


    class ItemClick implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            ListView listView = (ListView) parent;
            HashMap<String, Object> data = (HashMap<String, Object>) listView.getItemAtPosition(position);
            Id = (int) Long.parseLong(data.get("id").toString());
           jibingmingcheng = data.get("jibingmingcheng").toString();
            qishiriqi = data.get("qishiriqi").toString();
            quanyuriqi = data.get("quanyuriqi").toString();
            yongyaojilv = data.get("yongyaojilv").toString();
            bingqingmiaoshu = data.get("bingqingmiaoshu").toString();
            publishdate = data.get("publishdate").toString();
            medicalRecordsPresenter.GetMedicalRecord();
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.health_record_fragment_medical_records_add_bn)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.health_record_fragment_medical_records_add_bn:
                medicalRecordsPresenter.SwitchToAddMedicalRecordsActivity();
                break;
        }
    }

    @Override
    public void ShowMedicalRecord() {

        new AlertDialog.Builder(getActivity()).setMessage("选项")
                .setPositiveButton("编辑", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LayoutInflater inflater = getActivity().getLayoutInflater();
                        final View layout = inflater.inflate(R.layout.health_record_fragment_medical_records_edit, (ViewGroup) view.findViewById(R.id.health_record_fragment_medical_records_edit_layout));

                        edit_jibingmingcheng  = (EditText)layout.findViewById(R.id.health_record_fragment_medical_records_edit_jibingmingcheng) ;
                        edit_qishiriqi = (EditText)layout.findViewById(R.id.health_record_fragment_medical_records_edit_qishishijian);
                        edit_quanyuriqi = (EditText)layout.findViewById(R.id.health_record_fragment_medical_records_edit_quanyushijian);
                        edit_yongyaojilv = (EditText)layout.findViewById(R.id.health_record_fragment_medical_records_edit_yongyaojilu);
                        edit_bingqingmiaoshu = (EditText)layout.findViewById(R.id.health_record_fragment_medical_records_edit_miaoshubingqing);

                        edit_jibingmingcheng.setText(jibingmingcheng);
                        edit_qishiriqi.setText(qishiriqi);
                        edit_quanyuriqi.setText(quanyuriqi);
                        edit_yongyaojilv.setText(yongyaojilv);
                        edit_bingqingmiaoshu.setText(bingqingmiaoshu);

                        new AlertDialog.Builder(getActivity()).setMessage("请输入修改内容:").setView(layout).setPositiveButton("保存", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                               ContentValues values1 = new ContentValues();
                                values1.put("jibingmingcheng", edit_jibingmingcheng.getText().toString());
                                medicalRecordsPresenter.EditMedicalRecord(values1, (long) Id);
                                ContentValues values2 = new ContentValues();
                                values2.put("qishiriqi", edit_qishiriqi.getText().toString());
                                medicalRecordsPresenter.EditMedicalRecord(values2, (long) Id);
                                ContentValues values3 = new ContentValues();
                                values3.put("quanyuriqi", edit_quanyuriqi.getText().toString());
                                medicalRecordsPresenter.EditMedicalRecord(values3, (long) Id);
                                ContentValues values4 = new ContentValues();
                                values4.put("yongyaojilv", edit_yongyaojilv.getText().toString());
                                medicalRecordsPresenter.EditMedicalRecord(values4, (long) Id);
                                ContentValues values5 = new ContentValues();
                                values5.put("bingqingmiaoshu", edit_bingqingmiaoshu.getText().toString());
                                medicalRecordsPresenter.EditMedicalRecord(values5, (long) Id);

                                medicalRecordsPresenter.GetAllMedicalRecord();
                            }
                        }).setNegativeButton("取消", null).show();

                    }
                }).setNegativeButton("删除", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new AlertDialog.Builder(getActivity()).setMessage("真的要删除吗？").setNegativeButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        medicalRecordsPresenter.DeleteMedicalRecord((long) Id);
                       medicalRecordsPresenter.GetAllMedicalRecord();
                    }
                }).setPositiveButton("否",null).show();


            }
        }).show();
    }



}
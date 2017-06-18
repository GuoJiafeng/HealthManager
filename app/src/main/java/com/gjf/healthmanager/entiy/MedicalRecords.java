package com.gjf.healthmanager.entiy;

import org.litepal.crud.DataSupport;

/**
 * Created by BlackBeard丶 on 2017/6/18.
 */

public class MedicalRecords extends DataSupport {
    private int id;
    private String jibingmingcheng;
    private String qishiriqi;
    private String quanyuriqi;
    private String yongyaojilv;
    private String bingqingmiaoshu;
    public String publishdate;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJibingmingcheng() {
        return jibingmingcheng;
    }

    public void setJibingmingcheng(String jibingmingcheng) {
        this.jibingmingcheng = jibingmingcheng;
    }

    public String getQishiriqi() {
        return qishiriqi;
    }

    public void setQishiriqi(String qishiriqi) {
        this.qishiriqi = qishiriqi;
    }

    public String getQuanyuriqi() {
        return quanyuriqi;
    }

    public void setQuanyuriqi(String quanyuriqi) {
        this.quanyuriqi = quanyuriqi;
    }

    public String getYongyaojilv() {
        return yongyaojilv;
    }

    public void setYongyaojilv(String yongyaojilv) {
        this.yongyaojilv = yongyaojilv;
    }

    public String getBingqingmiaoshu() {
        return bingqingmiaoshu;
    }

    public void setBingqingmiaoshu(String bingqingmiaoshu) {
        this.bingqingmiaoshu = bingqingmiaoshu;
    }
    public String getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate;
    }

}

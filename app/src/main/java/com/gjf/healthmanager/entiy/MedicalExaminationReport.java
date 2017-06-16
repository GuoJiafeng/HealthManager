package com.gjf.healthmanager.entiy;

import org.litepal.crud.DataSupport;

/**
 * Created by BlackBeard丶 on 2017/6/16.
 */

public class MedicalExaminationReport extends DataSupport {


    private int id;

    private  String ShenGao;
    private String TiZhong;
    private String ShiLi;
    private String XinLv;
    private String XueYa;
    private String XueTang;
    private String XueZhi;
    private String WaiKeYiChang;
    private String NeiKeYiChang;
    private String XueChangGuiYiChang;

    public String getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate;
    }

    private String  publishdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShenGao() {
        return ShenGao;
    }

    public void setShenGao(String shenGao) {
        ShenGao = shenGao;
    }

    public String getTiZhong() {
        return TiZhong;
    }

    public void setTiZhong(String tiZhong) {
        TiZhong = tiZhong;
    }

    public String getShiLi() {
        return ShiLi;
    }

    public void setShiLi(String shiLi) {
        ShiLi = shiLi;
    }

    public String getXinLv() {
        return XinLv;
    }

    public void setXinLv(String xinLv) {
        XinLv = xinLv;
    }

    public String getXueYa() {
        return XueYa;
    }

    public void setXueYa(String xueYa) {
        XueYa = xueYa;
    }

    public String getXueTang() {
        return XueTang;
    }

    public void setXueTang(String xueTang) {
        XueTang = xueTang;
    }

    public String getXueZhi() {
        return XueZhi;
    }

    public void setXueZhi(String xueZhi) {
        XueZhi = xueZhi;
    }

    public String getWaiKeYiChang() {
        return WaiKeYiChang;
    }

    public void setWaiKeYiChang(String waiKeYiChang) {
        WaiKeYiChang = waiKeYiChang;
    }

    public String getNeiKeYiChang() {
        return NeiKeYiChang;
    }

    public void setNeiKeYiChang(String neiKeYiChang) {
        NeiKeYiChang = neiKeYiChang;
    }

    public String getXueChangGuiYiChang() {
        return XueChangGuiYiChang;
    }

    public void setXueChangGuiYiChang(String xueChangGuiYiChang) {
        XueChangGuiYiChang = xueChangGuiYiChang;
    }


}

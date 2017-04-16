package com.gjf.healthmanager;

import com.gjf.healthmanager.healthanalysis.HealthAnalysisFragment;
import com.gjf.healthmanager.healthrecord.HeathRecordFragment;
import com.gjf.healthmanager.lifeassistant.LifeAssistantFragment;
import com.gjf.healthmanager.lifeassistant.health_reminder.HealthReminderFragment;
import com.gjf.healthmanager.onlinesearch.OnlinSearcherFragment;
import com.gjf.healthmanager.systemsetting.SystemSettingFragment;
import com.gjf.healthmanager.testtool.TestToolFragment;

/**
 * Created by BlackBeard丶 on 2017/04/10.
 */

public class MainPresenter implements MainContract.Presenter{
  private MainContract.View mainContract;
    private HealthReminderFragment healthReminderFragment;

    HeathRecordFragment heathRecordFragment;
    HealthAnalysisFragment healthAnalysisFragment;
    LifeAssistantFragment lifeAssistantFragment;
    OnlinSearcherFragment onlinSearcherFragment;
    SystemSettingFragment systemSettingFragment;
    TestToolFragment testToolFragment;
    MainActivity mainActivity;


    @Override
    public void start() {

    }

    public MainPresenter( MainContract.View addView){
       mainContract = addView;

    }

    @Override
    public void setDefaultFragment() {
      heathRecordFragment = new HeathRecordFragment();
      mainContract.ShowFragment(heathRecordFragment,"健康档案");


    }

    @Override
    public void setHealthAnalysisFragment() {
      healthAnalysisFragment =new HealthAnalysisFragment();
      mainContract.ShowFragment(healthAnalysisFragment,"健康分析");

    }

    @Override
    public void setHeathrecordFragment() {
      heathRecordFragment = new HeathRecordFragment();
      mainContract.ShowFragment(heathRecordFragment,"健康档案");

    }

    @Override
    public void setLifeAssistantFragment() {
       lifeAssistantFragment = new LifeAssistantFragment();
       mainContract.ShowFragment(lifeAssistantFragment,"生活助手");
    }

    @Override
    public void setOnlinSearcherFragment() {
        onlinSearcherFragment =new OnlinSearcherFragment();
        mainContract.ShowFragment(onlinSearcherFragment,"在线查询");
    }

    @Override
    public void setSystemSettingFragment() {
        systemSettingFragment = new SystemSettingFragment();
      mainContract.ShowFragment(systemSettingFragment,"系统设置");
    }

    @Override
    public void setTestToolFragment() {
      testToolFragment = new TestToolFragment();
       mainContract.ShowFragment(testToolFragment,"测试工具");

    }
}

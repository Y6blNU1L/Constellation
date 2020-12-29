package com.hba.xmy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.google.gson.Gson;
import com.hba.xmy.bean.StarBean;
import com.hba.xmy.luckfrag.LuckFragment;
import com.hba.xmy.mefrag.MeFragment;
import com.hba.xmy.parnterfrag.PartnerFragment;
import com.hba.xmy.starfrag.StarFragment;
import com.hba.xmy.utils.AssetsUtils;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    RadioGroup mainRg;
//    声明四个Fragment对象
    Fragment starFrag,luckFrag,partnerFrag,meFrag;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainRg=findViewById(R.id.main_rg);
//        设置点击监听
        mainRg.setOnCheckedChangeListener(this);

        //加载相关数据
        StarBean startInfoBean = loadData();
        Bundle bundle = new Bundle();
        bundle.putSerializable("info",startInfoBean);
        //创建对象
        starFrag=new StarFragment();
        starFrag.setArguments(bundle);
        partnerFrag=new PartnerFragment();
        partnerFrag.setArguments(bundle);
        luckFrag=new LuckFragment();
        luckFrag.setArguments(bundle);
        meFrag=new MeFragment();
        meFrag.setArguments(bundle);
//        Fragment动态加载 add/hide/show
        addFragment();

    }

    //读取assets文件夹下的文件
    private StarBean loadData() {
        String json = AssetsUtils.getJsonFromAssets(this, "xzcontent/xzcontent.json");
        Gson gson = new Gson();
        StarBean infoBean = gson.fromJson(json, StarBean.class);
        AssetsUtils.saveBitmapFromAssets(this,infoBean);
        return infoBean;
    }

    /**
     * @des 将主页中的Fragment一起加载布局，有用显示，无用则隐藏
     */
    private void addFragment() {
        //创建管理者对象
        manager=getSupportFragmentManager();
        //创建事务处理对象
        FragmentTransaction transaction=manager.beginTransaction();
        //将fragment添加到布局
        transaction.add(R.id.main_layout_center,starFrag);
        transaction.add(R.id.main_layout_center,partnerFrag);
        transaction.add(R.id.main_layout_center,luckFrag);
        transaction.add(R.id.main_layout_center,meFrag);
        //隐藏后面三个
        transaction.hide(partnerFrag);
        transaction.hide(luckFrag);
        transaction.hide(meFrag);

        //提交碎片改变后的事务
        transaction.commit();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction=manager.beginTransaction();
        switch (checkedId) {
            case R.id.main_rg_star:
                transaction.hide(partnerFrag);
                transaction.hide(luckFrag);
                transaction.hide(meFrag);
                transaction.show(starFrag);
                break;
            case R.id.main_rg_parnter:
                transaction.hide(starFrag);
                transaction.hide(luckFrag);
                transaction.hide(meFrag);
                transaction.show(partnerFrag);
                break;
            case R.id.main_rg_luck:
                transaction.hide(starFrag);
                transaction.hide(partnerFrag);
                transaction.hide(meFrag);
                transaction.show(luckFrag);
                break;
            case  R.id.main_rg_me:
                transaction.hide(starFrag);
                transaction.hide(partnerFrag);
                transaction.hide(luckFrag);
                transaction.show(meFrag);
                break;
        }
        transaction.commit();
    }
}
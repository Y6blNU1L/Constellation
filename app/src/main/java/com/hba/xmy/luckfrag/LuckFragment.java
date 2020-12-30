package com.hba.xmy.luckfrag;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.hba.xmy.R;
import com.hba.xmy.bean.StarBean;
import java.util.List;


public class LuckFragment extends Fragment {
    GridView luckGv;
    List<StarBean.StarinfoBean> mDatas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_lucks, container, false);
        initView(view);
        //设置监听事件
        setListener();
        return view;
    }

    /**
     * 设置监听事件
     */
    private void setListener() {
        luckGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            StarBean.StarinfoBean bean = mDatas.get(position);
            String name=bean.getName();
            Intent intent = new Intent(getContext(), LuckAnalysisActivity.class);
            intent.putExtra("name",name);
            startActivity(intent);
        }
    });
    }

    /**
     * 初始化
     * @param view
     */
    private void initView(View view) {
        luckGv=view.findViewById(R.id.luckfrag_gv);
        //获取数据源
        Bundle bundle = getArguments();
        StarBean infoBean =(StarBean) bundle.getSerializable("info");
        mDatas=infoBean.getStarinfo();
        //设置适配器
        LuckBaseAdapter luckBaseAdapter = new LuckBaseAdapter(getContext(), mDatas);
        luckGv.setAdapter(luckBaseAdapter);

    }
}
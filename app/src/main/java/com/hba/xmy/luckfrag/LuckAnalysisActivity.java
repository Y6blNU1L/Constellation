package com.hba.xmy.luckfrag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hba.xmy.R;
import com.hba.xmy.utils.LoadDataAsyncTask;
import com.hba.xmy.utils.URLContent;

public class LuckAnalysisActivity extends AppCompatActivity implements View.OnClickListener,LoadDataAsyncTask.OnGetNetDataListener {

    ListView luckLv;
    TextView nameTv;
    ImageView backIv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luck_analysis);
        //获取传递的过来的
        Intent intent = getIntent();
        String name = intent.getStringExtra("name"); //星座名称
        String luckURL = URLContent.getLuckURL(name);
        initView(name);
        //获取网络请求
        LoadDataAsyncTask task = new LoadDataAsyncTask(this, this, true);
        task.execute(luckURL);

    }

    private void initView(String name) {
        luckLv=findViewById(R.id.luckanalysis_lv);
        nameTv=findViewById(R.id.item_luck_tv);
        backIv=findViewById(R.id.title_iv_back);
        nameTv.setText(name);
        backIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_iv_back:
                finish();
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    /**
     * 获取网络请求方法
     * @param json
     */
    @Override
    public void onSuccess(String json) {
        if (!TextUtils.isEmpty(json)) {
            //数据解析
            LuckBean luckBean = new Gson().fromJson(json, LuckBean.class);
            //重新整理数据


        }
    }
}
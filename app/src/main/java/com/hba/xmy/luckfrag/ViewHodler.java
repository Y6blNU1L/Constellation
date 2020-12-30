package com.hba.xmy.luckfrag;

import android.view.View;
import android.widget.TextView;

import com.hba.xmy.R;

/**
 * @Author: HBA
 * @Time: 2020/12/30 21:02
 * @Describe:
 */
public class ViewHodler {
    TextView titleTv,contentTv;
    public  ViewHodler(View view){
        titleTv=view.findViewById(R.id.item_luck_tv_title);
        contentTv=view.findViewById(R.id.item_luck_tv_content);
    }
}

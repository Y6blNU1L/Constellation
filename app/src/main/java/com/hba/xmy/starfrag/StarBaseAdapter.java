package com.hba.xmy.starfrag;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hba.xmy.R;
import com.hba.xmy.bean.StarBean;
import com.hba.xmy.utils.AssetsUtils;

import java.util.List;
import java.util.Map;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @Author: HBA
 * @Time: 2020/12/26 23:10
 * @Describe: 首页适配器
 */
public class StarBaseAdapter extends BaseAdapter {
    Context context;
    List<StarBean.StarinfoBean> mDatas;
    Map<String, Bitmap>logoMap;

    public StarBaseAdapter(Context context, List<StarBean.StarinfoBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        logoMap=AssetsUtils.getLogoImgMap();
    }
    @Override
    public int getCount() {
        return mDatas.size();
    }
    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView ==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_star_gv,null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder) convertView.getTag();
        }
        StarBean.StarinfoBean bean = mDatas.get(position);
        holder.tv.setText(bean.getName());
        //获得图片的名称，根据图片的名称取出推片
        String logoname = bean.getLogoname();
        Bitmap bitmap = logoMap.get(logoname);
        holder.iv.setImageBitmap(bitmap);
        return convertView;
    }
    //对于item当中初始化操作
    class ViewHolder{
        CircleImageView iv;
        TextView tv;
        public  ViewHolder(View view){
            iv=view.findViewById(R.id.item_star_iv);
            tv=view.findViewById(R.id.item_star_tv);
        }
    }
}

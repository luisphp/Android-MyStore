package com.example.luishurtado.mystore;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by luis.hurtado on 04/06/2018.
 */
public class AdapterCampaingsImages extends PagerAdapter {

    private Context context ;
    private List<ResponseCampaignImages.ImagenesBean> imageUrls;

    public AdapterCampaingsImages(Context context, List<ResponseCampaignImages.ImagenesBean> imageUrls) {
        this.context = context;
        this.imageUrls = imageUrls;
    }

    @Override
    public int getCount() {
        return imageUrls.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        ImageView imageView = new ImageView(context);


        Picasso.with(context)
                .load(imageUrls.get(position).getUrl_image())
                .fit()
                .into(imageView);

        container.addView(imageView);



        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}

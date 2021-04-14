package com.example.homework_chapter_7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class ImageActivity extends AppCompatActivity {

    List<View> pages = new ArrayList<View>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ViewPager pager=(ViewPager)findViewById(R.id.view_pager);
        ViewAdapter adapter=new ViewAdapter();
        initImages();
        adapter.setData(pages);
        pager.setAdapter(adapter);
    }
    private void initImages(){
        addImage("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fcn.aacdn.jp%2Fglobal-aaj-front%2Farticle%2F2016%2F11%2F58292833ec376_582924b5e88d8_1980624650.jpg&refer=http%3A%2F%2Fcn.aacdn.jp&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1620962600&t=eb027384fe71958e72d717aae66229f2");
        addImage("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fccm.ddcdn.com%2Fext%2Fphoto-s%2F14%2Fb5%2F66%2F43%2Fsakurajima-nagisa-foot.jpg&refer=http%3A%2F%2Fccm.ddcdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1620962600&t=08341ff9577c00db0fdf853cfae9d3b5");
        addImage("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fkyushu-japan-holidays.com%2Fimages%2Fphotogallery%2Fkagoshima%2FSakurajima.jpg&refer=http%3A%2F%2Fkyushu-japan-holidays.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1620962600&t=a945567cd533324eaf74fa465e32a1f2");
    }

    private void addImage(String path){
        ImageView imageView=(ImageView) getLayoutInflater().inflate(R.layout.image_item,null);
        Glide.with(this)
                .load(path)
                .apply(new RequestOptions().circleCrop().diskCacheStrategy(DiskCacheStrategy.ALL))
                .error(R.drawable.error)
                .into(imageView);
        pages.add(imageView);
    }

    private void addImage(int resId){
        ImageView imageView=(ImageView) getLayoutInflater().inflate(R.layout.image_item,null);
        Glide.with(this)
                .load(resId)
                .error(R.drawable.error)
                .into(imageView);
        pages.add(imageView);
    }
}
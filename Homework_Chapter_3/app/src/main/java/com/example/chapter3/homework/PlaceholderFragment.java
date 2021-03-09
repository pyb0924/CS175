package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PlaceholderFragment extends Fragment {
    View lottie_view;
    RecyclerView recycler_view;
    private final List<String> itemList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        lottie_view = view.findViewById(R.id.lottie);
        recycler_view = view.findViewById(R.id.recycle_view);
        dataInit();

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recycler_view.setLayoutManager(manager);
        ItemAdapter adapter = new ItemAdapter(itemList);
        recycler_view.setAdapter(adapter);
        //Log.d("Placeholder","view created");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                ObjectAnimator lottie_out = ObjectAnimator.ofFloat(lottie_view, "alpha",
                        1.0f, 0f);
                lottie_out.setDuration(1000);
                lottie_out.setInterpolator(new LinearInterpolator());

                ObjectAnimator list_in = ObjectAnimator.ofFloat(recycler_view, "alpha",
                        0f, 1.0f);
                list_in.setDuration(1000);
                list_in.setInterpolator(new LinearInterpolator());

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playSequentially(lottie_out, list_in);
                animatorSet.start();
            }
        }, 5000);
    }

    private void dataInit() {
        for (int i = 0; i < 100; i++) {
            @SuppressLint("DefaultLocale") String item = String.format("这是第%d行", i + 1);
            itemList.add(item);
        }
    }
}

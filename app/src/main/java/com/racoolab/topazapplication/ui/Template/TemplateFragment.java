package com.racoolab.topazapplication.ui.Template;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.racoolab.topazapplication.ColorCode;
import com.racoolab.topazapplication.R;

import static com.racoolab.topazapplication.MainActivity.colorset;

public class TemplateFragment extends Fragment {




    //핵심 엔진 연결

    ImageView ImageView_deco1;
    ImageView ImageView_Subdeco1;
    TextView TextView_title1;
    TextView TextView_subtitle1;
    TextView TextView_content1;
    ConstraintLayout ConstraintLayout_background1;


    public static TemplateFragment newInstance() {
        TemplateFragment fragment = new TemplateFragment();
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_template, container, false);


        setCom(view);
        changeview();


        return view;

    }


    void setCom(View view1) {

        ImageView_deco1 = view1.findViewById(R.id.ImageView_deco1);
        ImageView_Subdeco1 = view1.findViewById(R.id.ImageView_subdeco1);
        TextView_title1 = view1.findViewById(R.id.TextView_Title1);
        TextView_subtitle1 = view1.findViewById(R.id.TextView_SubTitle1);
        TextView_content1 = view1.findViewById(R.id.TextView_content1);
        ConstraintLayout_background1 = view1.findViewById(R.id.ConstraintLayout_background1);

    }

    void changeview() {


        if (colorset[3].getChecked()) {
            ImageView_deco1.setBackgroundColor(Color.parseColor(colorset[3].getColorcode().replace("#","#BF")));
            ImageView_Subdeco1.setBackgroundColor(Color.parseColor(colorset[3].getColorcode()));


        } else {
            ImageView_deco1.setBackgroundColor(Color.parseColor("#00000000"));

            ImageView_Subdeco1.setBackgroundColor(Color.parseColor("#00000000"));

        }

        if (colorset[0].getChecked()) {
            TextView_title1.setTextColor(Color.parseColor(colorset[0].getColorcode()));
        } else {
            TextView_title1.setTextColor(Color.parseColor("#00000000"));
        }
        if (colorset[1].getChecked()) {
            TextView_subtitle1.setTextColor(Color.parseColor(colorset[1].getColorcode()));

        } else {
            TextView_subtitle1.setTextColor(Color.parseColor("#00000000"));

        }

        if (colorset[2].getChecked()) {
            TextView_content1.setTextColor(Color.parseColor(colorset[2].getColorcode()));

        } else {
            TextView_content1.setTextColor(Color.parseColor("#00000000"));
        }


        if (colorset[4].getChecked()) {
            ConstraintLayout_background1.setBackgroundColor(Color.parseColor(colorset[4].getColorcode()));

        } else {
            ConstraintLayout_background1.setBackgroundColor(Color.parseColor("#FF000000"));

        }
//

    }









}




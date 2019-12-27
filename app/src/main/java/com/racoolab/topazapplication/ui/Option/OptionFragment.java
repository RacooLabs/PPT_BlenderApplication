package com.racoolab.topazapplication.ui.Option;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.racoolab.topazapplication.R;
import com.racoolab.topazapplication.ui.Template.TemplateFragment;

import static com.racoolab.topazapplication.MainActivity.colorset;

public class OptionFragment extends Fragment {

    ImageView ImageView_deco3;
    ImageView ImageView_Subdeco3;
    TextView TextView_subtitle3;
    TextView TextView_content3;
    ConstraintLayout ConstraintLayout_background3;

    ImageView ImageView_char1;
    ImageView ImageView_char2;
    ImageView ImageView_char3;

    TextView TextView_yeartext1;
    TextView TextView_yeartext2;
    TextView TextView_yeartext3;

    TextView TextView_statetext1;
    TextView TextView_statetext2;
    TextView TextView_statetext3;



    public static OptionFragment newInstance() {
        OptionFragment fragment = new OptionFragment();
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_option, container, false);


        setCom(view);
        changeview();



        return view;

    }

    void setCom(View view3) {

        ImageView_deco3 = view3.findViewById(R.id.ImageView_deco3);
        ImageView_Subdeco3 = view3.findViewById(R.id.ImageView_subdeco3);
        TextView_subtitle3 = view3.findViewById(R.id.TextView_SubTitle3);
        TextView_content3 = view3.findViewById(R.id.TextView_content3);
        ConstraintLayout_background3 = view3.findViewById(R.id.ConstraintLayout_background3);

        ImageView_char1 = view3.findViewById(R.id.char1);
        ImageView_char2 = view3.findViewById(R.id.char2);
        ImageView_char3 = view3.findViewById(R.id.char3);

        TextView_yeartext1 = view3.findViewById(R.id.TextView_yeartext1);
        TextView_yeartext2 = view3.findViewById(R.id.TextView_yeartext2);
        TextView_yeartext3 = view3.findViewById(R.id.TextView_yeartext3);

        TextView_statetext1 = view3.findViewById(R.id.TextView_statetext1);
        TextView_statetext2 = view3.findViewById(R.id.TextView_statetext2);
        TextView_statetext3 = view3.findViewById(R.id.TextView_statetext3);



    }

    void changeview() {


        if (colorset[3].getChecked()) {

            ImageView_deco3.setBackgroundColor(Color.parseColor(colorset[3].getColorcode().replace("#","#BF")));
            ImageView_Subdeco3.setBackgroundColor(Color.parseColor(colorset[3].getColorcode()));
            ImageView_char1.setBackgroundColor(Color.parseColor(colorset[3].getColorcode()));
            ImageView_char2.setBackgroundColor(Color.parseColor(colorset[3].getColorcode()));
            ImageView_char3.setBackgroundColor(Color.parseColor(colorset[3].getColorcode()));


        } else {
            ImageView_deco3.setBackgroundColor(Color.parseColor("#00000000"));
            ImageView_Subdeco3.setBackgroundColor(Color.parseColor("#00000000"));
            ImageView_char1.setBackgroundColor(Color.parseColor("#00000000"));
            ImageView_char2.setBackgroundColor(Color.parseColor("#00000000"));
            ImageView_char3.setBackgroundColor(Color.parseColor("#00000000"));
        }


        if (colorset[1].getChecked()) {
            TextView_subtitle3.setTextColor(Color.parseColor(colorset[1].getColorcode()));
        } else {
            TextView_subtitle3.setTextColor(Color.parseColor("#00000000"));
        }

        if (colorset[2].getChecked()) {
            TextView_content3.setTextColor(Color.parseColor(colorset[2].getColorcode()));
            TextView_yeartext1.setTextColor(Color.parseColor(colorset[2].getColorcode()));
            TextView_yeartext2.setTextColor(Color.parseColor(colorset[2].getColorcode()));
            TextView_yeartext3.setTextColor(Color.parseColor(colorset[2].getColorcode()));
            TextView_statetext1.setTextColor(Color.parseColor(colorset[2].getColorcode()));
            TextView_statetext2.setTextColor(Color.parseColor(colorset[2].getColorcode()));
            TextView_statetext3.setTextColor(Color.parseColor(colorset[2].getColorcode()));


        } else {
            TextView_content3.setTextColor(Color.parseColor("#00000000"));
            TextView_yeartext1.setTextColor(Color.parseColor("#00000000"));
            TextView_yeartext2.setTextColor(Color.parseColor("#00000000"));
            TextView_yeartext3.setTextColor(Color.parseColor("#00000000"));
            TextView_statetext1.setTextColor(Color.parseColor("#00000000"));
            TextView_statetext2.setTextColor(Color.parseColor("#00000000"));
            TextView_statetext3.setTextColor(Color.parseColor("#00000000"));
        }


        if (colorset[4].getChecked()) {
            ConstraintLayout_background3.setBackgroundColor(Color.parseColor(colorset[4].getColorcode()));
        } else {
            ConstraintLayout_background3.setBackgroundColor(Color.parseColor("#00000000"));
        }
//

    }



}
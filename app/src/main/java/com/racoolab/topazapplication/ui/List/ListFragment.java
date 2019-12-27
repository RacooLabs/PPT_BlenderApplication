package com.racoolab.topazapplication.ui.List;

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

import com.google.android.material.textfield.TextInputEditText;
import com.racoolab.topazapplication.R;
import com.racoolab.topazapplication.ui.Option.OptionFragment;

import static com.racoolab.topazapplication.MainActivity.colorset;

public class ListFragment extends Fragment {

    ImageView ImageView_deco2;
    ImageView ImageView_Subdeco2;
    ImageView TextView_contentbox1_round;
    ImageView TextView_contentbox2_round;
    ImageView TextView_contentbox3_round;
    ImageView TextView_contentbox4_round;
    TextView TextView_contentbox1_subTitle;
    TextView TextView_contentbox2_subTitle;
    TextView TextView_contentbox3_subTitle;
    TextView TextView_contentbox4_subTitle;
    TextView TextView_contentbox1_content;
    TextView TextView_contentbox2_content;
    TextView TextView_contentbox3_content;
    TextView TextView_contentbox4_content;
    ConstraintLayout ConstraintLayout_background2;
    TextView TextView_listid1;
    TextView TextView_listid2;
    TextView TextView_listid3;
    TextView TextView_listid4;

    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_list, container, false);


        setCom(view);
        changeview();

        return view;

    }

    void setCom(View view2) {


        ImageView_deco2 = view2.findViewById(R.id.ImageView_deco2);
        ImageView_Subdeco2 = view2.findViewById(R.id.ImageView_subdeco2);
        TextView_contentbox1_round = view2.findViewById(R.id.TextView_contentbox1_round);
        TextView_contentbox2_round = view2.findViewById(R.id.TextView_contentbox2_round);
        TextView_contentbox3_round = view2.findViewById(R.id.TextView_contentbox3_round);
        TextView_contentbox4_round = view2.findViewById(R.id.TextView_contentbox4_round);
        TextView_contentbox1_subTitle = view2.findViewById(R.id.TextView_contentbox1_subTitle);
        TextView_contentbox2_subTitle = view2.findViewById(R.id.TextView_contentbox2_subTitle);
        TextView_contentbox3_subTitle = view2.findViewById(R.id.TextView_contentbox3_subTitle);
        TextView_contentbox4_subTitle = view2.findViewById(R.id.TextView_contentbox4_subTitle);
        TextView_contentbox1_content = view2.findViewById(R.id.TextView_contentbox1_content);
        TextView_contentbox2_content = view2.findViewById(R.id.TextView_contentbox2_content);
        TextView_contentbox3_content = view2.findViewById(R.id.TextView_contentbox3_content);
        TextView_contentbox4_content = view2.findViewById(R.id.TextView_contentbox4_content);
        ConstraintLayout_background2 = view2.findViewById(R.id.ConstraintLayout_background2);
        TextView_listid1 = view2.findViewById(R.id.TextView_listid1);
        TextView_listid2 = view2.findViewById(R.id.TextView_listid2);
        TextView_listid3 = view2.findViewById(R.id.TextView_listid3);
        TextView_listid4 = view2.findViewById(R.id.TextView_listid4);

    }

    void changeview() {

        GradientDrawable setColorShape = (GradientDrawable) TextView_contentbox1_round.getBackground();

        if (colorset[3].getChecked()) {

            ImageView_deco2.setBackgroundColor(Color.parseColor(colorset[3].getColorcode().replace("#","#BF")));
            ImageView_Subdeco2.setBackgroundColor(Color.parseColor(colorset[3].getColorcode()));


            setColorShape.setColor(Color.parseColor(colorset[3].getColorcode()));
            setColorShape = (GradientDrawable) TextView_contentbox2_round.getBackground();
            setColorShape.setColor(Color.parseColor(colorset[3].getColorcode()));
            setColorShape = (GradientDrawable) TextView_contentbox3_round.getBackground();
            setColorShape.setColor(Color.parseColor(colorset[3].getColorcode()));
            setColorShape = (GradientDrawable) TextView_contentbox4_round.getBackground();
            setColorShape.setColor(Color.parseColor(colorset[3].getColorcode()));

        } else {
            ImageView_deco2.setBackgroundColor(Color.parseColor("#00000000"));
            ImageView_Subdeco2.setBackgroundColor(Color.parseColor("#00000000"));

            setColorShape.setColor(Color.parseColor("#00000000"));
            setColorShape = (GradientDrawable) TextView_contentbox2_round.getBackground();
            setColorShape.setColor(Color.parseColor("#00000000"));
            setColorShape = (GradientDrawable) TextView_contentbox3_round.getBackground();
            setColorShape.setColor(Color.parseColor("#00000000"));
            setColorShape = (GradientDrawable) TextView_contentbox4_round.getBackground();
            setColorShape.setColor(Color.parseColor("#00000000"));

            TextView_listid1.setTextColor(Color.parseColor("#00000000"));
            TextView_listid2.setTextColor(Color.parseColor("#00000000"));
            TextView_listid3.setTextColor(Color.parseColor("#00000000"));
            TextView_listid4.setTextColor(Color.parseColor("#00000000"));


        }
//
//
        if (colorset[1].getChecked()) {
            TextView_contentbox1_subTitle.setTextColor(Color.parseColor(colorset[1].getColorcode()));
            TextView_contentbox2_subTitle.setTextColor(Color.parseColor(colorset[1].getColorcode()));
            TextView_contentbox3_subTitle.setTextColor(Color.parseColor(colorset[1].getColorcode()));
            TextView_contentbox4_subTitle.setTextColor(Color.parseColor(colorset[1].getColorcode()));
        } else {
            TextView_contentbox1_subTitle.setTextColor(Color.parseColor("#00000000"));
            TextView_contentbox2_subTitle.setTextColor(Color.parseColor("#00000000"));
            TextView_contentbox3_subTitle.setTextColor(Color.parseColor("#00000000"));
            TextView_contentbox4_subTitle.setTextColor(Color.parseColor("#00000000"));
        }

        if (colorset[2].getChecked()) {
            TextView_contentbox1_content.setTextColor(Color.parseColor(colorset[2].getColorcode()));
            TextView_contentbox2_content.setTextColor(Color.parseColor(colorset[2].getColorcode()));
            TextView_contentbox3_content.setTextColor(Color.parseColor(colorset[2].getColorcode()));
            TextView_contentbox4_content.setTextColor(Color.parseColor(colorset[2].getColorcode()));
        } else {
            TextView_contentbox1_content.setTextColor(Color.parseColor("#00000000"));
            TextView_contentbox2_content.setTextColor(Color.parseColor("#00000000"));
            TextView_contentbox3_content.setTextColor(Color.parseColor("#00000000"));
            TextView_contentbox4_content.setTextColor(Color.parseColor("#00000000"));
        }


        if (colorset[4].getChecked()) {
            ConstraintLayout_background2.setBackgroundColor(Color.parseColor(colorset[4].getColorcode()));
        } else {
            ConstraintLayout_background2.setBackgroundColor(Color.parseColor("#00000000"));
        }
//

    }
}
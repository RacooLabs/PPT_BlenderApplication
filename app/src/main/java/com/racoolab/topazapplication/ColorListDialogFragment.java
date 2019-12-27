package com.racoolab.topazapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import static com.racoolab.topazapplication.MainActivity.colorset;



public class ColorListDialogFragment extends DialogFragment {



    ImageView[] ImageView_colors;

    TextView[] TextView_colorcodes;

    LinearLayout[] LinearLayout_colorlistboxs;

    ColorCode[][] color_list = new ColorCode[8][5];
    ImageView[][] colorlists = new ImageView[8][5];


    TextView TextView_listcancel;






    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());//다이얼로그 스타일 적용
        // Set the dialog title
        LayoutInflater inflater = requireActivity().getLayoutInflater();


        View view = inflater.inflate(R.layout.colorlistdialog, null);


        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view);






        setColorList();//견본 컬러 셋팅

        setCom(view); //레이아웃 연결

        connect(); //견본 컬러 배열을 다이얼로그 색상모양에 적용, 다이얼 로그 셋팅 끝

        for (int i = 0;i<LinearLayout_colorlistboxs.length;i++){
            LinearLayout_colorlistboxs[i].setOnClickListener(mClickListener);
        }//클릭 리스너 연결

        TextView_listcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


        return builder.create();

    }


    public void dialogSetData(ImageView[] ImageView_colors, TextView[] TextView_colorcodes) {

        this.ImageView_colors = ImageView_colors;
        this.TextView_colorcodes = TextView_colorcodes;

    }

    void setColorList() {

        for (int i = 0; i < color_list.length; i++) {
            for (int j = 0; j < color_list[i].length; j++) {
                color_list[i][j] = new ColorCode();
            }
        }


        color_list[0][0].setChecked(true);
        color_list[0][0].setColorcode("#14100F");
        color_list[0][1].setChecked(true);
        color_list[0][1].setColorcode("#413F3F");
        color_list[0][2].setChecked(true);
        color_list[0][2].setColorcode("#000000");
        color_list[0][3].setChecked(true);
        color_list[0][3].setColorcode("#50332C");
        color_list[0][4].setChecked(true);
        color_list[0][4].setColorcode("#D1B4B4");

        color_list[1][0].setChecked(true);
        color_list[1][0].setColorcode("#E8A617");
        color_list[1][1].setChecked(true);
        color_list[1][1].setColorcode("#6B6861");
        color_list[1][2].setChecked(true);
        color_list[1][2].setColorcode("#666666");
        color_list[1][3].setChecked(true);
        color_list[1][3].setColorcode("#EAAE2D");
        color_list[1][4].setChecked(true);
        color_list[1][4].setColorcode("#FBFDED");

        color_list[2][0].setChecked(true);
        color_list[2][0].setColorcode("#423C23");
        color_list[2][1].setChecked(true);
        color_list[2][1].setColorcode("#030809");
        color_list[2][2].setChecked(true);
        color_list[2][2].setColorcode("#403F3F");
        color_list[2][3].setChecked(true);
        color_list[2][3].setColorcode("#A94F1F");
        color_list[2][4].setChecked(true);
        color_list[2][4].setColorcode("#F0E8DF");

        color_list[3][0].setChecked(true);
        color_list[3][0].setColorcode("#1FBDE0");
        color_list[3][1].setChecked(true);
        color_list[3][1].setColorcode("#4E4B4B");
        color_list[3][2].setChecked(true);
        color_list[3][2].setColorcode("#333333");
        color_list[3][3].setChecked(true);
        color_list[3][3].setColorcode("#1FBDE0");
        color_list[3][4].setChecked(true);
        color_list[3][4].setColorcode("#FBFDED");

        color_list[4][0].setChecked(true);
        color_list[4][0].setColorcode("#5F7092");
        color_list[4][1].setChecked(true);
        color_list[4][1].setColorcode("#46536C");
        color_list[4][2].setChecked(true);
        color_list[4][2].setColorcode("#111210");
        color_list[4][3].setChecked(true);
        color_list[4][3].setColorcode("#111210");
        color_list[4][4].setChecked(true);
        color_list[4][4].setColorcode("#DDDFE3");

        color_list[5][0].setChecked(true);
        color_list[5][0].setColorcode("#FFFFFF");
        color_list[5][1].setChecked(true);
        color_list[5][1].setColorcode("#FFFFFF");
        color_list[5][2].setChecked(true);
        color_list[5][2].setColorcode("#FFFFFF");
        color_list[5][3].setChecked(true);
        color_list[5][3].setColorcode("#1C315C");
        color_list[5][4].setChecked(true);
        color_list[5][4].setColorcode("#3890B1");

        color_list[6][0].setChecked(true);
        color_list[6][0].setColorcode("#142E71");
        color_list[6][1].setChecked(true);
        color_list[6][1].setColorcode("#060C20");
        color_list[6][2].setChecked(true);
        color_list[6][2].setColorcode("#060C20");
        color_list[6][3].setChecked(true);
        color_list[6][3].setColorcode("#142E71");
        color_list[6][4].setChecked(true);
        color_list[6][4].setColorcode("#EFF3FB");

        color_list[7][0].setChecked(true);
        color_list[7][0].setColorcode("#A18F07");
        color_list[7][1].setChecked(true);
        color_list[7][1].setColorcode("#B30024");
        color_list[7][2].setChecked(true);
        color_list[7][2].setColorcode("#2C59A0");
        color_list[7][3].setChecked(true);
        color_list[7][3].setColorcode("#F500EC");
        color_list[7][4].setChecked(true);
        color_list[7][4].setColorcode("#0EE7F2");

    }

    LinearLayout.OnClickListener mClickListener = new View.OnClickListener() {


        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.LinearLayout_colorlistbox1:

                    for(int i=0;i < color_list[0].length;i++){
                        colorset[i].setColorcode(color_list[0][i].getColorcode());
                        colorset[i].setChecked(color_list[0][i].getChecked());
                    }

                    connect_activity(); // 정해진 컬러 셋을 액티비티에 적용

                    dismiss();

                    break;

                case R.id.LinearLayout_colorlistbox2:

                    for(int i=0;i < color_list[1].length;i++){
                        colorset[i].setColorcode(color_list[1][i].getColorcode());
                        colorset[i].setChecked(color_list[1][i].getChecked());
                    }

                    connect_activity();

                    dismiss();

                    break;
                case R.id.LinearLayout_colorlistbox3:

                    for(int i=0;i < color_list[2].length;i++){
                        colorset[i].setColorcode(color_list[2][i].getColorcode());
                        colorset[i].setChecked(color_list[2][i].getChecked());
                    }

                    connect_activity();

                    dismiss();

                    break;
                case R.id.LinearLayout_colorlistbox4:

                    for(int i=0;i < color_list[3].length;i++){
                        colorset[i].setColorcode(color_list[3][i].getColorcode());
                        colorset[i].setChecked(color_list[3][i].getChecked());
                    }

                    connect_activity();

                    dismiss();

                    break;
                case R.id.LinearLayout_colorlistbox5:

                    for(int i=0;i < color_list[4].length;i++){
                        colorset[i].setColorcode(color_list[4][i].getColorcode());
                        colorset[i].setChecked(color_list[4][i].getChecked());
                    }

                    connect_activity();

                    dismiss();

                    break;
                case R.id.LinearLayout_colorlistbox6:

                    for(int i=0;i < color_list[5].length;i++){
                        colorset[i].setColorcode(color_list[5][i].getColorcode());
                        colorset[i].setChecked(color_list[5][i].getChecked());
                    }

                    connect_activity();

                    dismiss();

                    break;
                case R.id.LinearLayout_colorlistbox7:

                    for(int i=0;i < color_list[6].length;i++){
                        colorset[i].setColorcode(color_list[6][i].getColorcode());
                        colorset[i].setChecked(color_list[6][i].getChecked());
                    }

                    connect_activity();

                    dismiss();

                    break;
                case R.id.LinearLayout_colorlistbox8:

                    for(int i=0;i < color_list[7].length;i++){
                        colorset[i].setColorcode(color_list[7][i].getColorcode());
                        colorset[i].setChecked(color_list[7][i].getChecked());
                    }

                    connect_activity();

                    dismiss();

                    break;

            }

        }
    };


    void connect(){

        for (int i = 0; i < color_list.length; i++){

            for(int j = 0; j < color_list[i].length;j++ ){

                GradientDrawable setColorShape = (GradientDrawable) colorlists[i][j].getBackground();
                setColorShape.setColor(Color.parseColor(color_list[i][j].getColorcode()));

            }

        }

    }

    void connect_activity(){

        for (int i = 0; i < colorset.length; i++) {

            GradientDrawable setColorShape = (GradientDrawable) ImageView_colors[i].getBackground();
            setColorShape.setColor(Color.parseColor(colorset[i].getColorcode()));
            TextView_colorcodes[i].setText(colorset[i].getColorcode());

        }

        Fragment frg = null;
        frg = getFragmentManager().findFragmentById(R.id.nav_host_fragment);
        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(frg);
        ft.attach(frg);
        ft.commit();


    }


    void setCom(View view){

        LinearLayout_colorlistboxs = new LinearLayout[] {
        (LinearLayout) view.findViewById(R.id.LinearLayout_colorlistbox1),
        (LinearLayout) view.findViewById(R.id.LinearLayout_colorlistbox2),
        (LinearLayout) view.findViewById(R.id.LinearLayout_colorlistbox3),
        (LinearLayout) view.findViewById(R.id.LinearLayout_colorlistbox4),
        (LinearLayout) view.findViewById(R.id.LinearLayout_colorlistbox5),
        (LinearLayout) view.findViewById(R.id.LinearLayout_colorlistbox6),
        (LinearLayout) view.findViewById(R.id.LinearLayout_colorlistbox7),
        (LinearLayout) view.findViewById(R.id.LinearLayout_colorlistbox8)};

        colorlists = new ImageView[][]{
                {(ImageView) view.findViewById(R.id.ImageView_colorlist1_1),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist1_2),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist1_3),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist1_4),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist1_5)},

                {(ImageView) view.findViewById(R.id.ImageView_colorlist2_1),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist2_2),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist2_3),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist2_4),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist2_5)},

                {(ImageView) view.findViewById(R.id.ImageView_colorlist3_1),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist3_2),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist3_3),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist3_4),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist3_5)},

                {(ImageView) view.findViewById(R.id.ImageView_colorlist4_1),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist4_2),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist4_3),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist4_4),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist4_5)},

                {(ImageView) view.findViewById(R.id.ImageView_colorlist5_1),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist5_2),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist5_3),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist5_4),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist5_5)},

                {(ImageView) view.findViewById(R.id.ImageView_colorlist6_1),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist6_2),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist6_3),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist6_4),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist6_5)},

                {(ImageView) view.findViewById(R.id.ImageView_colorlist7_1),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist7_2),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist7_3),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist7_4),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist7_5)},

                {(ImageView) view.findViewById(R.id.ImageView_colorlist8_1),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist8_2),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist8_3),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist8_4),
                        (ImageView) view.findViewById(R.id.ImageView_colorlist8_5)},


        };


        TextView_listcancel = view.findViewById(R.id.TextView_listcancel);

    }







}




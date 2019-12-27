package com.racoolab.topazapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import static com.racoolab.topazapplication.MainActivity.colorset;


public class CustomColorDialogFragment extends DialogFragment {

    ImageView[] ImageView_colors;
    TextView[] TextView_colorcodes;

    CheckBox[] CheckBoxs;
    EditText[] EditTexts;

    TextView TextView_editcancel;
    TextView TextView_editok;

//    private OntimePickerSetListener ontimePickerSetListener;

    int requestcode;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Set the dialog title


        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog, null);

        setCom(view);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view);

        TextView_editok.setOnClickListener(mClick);
        TextView_editcancel.setOnClickListener(mClick);
//        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int id) {
//                // User clicked OK, so save the selectedItems results somewhere
//                // or return them to the component that opened the dialog
//
//
//
//            }
//        });
//        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int id) {
//
//            }
//
//        });// Set the action buttons



        for (int i = 0; i < CheckBoxs.length; i++) {
            CheckBoxs[i].setChecked(colorset[i].getChecked());
            EditTexts[i].setText(colorset[i].getColorcode().replace("#",""));
            EditTexts[i].setSelection(EditTexts[i].getText().length());
        }


        return builder.create();

    }


    public void dialogSetData(ImageView[] ImageView_colors, TextView[] TextView_colorcodes,int requestcode) {

        this.ImageView_colors = ImageView_colors;
        this.TextView_colorcodes = TextView_colorcodes;
        this.requestcode = requestcode;


    }

    void setCom(View dialog) {

        CheckBoxs = new CheckBox[]{
                (CheckBox) dialog.findViewById(R.id.CheckBox_title),
                (CheckBox) dialog.findViewById(R.id.CheckBox_subtitle),
                (CheckBox) dialog.findViewById(R.id.CheckBox_content),
                (CheckBox) dialog.findViewById(R.id.CheckBox_deco),
                (CheckBox) dialog.findViewById(R.id.CheckBox_background),
        };



        EditTexts = new EditText[]{
                (EditText) dialog.findViewById(R.id.EditText_title),
                (EditText) dialog.findViewById(R.id.EditText_subtitle),
                (EditText) dialog.findViewById(R.id.EditText_content),
                (EditText) dialog.findViewById(R.id.EditText_deco),
                (EditText) dialog.findViewById(R.id.EditText_background),
        };

        TextView_editcancel = dialog.findViewById(R.id.TextView_editcancel);
        TextView_editok = dialog.findViewById(R.id.TextView_editok);


        EditTexts[requestcode].requestFocus();




    }


    View.OnClickListener mClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.TextView_editok:
                    for (int i = 0; i < CheckBoxs.length; i++) {
                        colorset[i].setChecked(CheckBoxs[i].isChecked());
                        colorset[i].setColorcode("#" + EditTexts[i].getText().toString());

                    }


                    Fragment frg = null;
                    frg = getFragmentManager().findFragmentById(R.id.nav_host_fragment);
                    final FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.detach(frg);
                    ft.attach(frg);
                    ft.commit();


                    for (int i = 0; i < colorset.length; i++) {

                        GradientDrawable setColorShape = (GradientDrawable) ImageView_colors[i].getBackground();
                        setColorShape.setColor(Color.parseColor(colorset[i].getColorcode()));
                        TextView_colorcodes[i].setText(colorset[i].getColorcode());
                    }

                    dismiss();

                    break;

                case R.id.TextView_editcancel:

                    dismiss();

                    break;




            }

        }

    };


}





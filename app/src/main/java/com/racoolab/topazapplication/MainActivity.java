package com.racoolab.topazapplication;


import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.racoolab.topazapplication.ui.List.ListFragment;
import com.racoolab.topazapplication.ui.Option.OptionFragment;
import com.racoolab.topazapplication.ui.Template.TemplateFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    public static ColorCode[] colorset; // 핵심 컬러

    ImageView[] ImageView_colors; // 팔레트 원
    TextView[] TextView_colorcodes; // 팔레트 아래 나오는 코
    TextView[] TextView_colorboxes;

    int requestcode; // edittext 커서 위치 정해주는 번호

    private FragmentManager fragmentManager = getSupportFragmentManager();

    private TemplateFragment templateFragment = new TemplateFragment();

    private ListFragment listFragment = new ListFragment();

    private OptionFragment optionFragment = new OptionFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, LoadingActivity.class);
        startActivity(intent);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_Template, R.id.navigation_List, R.id.navigation_Option)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.nav_host_fragment, templateFragment).commitAllowingStateLoss();

        MobileAds.initialize(this, "ca-app-pub-7972968096388401~3124585507");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.navigation_Template: {
                        transaction.replace(R.id.nav_host_fragment, templateFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_List: {
                        transaction.replace(R.id.nav_host_fragment, listFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_Option: {
                        transaction.replace(R.id.nav_host_fragment, optionFragment).commitAllowingStateLoss();
                        break;
                    }

                }

                return true;
            }
        });


        setCom();
        setClick(); // 레이아웃 연결과 버튼 기능 활성화


        resetColor();//컬러 '배열'을 변경
        connect();//필레트에 컬레셋 연결


        //1. 컬러코드 배열을 기본 화면과 연결 (colors와 colorcodes)
        //2. 컬러코드 배열을 다이얼로그 화면과 연결
        //3. 컬러코드 배열을 다이얼로그에서 수정


    }

    void setCom() {


        ImageView_colors = new ImageView[]{
                (ImageView) findViewById(R.id.ImageView_color1),
                (ImageView) findViewById(R.id.ImageView_color2),
                (ImageView) findViewById(R.id.ImageView_color3),
                (ImageView) findViewById(R.id.ImageView_color4),
                (ImageView) findViewById(R.id.ImageView_color5)
        };

        TextView_colorcodes = new TextView[]{
                (TextView) findViewById(R.id.TextView_colorcode1),
                (TextView) findViewById(R.id.TextView_colorcode2),
                (TextView) findViewById(R.id.TextView_colorcode3),
                (TextView) findViewById(R.id.TextView_colorcode4),
                (TextView) findViewById(R.id.TextView_colorcode5)
        };

        TextView_colorboxes = new TextView[]{
                (TextView) findViewById(R.id.TextView_Colorbox1),
                (TextView) findViewById(R.id.TextView_Colorbox2),
                (TextView) findViewById(R.id.TextView_Colorbox3),
                (TextView) findViewById(R.id.TextView_Colorbox4),
                (TextView) findViewById(R.id.TextView_Colorbox5),
                (TextView) findViewById(R.id.TextView_Colorbox6)
        };


    }

    void resetColor() {

        colorset = new ColorCode[5];

        for(int i = 0;i<colorset.length;i++){
            colorset[i] = new ColorCode();
            colorset[i].setChecked(true);
        }

        colorset[0].setColorcode("#14100F");
        colorset[1].setColorcode("#413F3F");
        colorset[2].setColorcode("#000000");
        colorset[3].setColorcode("#50332C");
        colorset[4].setColorcode("#D1B4B4");


    }

    void connect() {

        for (int i = 0; i < colorset.length; i++) {

            GradientDrawable setColorShape = (GradientDrawable) ImageView_colors[i].getBackground();
            setColorShape.setColor(Color.parseColor(colorset[i].getColorcode()));
            TextView_colorcodes[i].setText(colorset[i].getColorcode());

        }

    }

    void setClick() {

        for (int i = 0; i < 6; i++) {
            TextView_colorboxes[i].setClickable(true);
            TextView_colorboxes[i].setEnabled(true);
        }


        for (int i = 0; i < 5; i++) {
            TextView_colorboxes[i].setOnClickListener(colorboxeslistener);
        }

        TextView_colorboxes[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogFragment newFragment = new ColorListDialogFragment();

                ((ColorListDialogFragment) newFragment).dialogSetData(ImageView_colors, TextView_colorcodes);

                newFragment.show(getSupportFragmentManager(), "customColor");

            }


        });


    }

    View.OnClickListener colorboxeslistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.TextView_Colorbox1: requestcode = 0;

                    break;

                case R.id.TextView_Colorbox2: requestcode = 1;

                    break;

                case R.id.TextView_Colorbox3: requestcode = 2;

                    break;

                case R.id.TextView_Colorbox4: requestcode = 3;

                    break;

                case R.id.TextView_Colorbox5: requestcode = 4;

                    break;

            }

            DialogFragment newFragment = new CustomColorDialogFragment();

            ((CustomColorDialogFragment) newFragment).dialogSetData(ImageView_colors, TextView_colorcodes,requestcode);

            newFragment.setCancelable(false);

            newFragment.show(getSupportFragmentManager(), "customColor");

            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);


        }


    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu) ;

        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_btn1:

                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("label", getshare());
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(getApplication(), "색상코드가 복사되었습니다.",Toast.LENGTH_LONG).show();

                return true;

            default :
                return false;
        }
    }

    String getshare(){

        String string = "제목 " + colorset[0].getColorcode() + "/\n" + "부제 " + colorset[1].getColorcode() + "/\n"
                + "본문 " + colorset[2].getColorcode() + "/\n" + "장식 " + colorset[3].getColorcode() + "/\n"
                + "배경 " + colorset[4].getColorcode();

         return string;

    }


}



package com.jobcard.david.jobcard;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import static com.jobcard.david.jobcard.R.drawable.cardview_bg;


public class UserActivity extends AppCompatActivity {

    CardView cardview;
    Context context;
    LayoutParams layoutparams;
    TextView textview;
    RelativeLayout relativeLayout;
    LinearLayout linearLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String printFullname = null;
        int i = 0;
        int j = 0;

        String jsonStr = getIntent().getStringExtra("jsonStr");
        try {

            JSONObject jsonObj = new JSONObject(jsonStr);
            String query_result = jsonObj.getString("query_result");
            String firstname = jsonObj.getString("firstname");
            String lastname = jsonObj.getString("lastname");
            String username = jsonObj.getString("username");

            printFullname = firstname + " " + lastname;
            //this.printRole = role;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        context = getApplicationContext();
        linearLayout = (LinearLayout)findViewById(R.id.linearLayout1);



        //TextView mTextView = (TextView) findViewById(R.id.textUser);
       // mTextView.setText("welcome back " + printFullname + " !");



        while (j < 3)
        {
            CreateCardPENDINGViewProgrammatically();

            j = j + 1;
        }



        while (i < 3)
        {
            CreateCardCONFIRMEDViewProgrammatically();

            i = i + 1;
        }



    }


    public void click (View v){
        CreateCardCONFIRMEDViewProgrammatically();
        CreateCardPENDINGViewProgrammatically();
    }



    public void CreateCardCONFIRMEDViewProgrammatically() {

        int id = 1;

        cardview = new CardView(context);

        layoutparams = new LayoutParams(
                LayoutParams.MATCH_PARENT ,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics()));

        layoutparams.topMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
        layoutparams.bottomMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());

        cardview.setLayoutParams(layoutparams);
        cardview.setId(id);







        LinearLayout parent = new LinearLayout(context);

        parent.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        parent.setOrientation(LinearLayout.HORIZONTAL);
        parent.setBackgroundResource(R.drawable.cardview_bg);
        parent.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

        cardview.addView(parent);







        View view = new View(context);
        view.setLayoutParams(new LayoutParams(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics()),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics())));

        view.setBackgroundResource(R.color.colorGreen);


        parent.addView(view);








        RelativeLayout relativeLayout1 = new RelativeLayout(context);

        LayoutParams params_RelativeLayout = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics()));

        params_RelativeLayout.setMargins(0,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics()),
                0,0);  // left, top, right, bottom

        relativeLayout1.setLayoutParams(params_RelativeLayout);


        parent.addView(relativeLayout1);












        TextView textView = new TextView(context);


        RelativeLayout.LayoutParams params_TextView = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        params_TextView.setMargins(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()) ,
                0 , 0 , 0);  // left, top, right, bottom

        textView.setLayoutParams(params_TextView);

        int id_of_textView = 1;

        textView.setId(id_of_textView);

        textView.setText("Performing jobcart on the part");

        textView.setTextColor(ContextCompat.getColor(context, R.color.colorGray));

        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);

        textView.setTypeface( null , Typeface.BOLD);



        relativeLayout1.addView(textView);











        LinearLayout linearLayout2 = new LinearLayout(context);

        RelativeLayout.LayoutParams params_LinearLayout2 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        params_LinearLayout2.setMargins(0,0,
               (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()),
               0);  // left, top, right, bottom

        params_LinearLayout2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        linearLayout2.setLayoutParams(params_LinearLayout2);

        linearLayout2.setGravity(Gravity.CENTER);




        relativeLayout1.addView(linearLayout2);









        View view1 = new View(context);


        LayoutParams params_view1 = new LayoutParams(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 7, getResources().getDisplayMetrics()),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 7, getResources().getDisplayMetrics()));


        view1.setLayoutParams(params_view1);

        view1.setBackgroundResource(R.drawable.gree_circle);


        linearLayout2.addView(view1);









        TextView textView1 = new TextView(context);


        LayoutParams params_TextView1 = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);

        params_TextView1.setMargins(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics()) ,
                0 , 0 , 0);  // left, top, right, bottom

        textView1.setLayoutParams(params_TextView1);

        textView1.setText("CONFIRMED");

        textView1.setTextColor(ContextCompat.getColor(context, R.color.colorGreen));

        textView1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);

        textView1.setTypeface( null , Typeface.BOLD);



        linearLayout2.addView(textView1);











        LinearLayout linearLayout3 = new LinearLayout(context);

        RelativeLayout.LayoutParams params_LinearLayout3 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        params_LinearLayout3.setMargins(0,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3, getResources().getDisplayMetrics()),
                0,0);  // left, top, right, bottom

        params_LinearLayout3.addRule(RelativeLayout.BELOW, id_of_textView);

        linearLayout3.setLayoutParams(params_LinearLayout3);

        linearLayout3.setOrientation(LinearLayout.HORIZONTAL);

        int id_of_linearLayout3 = 2;

        linearLayout3.setId(id_of_linearLayout3);




        relativeLayout1.addView(linearLayout3);








        ImageView imageView = new ImageView(context);

        LayoutParams params_imageView = new LayoutParams(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 14, getResources().getDisplayMetrics()),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 14, getResources().getDisplayMetrics()));

        params_imageView.setMargins(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()) ,
                0 , 0 , 0);  // left, top, right, bottom

        imageView.setLayoutParams(params_imageView);

        imageView.setBackgroundResource(R.drawable.calendar);


        linearLayout3.addView(imageView);









        TextView textView2 = new TextView(context);


        LayoutParams params_TextView2 = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);

        params_TextView2.setMargins(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()) ,
                0 , 0 , 0);  // left, top, right, bottom

        textView2.setLayoutParams(params_TextView2);

        textView2.setText("13/09 : 5:40 pm");

        textView2.setTextColor(ContextCompat.getColor(context, R.color.colorLightGray));

        textView2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);

        textView2.setTypeface( null , Typeface.BOLD);



        linearLayout3.addView(textView2);











        LinearLayout linearLayout4 = new LinearLayout(context);

        RelativeLayout.LayoutParams params_LinearLayout4 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        params_LinearLayout4.setMargins(0,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()),
                0,0);  // left, top, right, bottom

        params_LinearLayout4.addRule(RelativeLayout.BELOW, id_of_linearLayout3);

        linearLayout4.setLayoutParams(params_LinearLayout4);

        linearLayout4.setOrientation(LinearLayout.HORIZONTAL);




        relativeLayout1.addView(linearLayout4);











        TextView textView_roun_rect1 = new TextView(context);


        LayoutParams params_textView_roun_rect1 = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()));

        params_textView_roun_rect1.setMargins(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()) ,
                0 , 0 , 0);  // left, top, right, bottom

        textView_roun_rect1.setLayoutParams(params_textView_roun_rect1);

        textView_roun_rect1.setBackgroundResource(R.drawable.roun_rect_lightgray);

        textView_roun_rect1.setGravity(Gravity.CENTER);

        textView_roun_rect1.setText("into");

        textView_roun_rect1.setTextColor(ContextCompat.getColor(context, R.color.colorGray));

        textView_roun_rect1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);

        textView_roun_rect1.setTypeface( null , Typeface.BOLD);



        linearLayout4.addView(textView_roun_rect1);











        TextView textView_roun_rect2 = new TextView(context);


        LayoutParams params_textView_roun_rect2 = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()));

        params_textView_roun_rect2.setMargins(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics()) ,
                0 , 0 , 0);  // left, top, right, bottom

        textView_roun_rect2.setLayoutParams(params_textView_roun_rect2);

        textView_roun_rect2.setBackgroundResource(R.drawable.roun_rect_lightgray);

        textView_roun_rect2.setGravity(Gravity.CENTER);

        textView_roun_rect2.setText("job");

        textView_roun_rect2.setTextColor(ContextCompat.getColor(context, R.color.colorGray));

        textView_roun_rect2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);

        textView_roun_rect2.setTypeface( null , Typeface.BOLD);



        linearLayout4.addView(textView_roun_rect2);










        TextView textView_roun_rect3 = new TextView(context);


        LayoutParams params_textView_roun_rect3 = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()));

        params_textView_roun_rect3.setMargins(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics()) ,
                0 , 0 , 0);  // left, top, right, bottom

        textView_roun_rect3.setLayoutParams(params_textView_roun_rect3);

        textView_roun_rect3.setBackgroundResource(R.drawable.roun_rect_lightgray);

        textView_roun_rect3.setGravity(Gravity.CENTER);

        textView_roun_rect3.setText("family");

        textView_roun_rect3.setTextColor(ContextCompat.getColor(context, R.color.colorGray));

        textView_roun_rect3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);

        textView_roun_rect3.setTypeface( null , Typeface.BOLD);



        linearLayout4.addView(textView_roun_rect3);










        TextView textView_roun_rect4 = new TextView(context);


        LayoutParams params_textView_roun_rect4 = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()));

        params_textView_roun_rect4.setMargins(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics()) ,
                0 , 0 , 0);  // left, top, right, bottom

        textView_roun_rect4.setLayoutParams(params_textView_roun_rect4);

        textView_roun_rect4.setBackgroundResource(R.drawable.roun_rect_lightgray);

        textView_roun_rect4.setGravity(Gravity.CENTER);

        textView_roun_rect4.setText("update");

        textView_roun_rect4.setTextColor(ContextCompat.getColor(context, R.color.colorGray));

        textView_roun_rect4.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);

        textView_roun_rect4.setTypeface( null , Typeface.BOLD);



        linearLayout4.addView(textView_roun_rect4);







        linearLayout.addView(cardview);
    }






    public void CreateCardPENDINGViewProgrammatically() {

        int id = 1;

        cardview = new CardView(context);

        layoutparams = new LayoutParams(
                LayoutParams.MATCH_PARENT ,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics()));

        layoutparams.topMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
        layoutparams.bottomMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());

        cardview.setLayoutParams(layoutparams);
        cardview.setId(id);







        LinearLayout parent = new LinearLayout(context);

        parent.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        parent.setOrientation(LinearLayout.HORIZONTAL);
        parent.setBackgroundResource(R.drawable.cardview_bg);
        parent.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

        cardview.addView(parent);







        View view = new View(context);
        view.setLayoutParams(new LayoutParams(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics()),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics())));

        view.setBackgroundResource(R.color.colorOrange);


        parent.addView(view);








        RelativeLayout relativeLayout1 = new RelativeLayout(context);

        LayoutParams params_RelativeLayout = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics()));

        params_RelativeLayout.setMargins(0,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics()),
                0,0);  // left, top, right, bottom

        relativeLayout1.setLayoutParams(params_RelativeLayout);


        parent.addView(relativeLayout1);












        TextView textView = new TextView(context);


        RelativeLayout.LayoutParams params_TextView = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        params_TextView.setMargins(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()) ,
                0 , 0 , 0);  // left, top, right, bottom

        textView.setLayoutParams(params_TextView);

        int id_of_textView = 1;

        textView.setId(id_of_textView);

        textView.setText("Performing jobcart on the part");

        textView.setTextColor(ContextCompat.getColor(context, R.color.colorGray));

        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);

        textView.setTypeface( null , Typeface.BOLD);



        relativeLayout1.addView(textView);











        LinearLayout linearLayout2 = new LinearLayout(context);

        RelativeLayout.LayoutParams params_LinearLayout2 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        params_LinearLayout2.setMargins(0,0,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()),
                0);  // left, top, right, bottom

        params_LinearLayout2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        linearLayout2.setLayoutParams(params_LinearLayout2);

        linearLayout2.setGravity(Gravity.CENTER);




        relativeLayout1.addView(linearLayout2);









        View view1 = new View(context);


        LayoutParams params_view1 = new LayoutParams(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 7, getResources().getDisplayMetrics()),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 7, getResources().getDisplayMetrics()));


        view1.setLayoutParams(params_view1);

        view1.setBackgroundResource(R.drawable.orange_circle);


        linearLayout2.addView(view1);









        TextView textView1 = new TextView(context);


        LayoutParams params_TextView1 = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);

        params_TextView1.setMargins(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics()) ,
                0 , 0 , 0);  // left, top, right, bottom

        textView1.setLayoutParams(params_TextView1);

        textView1.setText("PENDING");

        textView1.setTextColor(ContextCompat.getColor(context, R.color.colorOrange));

        textView1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);

        textView1.setTypeface( null , Typeface.BOLD);



        linearLayout2.addView(textView1);











        LinearLayout linearLayout3 = new LinearLayout(context);

        RelativeLayout.LayoutParams params_LinearLayout3 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        params_LinearLayout3.setMargins(0,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3, getResources().getDisplayMetrics()),
                0,0);  // left, top, right, bottom

        params_LinearLayout3.addRule(RelativeLayout.BELOW, id_of_textView);

        linearLayout3.setLayoutParams(params_LinearLayout3);

        linearLayout3.setOrientation(LinearLayout.HORIZONTAL);

        int id_of_linearLayout3 = 2;

        linearLayout3.setId(id_of_linearLayout3);




        relativeLayout1.addView(linearLayout3);








        ImageView imageView = new ImageView(context);

        LayoutParams params_imageView = new LayoutParams(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 14, getResources().getDisplayMetrics()),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 14, getResources().getDisplayMetrics()));

        params_imageView.setMargins(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()) ,
                0 , 0 , 0);  // left, top, right, bottom

        imageView.setLayoutParams(params_imageView);

        imageView.setBackgroundResource(R.drawable.calendar);


        linearLayout3.addView(imageView);









        TextView textView2 = new TextView(context);


        LayoutParams params_TextView2 = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);

        params_TextView2.setMargins(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()) ,
                0 , 0 , 0);  // left, top, right, bottom

        textView2.setLayoutParams(params_TextView2);

        textView2.setText("13/09 : 5:40 pm");

        textView2.setTextColor(ContextCompat.getColor(context, R.color.colorLightGray));

        textView2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);

        textView2.setTypeface( null , Typeface.BOLD);



        linearLayout3.addView(textView2);











        LinearLayout linearLayout4 = new LinearLayout(context);

        RelativeLayout.LayoutParams params_LinearLayout4 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        params_LinearLayout4.setMargins(0,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()),
                0,0);  // left, top, right, bottom

        params_LinearLayout4.addRule(RelativeLayout.BELOW, id_of_linearLayout3);

        linearLayout4.setLayoutParams(params_LinearLayout4);

        linearLayout4.setOrientation(LinearLayout.HORIZONTAL);




        relativeLayout1.addView(linearLayout4);











        TextView textView_roun_rect1 = new TextView(context);


        LayoutParams params_textView_roun_rect1 = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()));

        params_textView_roun_rect1.setMargins(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()) ,
                0 , 0 , 0);  // left, top, right, bottom

        textView_roun_rect1.setLayoutParams(params_textView_roun_rect1);

        textView_roun_rect1.setBackgroundResource(R.drawable.roun_rect_lightgray);

        textView_roun_rect1.setGravity(Gravity.CENTER);

        textView_roun_rect1.setText("into");

        textView_roun_rect1.setTextColor(ContextCompat.getColor(context, R.color.colorGray));

        textView_roun_rect1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);

        textView_roun_rect1.setTypeface( null , Typeface.BOLD);



        linearLayout4.addView(textView_roun_rect1);











        TextView textView_roun_rect2 = new TextView(context);


        LayoutParams params_textView_roun_rect2 = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()));

        params_textView_roun_rect2.setMargins(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics()) ,
                0 , 0 , 0);  // left, top, right, bottom

        textView_roun_rect2.setLayoutParams(params_textView_roun_rect2);

        textView_roun_rect2.setBackgroundResource(R.drawable.roun_rect_lightgray);

        textView_roun_rect2.setGravity(Gravity.CENTER);

        textView_roun_rect2.setText("job");

        textView_roun_rect2.setTextColor(ContextCompat.getColor(context, R.color.colorGray));

        textView_roun_rect2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);

        textView_roun_rect2.setTypeface( null , Typeface.BOLD);



        linearLayout4.addView(textView_roun_rect2);










        TextView textView_roun_rect3 = new TextView(context);


        LayoutParams params_textView_roun_rect3 = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()));

        params_textView_roun_rect3.setMargins(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics()) ,
                0 , 0 , 0);  // left, top, right, bottom

        textView_roun_rect3.setLayoutParams(params_textView_roun_rect3);

        textView_roun_rect3.setBackgroundResource(R.drawable.roun_rect_lightgray);

        textView_roun_rect3.setGravity(Gravity.CENTER);

        textView_roun_rect3.setText("family");

        textView_roun_rect3.setTextColor(ContextCompat.getColor(context, R.color.colorGray));

        textView_roun_rect3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);

        textView_roun_rect3.setTypeface( null , Typeface.BOLD);



        linearLayout4.addView(textView_roun_rect3);










        TextView textView_roun_rect4 = new TextView(context);


        LayoutParams params_textView_roun_rect4 = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()));

        params_textView_roun_rect4.setMargins(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics()) ,
                0 , 0 , 0);  // left, top, right, bottom

        textView_roun_rect4.setLayoutParams(params_textView_roun_rect4);

        textView_roun_rect4.setBackgroundResource(R.drawable.roun_rect_lightgray);

        textView_roun_rect4.setGravity(Gravity.CENTER);

        textView_roun_rect4.setText("update");

        textView_roun_rect4.setTextColor(ContextCompat.getColor(context, R.color.colorGray));

        textView_roun_rect4.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);

        textView_roun_rect4.setTypeface( null , Typeface.BOLD);



        linearLayout4.addView(textView_roun_rect4);







        linearLayout.addView(cardview);
    }







    public void showMenu (View v)
    {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_main, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if (item.getItemId()==R.id.logout) {

                    SharedPreferences preferences = getSharedPreferences("loginPrefs",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.clear();
                    editor.commit();
                    finish();


                    Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }

                return false;
            }
        });

        popup.show();

    }



    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        //return;
        moveTaskToBack(true);
    }


}



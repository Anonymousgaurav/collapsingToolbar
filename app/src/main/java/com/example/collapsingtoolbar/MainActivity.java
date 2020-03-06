package com.example.collapsingtoolbar;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    CollapsingToolbarLayout collapsingToolbarLayout;
    CardView cview_1,cview_2,cview_3,cview_4;

    RecyclerView recycler_CompanyEmployees;
    List<Employee_Model> employeeLists = new ArrayList<>();


    EmployeesAdapter employeesAdapter;
    AppBarLayout appBarLayout;
    RelativeLayout relative_info;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();


        cview_1.setCardBackgroundColor(getResources().getColor(R.color.color1));
        cview_2.setCardBackgroundColor(getResources().getColor(R.color.color2));
        cview_3.setCardBackgroundColor(getResources().getColor(R.color.color2));
        cview_4.setCardBackgroundColor(getResources().getColor(R.color.color1));


        employeesAdapter = new EmployeesAdapter(getApplicationContext(), employeeLists);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_CompanyEmployees.setLayoutManager(linearLayoutManager);
        recycler_CompanyEmployees.setAdapter(employeesAdapter);


        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();


                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle("XYZ Company");
                    collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.black));
                    relative_info.setVisibility(View.INVISIBLE);


                    isShow = true;

                } else if (isShow) {
                    collapsingToolbarLayout.setTitle(" ");//careful there should a space between double quote otherwise it wont work
                    collapsingToolbarLayout.setBackgroundColor(Color.TRANSPARENT);
                    isShow = false;
                    relative_info.setVisibility(View.VISIBLE);


                }
            }
        });


    }

    private void initViews() {

        cview_1 = findViewById(R.id.cview_1);
        cview_2 = findViewById(R.id.cview_2);
        cview_3 = findViewById(R.id.cview_3);
        cview_4 = findViewById(R.id.cview_4);


        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        relative_info = (RelativeLayout) findViewById(R.id.relative_info);

        recycler_CompanyEmployees = (RecyclerView) findViewById(R.id.recycler_CompanyEmployees);





        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

    }
}

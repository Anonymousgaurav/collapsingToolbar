package com.example.collapsingtoolbar;

import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Collapsing extends AppCompatActivity {
    CollapsingToolbarLayout collapsingToolbarLayout;
    AppBarLayout appBarLayout;
    RelativeLayout relative_info;


    ImageView btn_deleteCompany, btn_editCompany, btn_addManagers;
    EmployeesAdapter employeesAdapter;
    RecyclerView recycler_CompanyEmployees;
    List<Employee_Model> employeeLists = new ArrayList<>();
    TextView tview_profile_cName, tview_profile_companyID, tview_profile_cWebsite;
    String name, number;
    int companyID;
    RelativeLayout relative_Recycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        relative_info = (RelativeLayout) findViewById(R.id.relative_info);



        btn_deleteCompany = (ImageView) findViewById(R.id.btn_deleteCompany);
        btn_editCompany = (ImageView) findViewById(R.id.btn_editCompany);
        recycler_CompanyEmployees = (RecyclerView) findViewById(R.id.recycler_CompanyEmployees);
       // tview_profile_cWebsite = (TextView) findViewById(R.id.tview_profile_cWebsite);
        tview_profile_cName = (TextView) findViewById(R.id.tview_profile_cName);
        tview_profile_companyID = (TextView) findViewById(R.id.tview_profile_companyID);
        btn_addManagers = (ImageView) findViewById(R.id.btn_addManagers);

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
}

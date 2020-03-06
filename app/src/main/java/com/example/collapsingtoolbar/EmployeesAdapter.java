package com.example.collapsingtoolbar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class EmployeesAdapter  extends RecyclerView.Adapter<EmployeesAdapter.EmployeeHolder>
{

    Context context;
    List<Employee_Model> elists;

    public EmployeesAdapter(Context context, List<Employee_Model> elists)
    {
        this.context = context;
        this.elists = elists;
    }

    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_employees, viewGroup, false);
        EmployeeHolder employeeHolder = new EmployeeHolder(v);
        return employeeHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder employeeHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 50;
    }

    public class EmployeeHolder extends RecyclerView.ViewHolder
    {

        public EmployeeHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}



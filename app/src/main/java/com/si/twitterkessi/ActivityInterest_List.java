package com.si.twitterkessi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.si.twitterkessi.adapter.InterestListAdapter;
import com.si.twitterkessi.model.ModelDataSet;

import java.util.ArrayList;
import java.util.List;

public class ActivityInterest_List extends AppCompatActivity {
RecyclerView recyclerView;
Button btn_next;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_interest_list);
        recyclerView=findViewById( R.id.interestsRv );
        btn_next=findViewById( R.id.inte_next );
        textView=findViewById( R.id.inte_tv );

        List<ModelDataSet> interestsList = new ArrayList<>();
        interestsList.add( new ModelDataSet("Sport", "Football", "NBA", "NFL","Soccer","FLY"));
        interestsList.add( new ModelDataSet("Club", "FCB", "RMFC", "LFC","MUFC","MCFC"));
        interestsList.add( new ModelDataSet("Music", "Pop", "Hip-Hop", "Country","Rock","Jazz"));
        interestsList.add( new ModelDataSet("Country", "Nepal", "China", "Japan","Korea","USA"));
        interestsList.add( new ModelDataSet("Shows", "GOT", "BBT", "Friends","Vikings","Prison"));
        interestsList.add( new ModelDataSet("Car", "BMW", "AUDI", "Hundai","Bentley","Chervolt"));
        interestsList.add( new ModelDataSet("Drinks", "Beer", "Wine", "Whiskey","Vodka","GIN"));
        interestsList.add( new ModelDataSet("Movies", "LOTR", "Herculies", "Concuror","HP","Hell"));
        InterestListAdapter interestsAdapter = new InterestListAdapter(this, interestsList);
        recyclerView.setAdapter( interestsAdapter );
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        textView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NextTO();
            }
        } );
        btn_next.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NextTO();
            }
        } );

    }
    void NextTO(){
        Intent intent = new Intent( ActivityInterest_List.this, ActivityDashBoard.class );
        startActivity( intent );
    }
}

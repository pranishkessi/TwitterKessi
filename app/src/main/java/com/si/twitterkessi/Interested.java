package com.si.twitterkessi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.si.twitterkessi.adapter.InterestsAdapter;
import com.si.twitterkessi.model.DataSet;

import java.util.ArrayList;
import java.util.List;

public class Interested extends AppCompatActivity {
RecyclerView recyclerView;
Button btn_next;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_interested );
        recyclerView=findViewById( R.id.interestsRv );
        btn_next=findViewById( R.id.inte_next );
        textView=findViewById( R.id.inte_tv );

        List<DataSet> interestsList = new ArrayList<>();
        interestsList.add( new DataSet("Sport", "Football", "NBA", "NFL","Soccer","FLY"));
        interestsList.add( new DataSet("Club", "FCB", "RMFC", "LFC","MUFC","MCFC"));
        interestsList.add( new DataSet("Music", "Pop", "Hip-Hop", "Country","Rock","Jazz"));
        interestsList.add( new DataSet("Country", "Nepal", "China", "Japan","Korea","USA"));
        interestsList.add( new DataSet("Shows", "GOT", "BBT", "Friends","Vikings","Prison"));
        interestsList.add( new DataSet("Car", "BMW", "AUDI", "Hundai","Bentley","Chervolt"));
        interestsList.add( new DataSet("Drinks", "Beer", "Wine", "Whiskey","Vodka","GIN"));
        interestsList.add( new DataSet("Movies", "LOTR", "Herculies", "Concuror","HP","Hell"));
        InterestsAdapter interestsAdapter = new InterestsAdapter(this, interestsList);
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
        Intent intent = new Intent( Interested.this,DashBoard.class );
        startActivity( intent );
    }
}

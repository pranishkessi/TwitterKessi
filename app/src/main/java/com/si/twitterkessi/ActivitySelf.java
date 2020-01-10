package com.si.twitterkessi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySelf extends AppCompatActivity {
Button btn_next;
TextView tv_skip;
EditText et_bio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_self);
        tv_skip=findViewById( R.id.tv_bio_skip );
        btn_next=findViewById( R.id.btn_bio_next);
        et_bio=findViewById( R.id.et_bio );
        tv_skip.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NextTO();
            }
        } );
        btn_next.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_bio.getText().toString().isEmpty()){
                    Toast.makeText( ActivitySelf.this, "fill your bio first", Toast.LENGTH_SHORT ).show();
                return;}
                else{
                    NextTO();
                }
            }
        } );
    }
    void NextTO(){
        Intent intent = new Intent( ActivitySelf.this, ActivityInterest_List.class );
        startActivity( intent );
    }
}

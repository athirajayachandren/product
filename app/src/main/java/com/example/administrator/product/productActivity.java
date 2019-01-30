package com.example.administrator.product;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class productActivity extends AppCompatActivity {

    EditText a1,a2,a3,a4,a5,a6,a7;
    Button b1;
    String s1,s2,s3,s4,s5,s6,s7;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        a1=(EditText)findViewById(R.id.pmodel);
        a2=(EditText)findViewById(R.id.pcode);
        a3=(EditText)findViewById(R.id.pname);
        a4=(EditText)findViewById(R.id.psname);
        a5=(EditText)findViewById(R.id.price);
        a6=(EditText)findViewById(R.id.owname);
        a7=(EditText)findViewById(R.id.ownernum);
        b1=(Button)findViewById(R.id.submit);

        databaseHelper=new DatabaseHelper(this);
        databaseHelper.getWritableDatabase();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                s1=a1.getText().toString();
                s2=a2.getText().toString();
                s3=a3.getText().toString();
                s4=a4.getText().toString();
                s5=a5.getText().toString();
                s6=a6.getText().toString();
                s7=a7.getText().toString();

                Toast.makeText(getApplicationContext(),s1,Toast.LENGTH_LONG ).show();
                Toast.makeText(getApplicationContext(),s2,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),s3,Toast.LENGTH_LONG ).show();
                Toast.makeText(getApplicationContext(),s4,Toast.LENGTH_LONG ).show();
                Toast.makeText(getApplicationContext(),s5,Toast.LENGTH_LONG ).show();
                Toast.makeText(getApplicationContext(),s6,Toast.LENGTH_LONG ).show();
                Toast.makeText(getApplicationContext(),s7,Toast.LENGTH_LONG ).show();

                boolean status=databaseHelper.insertData(s1,s2,s3,s4,s5,s6,s7);
                if(status==true)
                {
                    Toast.makeText(getApplicationContext(),"succssfullyinserted",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
                }



            }
        });
    }
}

package com.example.pejman.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pejman.presenter.MainActiviyPresenter_DataUser;

public class ActivityMain extends AppCompatActivity implements  View.OnClickListener , MainActiviyPresenter_DataUser.View{

    private EditText edtusername;
    private EditText edtpassword;

    private Button btnsignup;



    private MainActiviyPresenter_DataUser presenter_dataUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFirstObjects();

        setFindViews();






    }

    private void setFirstObjects()
    {

        presenter_dataUser = new MainActiviyPresenter_DataUser(ActivityMain.this , this);

    }



    private void setFindViews()
    {

        edtusername = findViewById(R.id.edtusername);
        edtpassword = findViewById(R.id.edtpassword);

        btnsignup = findViewById(R.id.btnsignup);
        btnsignup.setOnClickListener(this);

    }






    @Override
    public void onClick(View v) {

        switch (v.getId())
        {

            case R.id.btnsignup :
            {

                Log.i("Log" , "Go");
                presenter_dataUser.checkenteruser();
                break;

            }

        }
    }



    @Override
    public void showMessageNull(String message) {

        Toast.makeText(this , message , Toast.LENGTH_SHORT).show();

    }




    @Override
    public void saveSuccessData(String message) {

        Toast.makeText(this , message , Toast.LENGTH_SHORT).show();

    }

    @Override
    public void sigupuser() {


        Log.i("Log" , "2");
        String username = edtusername.getText().toString();
        String password = edtpassword.getText().toString();

        if(presenter_dataUser.serachUserName(username) && presenter_dataUser.serachPassWord(password))
        {

            presenter_dataUser.signupdata(username , password);

        }


    }

    @Override
    public void enteruser(String message) {

        Toast.makeText(this , message , Toast.LENGTH_SHORT).show();

    }



}

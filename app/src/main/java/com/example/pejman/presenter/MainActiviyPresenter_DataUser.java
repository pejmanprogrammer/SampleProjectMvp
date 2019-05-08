package com.example.pejman.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.example.pejman.model.ModelUser;
import com.example.pejman.mvp.R;

public class MainActiviyPresenter_DataUser {

    private ModelUser modelUser;
    private View view;
    private Context context;

    public MainActiviyPresenter_DataUser(Context context , View view)
    {

        this.context = context;
        this.view = view;

        modelUser = new ModelUser(context);


    }






    public boolean serachUserName(String username)
    {


        if(TextUtils.isEmpty(username))
        {

            String message = context.getResources().getString(R.string.message_null_username);

            view.showMessageNull(message);

            return false;

        }

        return  true;

    }


    public boolean serachPassWord(String password)
    {

        if(TextUtils.isEmpty(password))
        {

            String message = context.getResources().getString(R.string.message_null_password);

            view.showMessageNull(message);

            return false;
        }

        return  true;

    }


    public void checkenteruser()
    {

        boolean signupuser = modelUser.checkUser_Signup();
        if(signupuser)
        {

            String message = context.getResources().getString(R.string.message_enter);
            view.enteruser(message);

        }
        else
            view.sigupuser();


    }

    public void signupdata(String username , String password)
    {

        modelUser.savedata_sharedprefrens(username , password);


        String message = context.getResources().getString(R.string.message_success_signup);
        view.saveSuccessData(message);

    }

    public interface View
    {

       void showMessageNull(String message);
       void saveSuccessData(String message);
       void sigupuser();
       void enteruser(String message);

    }
}

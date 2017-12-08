package com.example.donavarghese.myhome;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

/**
 * Created by Donavarghese on 10/18/17.
 */

public class DogsDropdownOnItemClickListener extends FragmentActivity implements OnItemClickListener {

    String TAG = "DogsDropdownOnItemClickListener.java";

    @Override
    public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {

        Context mContext = v.getContext();
      //  Context mContext2 = v.getContext();
        WebPageActivity mainActivity = ((WebPageActivity) mContext);





        // dismiss the pop up
        mainActivity.popupWindowDogs.dismiss();



        // get the id
        String selectedItemTag = v.getTag().toString();
        int num = Integer.parseInt(selectedItemTag);
        switch(num){
            case 1:
                Toast.makeText(mContext, "Living room selected",
                        Toast.LENGTH_SHORT).show();
                Activity activity = ((WebPageActivity) mContext);
                mainActivity.LivingRoom();
                break;
            case 2:
                Toast.makeText(mContext, "Bedroom 1 selected",
                        Toast.LENGTH_SHORT).show();
                mainActivity.Bedroom1();
               break;
            case 3:
                Toast.makeText(mContext, "Bedroom 2 selected",
                        Toast.LENGTH_SHORT).show();
                mainActivity.Bedroom2();
                break;
            case 4:
                Toast.makeText(mContext, "Bedroom 3 selected",
                        Toast.LENGTH_SHORT).show();
                mainActivity.Bedroom3();
               break;
            case 5:
                Toast.makeText(mContext, "Main Menu selected",
                        Toast.LENGTH_SHORT).show();
                mainActivity.MainMenu();
                break;
            default:
                Toast.makeText(mContext, "Something else " ,Toast.LENGTH_SHORT);
        }


    }


}
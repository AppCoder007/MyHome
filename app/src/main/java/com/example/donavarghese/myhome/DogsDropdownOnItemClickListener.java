package com.example.donavarghese.myhome;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.webkit.WebView;
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
                Toast.makeText(mContext, "Dog ID is: " + selectedItemTag,
                        Toast.LENGTH_SHORT).show();
                WebView myWebView = (WebView) findViewById(R.id.webView);

                myWebView.getSettings().setJavaScriptEnabled(true);


                myWebView.loadUrl("http://www.google.com");

               // mainActivity.seebbarr();
             //
               // break;
            case 2:
                Toast.makeText(mContext, "Dog ID is: " + selectedItemTag,
                        Toast.LENGTH_SHORT).show();
              //  break;
            case 3:
                Toast.makeText(mContext, "Dog ID is: " + selectedItemTag,
                        Toast.LENGTH_SHORT).show();
             //   break;
            case 4:
                Toast.makeText(mContext, "Dog ID is: " + selectedItemTag,
                        Toast.LENGTH_SHORT).show();
               // break;
            default:
                Toast.makeText(mContext, "Something else " ,Toast.LENGTH_SHORT);
        }


    }


}
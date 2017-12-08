package com.example.donavarghese.myhome;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class WebPageActivity extends AppCompatActivity {
    String popUpContents[];
    PopupWindow popupWindowDogs;
    Button buttonShowDropDown;
    TextView textView;
    String ip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_page);
        Bundle bundle = getIntent().getExtras();
       ip = bundle.getString("ipAddress");
        WebView myWebView = (WebView) findViewById(R.id.webView);

        myWebView.getSettings().setJavaScriptEnabled(true);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        final Activity activity = this;
        myWebView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });

        myWebView.loadUrl("http://"+ip);
// drop down list

        final AlertDialog.Builder alert = new AlertDialog.Builder(
                this);

        alert.setTitle("Info:");

        alert.setMessage("Select a room to start control lights!!");
        alert.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alert.show();


        List<String> dogsList = new ArrayList<String>();
        dogsList.add("Living Room::1");
        dogsList.add("Bedroom 1::2");
        dogsList.add("Bedroom 2::3");
        dogsList.add("Bedroom 3::4");
        dogsList.add("Main Menu::5");

        // convert to simple array
        popUpContents = new String[dogsList.size()];
        dogsList.toArray(popUpContents);


        // initialize pop up window
        popupWindowDogs = popupWindowDogs();

        // button on click listener

        View.OnClickListener handler = new View.OnClickListener() {
            public void onClick(View v) {

                switch (v.getId()) {

                    case R.id.buttonShowDropDown:
                        // show the list view as dropdown
                        popupWindowDogs.showAsDropDown(v, -5, 0);

                        break;
                }
            }
        };

        // our button
        textView = (TextView) findViewById(R.id.textView);
        // textView.setOnClickListener(handler);
        buttonShowDropDown = (Button) findViewById(R.id.buttonShowDropDown);
        buttonShowDropDown.setOnClickListener(handler);

    }

    private PopupWindow popupWindowDogs() {
        // initialize a pop up window type
        PopupWindow popupWindow = new PopupWindow(this);

        // the drop down list is a list view
        ListView listViewDogs = new ListView(this);

        // set our adapter and pass our pop up window contents
        listViewDogs.setAdapter(dogsAdapter(popUpContents));

        // set the item click listener
        listViewDogs.setOnItemClickListener(new
                DogsDropdownOnItemClickListener());

        // some other visual settings
        popupWindow.setFocusable(true);
        popupWindow.setWidth(500);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);

        // set the list view as pop up window content
        popupWindow.setContentView(listViewDogs);
        return popupWindow;
    }


    private ArrayAdapter<String> dogsAdapter(String dogsArray[]) {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, dogsArray) {

            @Override
            public View getView(int position, View convertView,
                                ViewGroup parent) {

                // setting the ID and text for every items in the list
                String item = getItem(position);
                String[] itemArr = item.split("::");
                String text = itemArr[0];
                String id = itemArr[1];

                // visual settings for the list item
                TextView listItem = new TextView(WebPageActivity.this);

                listItem.setText(text);
                listItem.setTag(id);
                listItem.setTextSize(22);
                listItem.setPadding(10, 10, 10, 10);
                listItem.setTextColor(Color.WHITE);

                return listItem;
            }
        };

        return adapter;
    }


    public void logout(View view){
       Intent intent = new Intent(this, LoginActivity.class);

       startActivity(intent);
   }

public  void LivingRoom(){
    WebView myWebView = (WebView) findViewById(R.id.webView);
    buttonShowDropDown.setText("Living Room");
    myWebView.getSettings().setJavaScriptEnabled(true);

    WebSettings webSettings = myWebView.getSettings();
    webSettings.setUseWideViewPort(true);
    webSettings.setLoadWithOverviewMode(true);

    final Activity activity = this;
    myWebView.setWebViewClient(new WebViewClient() {
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
        }
    });

    myWebView.loadUrl("http://"+ip+"/livingroom.php");
}


    public  void Bedroom1(){
        WebView myWebView = (WebView) findViewById(R.id.webView);
        buttonShowDropDown.setText("Bedroom 1");
        myWebView.getSettings().setJavaScriptEnabled(true);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        final Activity activity = this;
        myWebView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });

        myWebView.loadUrl("http://"+ip+"/bedroom1.php");
    }

    public  void Bedroom2(){
        WebView myWebView = (WebView) findViewById(R.id.webView);
        buttonShowDropDown.setText("Bedroom 2");
        myWebView.getSettings().setJavaScriptEnabled(true);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        final Activity activity = this;
        myWebView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });

        myWebView.loadUrl("http://"+ip+"/bedroom2.php");
    }

    public  void Bedroom3(){
        WebView myWebView = (WebView) findViewById(R.id.webView);
        buttonShowDropDown.setText("Bedroom 3");
        myWebView.getSettings().setJavaScriptEnabled(true);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        final Activity activity = this;
        myWebView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });

        myWebView.loadUrl("http://"+ip+"/bedroom3.php");
    }



    public  void MainMenu(){
        WebView myWebView = (WebView) findViewById(R.id.webView);
        buttonShowDropDown.setText("Main Menu");
        myWebView.getSettings().setJavaScriptEnabled(true);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        final Activity activity = this;
        myWebView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });

        myWebView.loadUrl("http://"+ip);
    }

}

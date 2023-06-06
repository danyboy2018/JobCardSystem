package com.jobcard.david.jobcard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class LoginActivity extends AppCompatActivity {

    private EditText etUserName, etPassword;

    public SharedPreferences.Editor loginPrefsEditor;
    public  SharedPreferences loginPreferences;
    private Boolean saveLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();
        saveLogin = loginPreferences.getBoolean("saveLogin", false);

        findViewById(R.id.Register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(LoginActivity.this , RegisterActivity.class));
            }
        });

        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);


        if (saveLogin == true) {
            etUserName.setText(loginPreferences.getString("username", ""));
            etPassword.setText(loginPreferences.getString("password", ""));

            new LoginCheckActivity(this).execute();
        }



    }


    public void loginup(View v) {

        String userName = etUserName.getText().toString();
        String passWord = etPassword.getText().toString();

        loginPrefsEditor.putBoolean("saveLogin", true);
        loginPrefsEditor.putString("username", userName);
        loginPrefsEditor.putString("password", passWord);
        loginPrefsEditor.commit();


        //new LoginCheckActivity(this).execute(userName, passWord );
        new LoginCheckActivity(this).execute();

    }
}



class LoginCheckActivity extends AsyncTask<String, Void, String> {

    private Context context;

    public LoginCheckActivity(Context context)
    {
        this.context = context;
    }

    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(String... arg0) {


        SharedPreferences prefs = context.getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
        String userNameRetrive = prefs.getString("username",null);
        String passWordRetrive = prefs.getString("password",null);


        String userName = userNameRetrive;
        String passWord = passWordRetrive;


        String link;
        String data;
        BufferedReader bufferedReader;
        String result;

        try {

            //---------------------    Writer section --------------------------

            data = "username=" + URLEncoder.encode(userName, "UTF-8");
            data += "&password=" + URLEncoder.encode(passWord, "UTF-8");


            //link = "http://192.168.101.72/php/app/login.php";
            link = "http://10.0.0.26/php/app/login.php";
            //link = "https://hostme591.000webhostapp.com/login.php";

            URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            OutputStream outputStream = con.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream , "UTF-8"));


            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();


            //---------------------    Reader section --------------------------



            InputStream inputStream = con.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            result = bufferedReader.readLine();

            bufferedReader.close();
            inputStream.close();
            con.disconnect();

            return result;

        } catch (Exception e) {
            return new String("Exception: " + e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String result) {
        String jsonStr = result;
        Log.d("jsonStrrr" ,jsonStr);
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                String query_result = jsonObj.getString("query_result");
                Log.d("in_if" ,query_result);



                //String username = jsonObj.getString("username");
                //String password = jsonObj.getString("password");

                Log.d("query_resulttt" ,query_result);
                if (query_result.equals("SUCCESS")) {

                    //Toast.makeText(context, "Login successful.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(context,UserActivity.class);
                    intent.putExtra("jsonStr", jsonStr);
                    context.startActivity(intent);

                    //Toast.makeText(context, "Login successful.", Toast.LENGTH_SHORT).show();
                    //Intent i = new Intent(context , UserActivity.class);
                    //context.startActivity(i);

                } else if (query_result.equals("FAILURE")) {
                    Toast.makeText(context, "No User Found, please try again.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Couldn't connect to remote database.", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(context, "Error parsing JSON data.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "Couldn't get any JSON data.", Toast.LENGTH_SHORT).show();
        }
    }
}


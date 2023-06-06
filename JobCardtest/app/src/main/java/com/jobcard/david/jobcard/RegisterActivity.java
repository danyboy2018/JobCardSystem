package com.jobcard.david.jobcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
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


public class RegisterActivity extends AppCompatActivity {
    private EditText etFullName, etUserName, etPassword;
    private Spinner SpSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etFullName = (EditText) findViewById(R.id.etFullName);
        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        SpSpinner =  (Spinner) findViewById(R.id.SpSpinner);
    }

    public void signup(View v) {
        String fullName = etFullName.getText().toString();
        String userName = etUserName.getText().toString();
        String passWord = etPassword.getText().toString();
        String Role = SpSpinner.getSelectedItem().toString();


        Toast.makeText(this, "Signing up...", Toast.LENGTH_SHORT).show();
        new SignupActivity(this).execute(fullName, userName, passWord, Role);
    }
}


class SignupActivity extends AsyncTask<String, Void, String> {

    private Context context;

    public SignupActivity(Context context)
    {
        this.context = context;
    }

    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(String... arg0) {
        String fullName = arg0[0];
        String userName = arg0[1];
        String passWord = arg0[2];
        String Role = arg0[3];


        String link;
        String data;
        BufferedReader bufferedReader;
        String result;

        try {

            //---------------------    Writer section --------------------------

            data = "fullname=" + URLEncoder.encode(fullName, "UTF-8");
            data += "&username=" + URLEncoder.encode(userName, "UTF-8");
            data += "&password=" + URLEncoder.encode(passWord, "UTF-8");
            data += "&role=" + URLEncoder.encode(Role, "UTF-8");

            //Log.d("data" ,data);


            link = "https://hostme591.000webhostapp.com/signup.php";
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
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                String query_result = jsonObj.getString("query_result");
                if (query_result.equals("SUCCESS")) {
                    Thread thread = new Thread(){
                        public void run() {
                            try {
                                Thread.sleep(2800);
                                Intent i = new Intent(context , LoginActivity.class);
                                context.startActivity(i);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    Toast.makeText(context, "Data inserted successfully. Signup successful.", Toast.LENGTH_SHORT).show();
                    thread.start();

                    //---------------------    option to show the Toast after moving to LoginActivity --------------------------

                    //final Intent i = new Intent(this.context, LoginActivity.class);
                    //i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    //context.startActivity(i);
                    //Toast.makeText(context, "Data inserted successfully. Signup successful.", Toast.LENGTH_SHORT).show();
                } else if (query_result.equals("FAILURE")) {
                    Toast.makeText(context, "Data could not be inserted. Signup failed.", Toast.LENGTH_SHORT).show();
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

package com.example.cs.groupassignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class MainActivity3 extends AppCompatActivity {

    ProgressDialog progressDialog;
    String finalResult ;
    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();
    EditText StudentName, StudentPhoneNumber, StudentClass;
    String ID, Name, Email ,Phone, Gender, University, Course;

    Spinner studentspn;
    private EditText idTxt;
    private EditText nameTxt;
    private EditText emailTxt;
    private EditText phoneTxt;
    Spinner genderSpn ;
    Spinner courseSpn;
    private EditText UniversityTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setUpViews();

        // Receive Student ID, Name , Phone Number , Class Send by previous ShowSingleRecordActivity.
        ID = getIntent().getStringExtra("Id");
        Name = getIntent().getStringExtra("Name");
        Email = getIntent().getStringExtra("Number");
        Phone = getIntent().getStringExtra("Class");
        Gender = getIntent().getStringExtra("Class");
        University = getIntent().getStringExtra("Class");
        Course = getIntent().getStringExtra("Class");

        // Setting Received Student Name, Phone Number, Class into EditText.
        nameTxt.setText(Name);
        emailTxt.setText(Email);
        phoneTxt.setText(Phone);
        genderSpn.autofill(AutofillValue.forText(Gender));
        courseSpn.autofill(AutofillValue.forText(Course));
        UniversityTxt.setText(University);

    }

    private void setUpViews() {
        idTxt =  findViewById(R.id.IdTxt);
        nameTxt =  findViewById(R.id.nameTxt);
        emailTxt = findViewById(R.id.emailTxt);
        phoneTxt = findViewById(R.id.phoneTxt);
        genderSpn = findViewById(R.id.genderSpn);
        UniversityTxt =findViewById(R.id.UniversityTxt);
        courseSpn = findViewById(R.id.courseSpn);
    }

    public void btnUpdate_OnClick(View view) {
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
        String restUrl = "http://10.0.2.2/groupAss1/update.php";

        // Getting data from EditText after button click.
        GetDataFromEditText();

        // Sending Student Name, Phone Number, Class to method to update on server.
        StudentRecordUpdate(ID,Name,Email, Phone,Gender,Course,University);
    }



    // Method to get existing data from EditText.
    public void GetDataFromEditText(){

        Name = nameTxt.getText().toString();
        Email = emailTxt.getText().toString();
        Phone = phoneTxt.getText().toString();
        Gender = genderSpn.getTransitionName();
        Course = courseSpn.getTransitionName();
        University = UniversityTxt.getText().toString();

    }

    // Method to Update Student Record.
    public void StudentRecordUpdate(final String ID, final String Name, final String Email, final String Phone, final String Gender, final String Course, final String University){

        class StudentRecordUpdateClass extends AsyncTask<String,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(MainActivity3.this,"Loading Data",null,true,true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();

                Toast.makeText(MainActivity3.this,httpResponseMsg.toString(), Toast.LENGTH_LONG).show();

            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("StudentID",params[0]);

                hashMap.put("StudentName",params[1]);

                hashMap.put("StudentPhone",params[2]);

                hashMap.put("StudentClass",params[3]);

                finalResult = httpParse.postRequest(hashMap, HttpURL);

                return finalResult;
            }
        }

        StudentRecordUpdateClass studentRecordUpdateClass = new StudentRecordUpdateClass();

        studentRecordUpdateClass.execute(ID,S_Name,S_Phone,S_Class);
    }

    private class SendPostRequest extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            try {
                return processRequest(urls[0]);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return "";
        }
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(MainActivity3.this, "New Student record created successfully", Toast.LENGTH_LONG).show();
        }
    }

}
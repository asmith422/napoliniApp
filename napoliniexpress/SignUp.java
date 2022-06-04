package com.example.napoliniexpress;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {
    public static final String TAG = "TAG";
    Button btnSignUp;
    EditText editPhone, editemail, editFirstName, editLastName, editPassword, editAddress, editCity, editState, editZipCode;
    TextView signup, existingAccount;
    ImageView logo;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;
    ProgressBar progressBar;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editemail = (EditText) findViewById(R.id.editemail);
        editPhone = (EditText) findViewById(R.id.editPhone);
        editFirstName = (EditText) findViewById(R.id.editFirstName);
        editLastName = (EditText) findViewById(R.id.editLastName);
        editPassword = (EditText) findViewById(R.id.editPassword);
        editAddress = (EditText) findViewById(R.id.editAddress);
        editCity = (EditText) findViewById(R.id.editCity);
        editState = (EditText) findViewById(R.id.editState);
        editZipCode = (EditText) findViewById(R.id.editZipCode);

        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        signup = (TextView) findViewById(R.id.signup);
        existingAccount = (TextView) findViewById(R.id.existingAccount);
        logo = (ImageView) findViewById(R.id.logo);

        mAuth=FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        progressBar = (ProgressBar) findViewById(R.id.progressBar);


/*
        if(mAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity2.class));
            finish();
        }

 */

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = editemail.getText().toString().trim();
                final String password = editPassword.getText().toString().trim();
                final String firstName = editFirstName.getText().toString();
                final String lastName = editLastName.getText().toString();
                final String phone    = editPhone.getText().toString();
                final String address    = editAddress.getText().toString();
                final String city    = editCity.getText().toString();
                final String state    = editState.getText().toString();
                final String zipcode    = editZipCode.getText().toString();

                if(TextUtils.isEmpty(email)){
                    editemail.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    editPassword.setError("Password is Required.");
                    return;
                }

                if(password.length() < 6){
                    editPassword.setError("Password Must be at least 6 Characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                Connection con = ConnectionClass();
                try {
                    if(con !=null) {
                        String Q = "exec dbo.Insert_Customer_SP '" + firstName + "','" + lastName + "','" + phone + "','" + address + "','" + city + "','" + state + "','" + zipcode + "' ";
                        Statement statement = con.createStatement();
                        ResultSet result = statement.executeQuery(Q);
                        Toast.makeText(SignUp.this, "Successfully added to SQL", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        Toast.makeText(SignUp.this, "Error in connection", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception ex){
                    Log.e("Set Error",ex.getMessage());
                }

                // register the user in firebase


                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            // send verification link

                            FirebaseUser fuser = mAuth.getCurrentUser();
                            fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(SignUp.this, "Verification Email Has been Sent.", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure: Email not sent " + e.getMessage());
                                }
                            });

                            Toast.makeText(SignUp.this, "User Created.", Toast.LENGTH_SHORT).show();
                            userID = mAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("users").document(userID);
                            Map<String,Object> user = new HashMap<>();
                            user.put("fName",firstName);
                            user.put("lName", lastName);
                            user.put("email",email);
                            user.put("phone",phone);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "onSuccess: user Profile is created for "+ userID);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure: " + e.toString());
                                }
                            });
                            startActivity(new Intent(getApplicationContext(),MainActivity2.class));

                        }else {
                            Toast.makeText(SignUp.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        existingAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignIn.class));

            }
        });





    }

    @SuppressLint("NewApi")
    public Connection ConnectionClass()
    {
        String ip="10.22.13.242", port="1433", dbname="ASmith53", dbuser ="ASmith53", dbpass="H702527959";
        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Connection connection=null;
        String connectURL=null;

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            String connectionUrl = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";databasename=" + dbname + ";User=" + dbuser + ";password=" + dbpass + ";";
            connection= DriverManager.getConnection(connectionUrl);
        }
        catch (Exception ex){
            Log.e("Set Error",ex.getMessage());
        }
        return connection;
    }
}

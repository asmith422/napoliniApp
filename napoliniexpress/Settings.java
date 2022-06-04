package com.example.napoliniexpress;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
//import com.squareup.picasso.Picasso;

public class Settings extends AppCompatActivity {
    public static final String TAG = "TAG";
    private static final int GALLERY_INTENT_CODE = 1023 ;
    EditText firstName, lastName, email, phone, address, city, state, zipCode;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;
    Button btnUpdate, btnLogout;
    FirebaseUser user;
    ImageView profileImage;
    StorageReference storageReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        firstName = findViewById(R.id.profileFirstName);
        lastName = findViewById(R.id.profileLastName);
        email = findViewById(R.id.profileEmail);
        phone = findViewById(R.id.profilePhoneNumber);
        address = findViewById(R.id.profileAddress);
        city = findViewById(R.id.profileCity);
        state = findViewById(R.id.profileState);
        zipCode = findViewById(R.id.profileZip);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnLogout = findViewById(R.id.btnLogout);


        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout(this);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Settings.this, "Account Updated.", Toast.LENGTH_SHORT).show();
            }
        });

        userId = fAuth.getCurrentUser().getUid();
        user = fAuth.getCurrentUser();

/*
        DocumentReference documentReference = fStore.collection("users").document(userId);
        ((DocumentReference) documentReference).addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if(documentSnapshot.exists()){
                    email.setText(documentSnapshot.getString("email"));
                    firstName.setText(documentSnapshot.getString("fName"));
                    lastName.setText(documentSnapshot.getString("lname"));
                    phone.setText(documentSnapshot.getString("phone"));
                    address.setText(documentSnapshot.getString("address"));
                    city.setText(documentSnapshot.getString("city"));
                    state.setText(documentSnapshot.getString("state"));
                    zipCode.setText(documentSnapshot.getString("zipcode"));

                }else {
                    Log.d(TAG, "onEvent: Document do not exists");
                }
            }
        });

 */
/*
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname=firstName.getText().toString();
                String lname=lastName.getText().toString();
                String p= phone.getText().toString();
                final String a    = address.getText().toString();
                final String c    = city.getText().toString();
                final String s    = state.getText().toString();
                final String z    = zipCode.getText().toString();

                Connection con = ConnectionClass();
                try {
                    if(con !=null) {
                        String Q = "exec dbo.Update_Customer_SP '" + fname + "','" + lname + "','" + a + "','" + c + "','" + s + "','" + z + "' ";
                        Statement statement = con.createStatement();
                        ResultSet result = statement.executeQuery(Q);
                        Toast.makeText(Settings.this, "Successfully Updated to SQL", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        Toast.makeText(Settings.this, "Error in connection", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception ex){
                    Log.e("Set Error",ex.getMessage());
                }

            }
        });

 */

/*
        changeProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // open gallery
                Intent i = new Intent(v.getContext(),EditProfile.class);
                i.putExtra("fullName",fullName.getText().toString());
                i.putExtra("email",email.getText().toString());
                i.putExtra("phone",phone.getText().toString());
                startActivity(i);
//

            }
        });

 */


    }
/*
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

 */


    public void logout(View.OnClickListener view) {
        FirebaseAuth.getInstance().signOut();//logout
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }
}

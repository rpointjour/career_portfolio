package com.fau_cop4655_Z23572422.mystockapppoc;

import androidx.annotation.NonNull;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends Activity {

    static List<String> cFavorites;
    private FirebaseAuth mAuth;
    private EditText pw;
    private EditText un;
    public Button login;
    private Button signup;
    private TextView error;
    static FirebaseUser mUser;

    SignInButton signin;
    GoogleSignInClient mGoogleSignInClient;
    int RC_SIGN_IN = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Attach views
        signup = findViewById(R.id.signup);
        pw = findViewById(R.id.pw);
        un = findViewById(R.id.un);
        login = findViewById(R.id.login);
        error = findViewById(R.id.error);

        //Init firebase
        mAuth = FirebaseAuth.getInstance();

    }

    public static FirebaseUser getUser(){
        return mUser;
    }


    public void onLoginClick(View v){
        String email = un.getText().toString();
        String password = pw.getText().toString();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            mUser = mAuth.getCurrentUser();
                            error.setText("signInWithEmail:success " +  mUser.getEmail().toString());
                            Intent intent = new Intent(v.getContext(), BottomNavActivity.class);
                            cFavorites = new ArrayList<String>();
                            startActivity(intent);

                        } else {
                            // If sign in fails, display a message to the user.
                            error.setText("signInWithEmail:failure" +  task.getException().toString());

                        }
                    }
                });

    }

    public static List<String> getFavs(){
        return cFavorites;
    }

    public static void setFavs(List<String> s){
        cFavorites = s;
    }

    public static void addFav(String s){
        cFavorites.add(s);
    }

    public static boolean isFav(String s){
        for(String k : cFavorites){
            if(k.equals(s)){
                return true;
            }

        }
        return false;
    }

    public static void remFav(String s){
        if (isFav(s)){
            cFavorites.remove(s);
        }
        return;
    }



    public void onSignupClick(View v){
        String email = un.getText().toString();
        String password = pw.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            error.setText("createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            error.setText("createUserWithEmail:failure" + task.getException().toString());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });


    }

}


package com.example.shopnow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    EditText editTextPhone, editTextCode;
    FirebaseAuth mAuth;
    String codeSent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCode = findViewById(R.id.verificationCodeEditText);
        editTextPhone = findViewById(R.id.phoneEditText);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.verifyButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifySignInCode();
            }
        });

        findViewById(R.id.logInButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Logging in", Toast.LENGTH_SHORT).show();
                sendVerificationCode();
            }
        });

    }

    private void verifySignInCode(){

        String code = editTextCode.getText().toString();
        if(code.isEmpty()){
            editTextCode.setError("Code is required");
            editTextCode.requestFocus();
            return;
        }
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeSent, code);
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Login Successful",
                                    Toast.LENGTH_LONG).show();
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "signInWithCredential:success");
//
//                            FirebaseUser user = task.getResult().getUser();
//                            // ...
                        } else {
//                            // Sign in failed, display a message and update the UI
//                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                Toast.makeText(getApplicationContext(), "Invalid Code",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });
    }

    private void sendVerificationCode(){
        String phone = editTextPhone.getText().toString();
        if(phone.isEmpty()){
            editTextPhone.setError("Phone Number is required");
            editTextPhone.requestFocus();
            return;
        }
        if(phone.length()<10){
            editTextPhone.setError("Please enter a valid phone number");
            editTextPhone.requestFocus();
            return;
        }
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,        // Phone number to verify
                10,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks
    }
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            //super.onCodeSent(s, forceResendingToken);
            codeSent = s;
        }
    };
}

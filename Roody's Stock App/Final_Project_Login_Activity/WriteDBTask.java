package com.fau_cop4655_Z23572422.mystockapppoc;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

public class WriteDBTask extends TimerTask {
    @Override
    public void run() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> user = new HashMap<>();
        List<String> str = LoginActivity.getFavs();
        user.put("Favorites", str);
        System.out.println("Timer DB Write");

        // Add a new document with a generated ID
        db.collection("users").document(LoginActivity.getUser().getEmail())
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        System.out.println("DATABASE WRITE WORKED");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("Error adding document");
                    }
                });

    }

}


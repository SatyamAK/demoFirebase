package org.prograd.demoFirebase.services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.prograd.demoFirebase.models.MyUser;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class UserService {

    public String createUser(MyUser user) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = firestore.
                collection("users").
                document(user.getUser_id()).
                set(user);

        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public MyUser getUser(String userId) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection("users").document(userId);
        ApiFuture<DocumentSnapshot> documentSnapshotFuture = documentReference.get();
        DocumentSnapshot documentSnapshot = documentSnapshotFuture.get();

        MyUser user;

        if(documentSnapshot.exists()){
            user = documentSnapshot.toObject(MyUser.class);
            return user;
        }

        return null;
    }

    public String updateUser(MyUser user) throws ExecutionException, InterruptedException{
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = firestore.collection("users").
                document(user.getUser_id()).
                set(user);

        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public String deleteUser(String userId) throws ExecutionException, InterruptedException{
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResultApiFuture = firestore.collection("users").document(userId).delete();
        return "User Deleted with User Id "+userId;
    }
}

package studio.in.prakharshuka.googleauthaign_in;

import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {


    FirebaseAuth mAuth;
    FirebaseUser mUser;
    TextView Name,Email;
    ImageView ProfilePic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Name = findViewById(R.id.name);
        Email = findViewById(R.id.email);
        ProfilePic = findViewById(R.id.profilepic);

        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        String name,email;
        Uri photourl;

        assert mUser != null;
        name=mUser.getDisplayName();
        email=mUser.getEmail();
        photourl=mUser.getPhotoUrl();


        Toast.makeText(this, "This is the URL "+photourl, Toast.LENGTH_SHORT).show();
        Name.setText(name);
        Email.setText(email);

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.person)
                .error(R.drawable.person);
        Glide.with(ProfileActivity.this).load(mUser.getPhotoUrl()).apply(options).into(ProfilePic);






    }
}

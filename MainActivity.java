package com.example.stijn.ikpmd5;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("AVfleet Login");
        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);

        Info.setText("Aantal inlogpogingen resterend: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.click);
                mediaPlayer.start();
                validate(Name.getText().toString(), Password.getText().toString());

            }
        });
    }
    private void validate(String userName, String userPassword){
        if(userName.equals("Admin") && userPassword.equals("1234")){
            Intent intent = new Intent(MainActivity.this, BootActivity.class);
            Bundle b = new Bundle();
            String naam = Name.getText().toString();
            b.putString("gebruiker", naam);
            intent.putExtras(b);
            startActivity(intent);
        }
        if(userName.equals("Stijn") && userPassword.equals("1234")){
            Intent intent = new Intent(MainActivity.this, BootActivity.class);
            Bundle b = new Bundle();
            String naam = Name.getText().toString();
            b.putString("gebruiker", naam);
            intent.putExtras(b);
            startActivity(intent);
        }
        if(userName.equals("Marinus") && userPassword.equals("1234")){
            Intent intent = new Intent(MainActivity.this, BootActivity.class);
            Bundle b = new Bundle();
            String naam = Name.getText().toString();
            b.putString("gebruiker", naam);
            intent.putExtras(b);
            startActivity(intent);
        }
        if(userName.equals("Michiel") && userPassword.equals("1234")){
            Intent intent = new Intent(MainActivity.this, BootActivity.class);
            Bundle b = new Bundle();
            String naam = Name.getText().toString();
            b.putString("gebruiker", naam);
            intent.putExtras(b);
            startActivity(intent);
        }else{
            counter--;

            Info.setText("Aantal inlogpogingen resterend: " + String.valueOf(counter));

            if (counter == 0){
                Login.setEnabled(false);
            }
        }
    }
}

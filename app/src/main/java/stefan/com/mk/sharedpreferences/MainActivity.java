package stefan.com.mk.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mUserNameInput;
    private EditText mPassInput;
    private Button mSaveInfo;
    private Button mDisplayInfo;
    private TextView mDisplayInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserNameInput = (EditText) findViewById(R.id.usernameInput);
        mPassInput = (EditText) findViewById(R.id.passwordInput);
        mDisplayInfoTextView = (TextView) findViewById(R.id.displayInfoTextView);

        mSaveInfo = (Button) findViewById(R.id.saveInfoButton);
        mSaveInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences spref = getSharedPreferences("userInput", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = spref.edit();
                editor.putString("username", mUserNameInput.getText().toString());
                editor.putString("password", mPassInput.getText().toString());
                editor.apply();
            }
        });

        mDisplayInfo = (Button) findViewById(R.id.displayInfoButton);
        mDisplayInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences spref = getSharedPreferences("userInput", Context.MODE_PRIVATE);

                String username = spref.getString("username", "");
                String pass = spref.getString("password", "");

                mDisplayInfoTextView.setText(username + " " + pass);
            }
        });
    }
}

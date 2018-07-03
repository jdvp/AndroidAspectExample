package me.jdvp.androidaspectexample.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;
import me.jdvp.androidaspectexample.R;

public class MainActivity extends DaggerAppCompatActivity {
    @BindView(R.id.button_1)
    Button button1;

    @BindView(R.id.button_2)
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //Not a lambda on purpose
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(v -> Toast.makeText(MainActivity.this, "Button 2 clicked", Toast.LENGTH_SHORT).show());
    }
}

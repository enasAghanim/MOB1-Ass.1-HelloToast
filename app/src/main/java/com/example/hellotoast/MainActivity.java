package com.example.hellotoast;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hellotoast.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (view, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(
                    systemBars.left,
                    systemBars.top,
                    systemBars.right,
                    systemBars.bottom
            );
            return insets;
        });
    }

    public void show_toast(View view) {
        Toast.makeText(this, "Hello Toast", Toast.LENGTH_SHORT).show();
    }

    public void increase_count(View view) {
        count++;
        mainBinding.textDesplayCount.setText(String.valueOf(count));

        if (count % 2 == 0) {
            changeButtonColor(mainBinding.buttonCount, R.color.blue);
        } else {
            changeButtonColor(mainBinding.buttonCount, R.color.green);
        }

        changeButtonColor(mainBinding.buttonZero, R.color.orange);
    }

    public void show_zero(View view) {
        count = 0;
        mainBinding.textDesplayCount.setText(String.valueOf(count));
        changeButtonColor(mainBinding.buttonZero, R.color.gray);
    }

    private void changeButtonColor(View button, int colorId) {
        int color = ContextCompat.getColor(this, colorId);
        button.setBackgroundTintList(ColorStateList.valueOf(color));
    }
}
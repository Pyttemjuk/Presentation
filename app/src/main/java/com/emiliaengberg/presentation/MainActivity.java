package com.emiliaengberg.presentation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mGoToCvButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sets up the button and onClick listener that when clicked starts the cv activity
        mGoToCvButton = findViewById(R.id.presentation_button);
        mGoToCvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CvActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflates menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        //Intent for starting the interest activity
        Intent intent = new Intent(MainActivity.this, InterestActivity.class);
        //Switch statement that handles what happens when user clicks on item in menu
        switch (id) {
            case R.id.menu_item_presentation:
                return true;
            case R.id.menu_item_filmer:
                intent.putExtra(InterestActivity.EXTRA_MESSAGE, R.id.menu_item_filmer);
                startActivity(intent);
                return true;
            case R.id.menu_item_pilbage:
                intent.putExtra(InterestActivity.EXTRA_MESSAGE, R.id.menu_item_pilbage);
                startActivity(intent);
                return true;
            case R.id.menu_item_korsstygnsbroderi:
                intent.putExtra(InterestActivity.EXTRA_MESSAGE, R.id.menu_item_korsstygnsbroderi);
                startActivity(intent);
                return true;
            case R.id.menu_item_kinesiska:
                intent.putExtra(InterestActivity.EXTRA_MESSAGE, R.id.menu_item_kinesiska);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
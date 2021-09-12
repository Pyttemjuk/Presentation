package com.emiliaengberg.presentation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class InterestActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE="msg";
    private TextView mInterestHeaderTextView;
    private TextView mInterestBodyTextView;
    private ImageView mInterestImageView;
    private int mInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

        //Sets up the views
        mInterestHeaderTextView = findViewById(R.id.interest_heading);
        mInterestImageView = findViewById(R.id.interest_photo);
        mInterestBodyTextView = findViewById(R.id.interest_text);

        //Get intent extra
        mInterest = getIntent().getIntExtra(EXTRA_MESSAGE, 0);

        //Switch statement that loads correct information into the views based on user selection
        //in menu
        switch (mInterest) {
            case R.id.menu_item_filmer:
                mInterestHeaderTextView.setText(R.string.menu_item_filmer);
                mInterestImageView.setImageResource(R.drawable.filmer);
                mInterestBodyTextView.setText(R.string.filmer_text);
                return;
            case R.id.menu_item_pilbage:
                mInterestHeaderTextView.setText(R.string.menu_item_pilbage);
                mInterestImageView.setImageResource(R.drawable.pilbagsskytte);
                mInterestBodyTextView.setText(R.string.pilbage_text);
                return;
            case R.id.menu_item_korsstygnsbroderi:
                mInterestHeaderTextView.setText(R.string.menu_item_kosstygnsbroderi);
                mInterestImageView.setImageResource(R.drawable.korsstygnsbroderi);
                mInterestBodyTextView.setText(R.string.korsstygnsbroderi_text);
                return;
            case R.id.menu_item_kinesiska:
                mInterestHeaderTextView.setText(R.string.menu_item_kinesiska);
                mInterestImageView.setImageResource(R.drawable.kinesiska);
                mInterestBodyTextView.setText(R.string.kinesiska_text);
                return;
            default:
                mInterestHeaderTextView.setText(R.string.intresse_rubrik_placeholder);
                mInterestBodyTextView.setText(R.string.intresse_text_placeholder);
        }
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
        Intent intent = new Intent(InterestActivity.this, InterestActivity.class);
        //Switch statement that handles what happens when user clicks on item in menu
        switch (id) {
            case R.id.menu_item_presentation:
                //Intent for going back to main activity
                Intent intent2 = new Intent(InterestActivity.this, MainActivity.class);
                startActivity(intent2);
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
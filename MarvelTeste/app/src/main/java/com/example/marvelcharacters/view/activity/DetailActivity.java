package com.example.marvelcharacters.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marvelcharacters.R;
import com.example.marvelcharacters.model.pojo.Result;
import com.squareup.picasso.Picasso;

import static com.example.marvelcharacters.view.activity.HomeActivity.RESULT_KEY;

public class DetailActivity extends AppCompatActivity {

    private ImageView imgCharacter, imgCharacterTwo;
    private TextView titleview, descview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initViews();
        receivesData();

    }

    public void receivesData (){
        if (getIntent() != null && getIntent().getExtras() != null) {
            Result result = getIntent().getExtras().getParcelable(RESULT_KEY);
            setViews(result);
            loadImage(result);
        }

    }

    private void setViews(Result result) {
        titleview.setText(result.getName());
        descview.setText(result.getDescription());
    }

    private void loadImage(Result result) {
        Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgCharacter);
        Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgCharacterTwo);

    }

    public void initViews() {
        titleview = findViewById(R.id.title_character);
        descview = findViewById(R.id.description_character);
        imgCharacter = findViewById(R.id.img_character);
        imgCharacterTwo = findViewById(R.id.img_character_two);
    }
}

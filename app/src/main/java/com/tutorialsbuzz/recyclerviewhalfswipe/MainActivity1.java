package com.tutorialsbuzz.recyclerviewhalfswipe;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorialsbuzz.halfswipe.SwipeHelper;
import com.tutorialsbuzz.recyclerview.CustomAdapter;
import com.tutorialsbuzz.recyclerview.Model;

import java.util.List;

public class MainActivity1 extends AppCompatActivity {

    RecyclerView recyclerview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = findViewById(R.id.rcv);

        List<Model> modelList = Utils.Companion.readFromAsset(getApplicationContext());

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity1.this);
        recyclerview.setLayoutManager(layoutManager);

        recyclerview.addItemDecoration(new SimpleDividerItemDecoration(this));

        CustomAdapter customAdapter = new CustomAdapter(modelList, this);
        recyclerview.setAdapter(customAdapter);

        new SwipeHelper(this, recyclerview, true) {

            @Override
            public void instantiateUnderlayButton(RecyclerView.ViewHolder viewHolder,
                                                  List<UnderlayButton> underlayButtons) {

                underlayButtons.add(new UnderlayButton("Archive",
                        AppCompatResources.getDrawable(
                                MainActivity1.this,
                                R.drawable.ic_archive_black_24dp
                        ),
                        Color.parseColor("#000000"), Color.parseColor("#ffffff"), new UnderlayButtonClickListener() {
                    @Override
                    public void onClick(int pos) {

                        Toast.makeText(MainActivity1.this, "Archive", Toast.LENGTH_SHORT).show();

                    }
                }));


                underlayButtons.add(new UnderlayButton("Flag",
                        AppCompatResources.getDrawable(
                                MainActivity1.this,
                                R.drawable.ic_flag_black_24dp
                        ),
                        Color.parseColor("#FF0000"), Color.parseColor("#ffffff"), new UnderlayButtonClickListener() {
                    @Override
                    public void onClick(int pos) {
                        Toast.makeText(MainActivity1.this, "Flag", Toast.LENGTH_SHORT).show();

                    }
                }));


                underlayButtons.add(new UnderlayButton("More",
                        AppCompatResources.getDrawable(
                                MainActivity1.this,
                                R.drawable.ic_more_horiz_black_24dp
                        ),
                        Color.parseColor("#00FF00"), Color.parseColor("#ffffff"), new UnderlayButtonClickListener() {
                    @Override
                    public void onClick(int pos) {
                        Toast.makeText(MainActivity1.this, "More", Toast.LENGTH_SHORT).show();

                    }
                }));

            }
        };


    }


}

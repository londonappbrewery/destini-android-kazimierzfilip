package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mButtonTop;
    private Button mButtonBottom;
    private Button mButtonReset;
    private int mStoryIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            mStoryIndex = savedInstanceState.getInt("StoryIndexKey");
        } else {
            mStoryIndex = 1;
        }

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);
        mButtonReset = (Button)findViewById(R.id.buttonReset);


        showStory();


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pushStory(true);
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pushStory(false);
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStoryIndex = 1;
                mButtonReset.setVisibility(View.INVISIBLE);
                mButtonTop.setVisibility(View.VISIBLE);
                mButtonBottom.setVisibility(View.VISIBLE);
                showStory();
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("StoryIndexKey",mStoryIndex);
    }

    private void showStory() {
        switch (mStoryIndex) {
            case 1:
                mStoryTextView.setText(R.string.T1_Story);
                mButtonTop.setText(R.string.T1_Ans1);
                mButtonBottom.setText(R.string.T1_Ans2);
                break;
            case 2:
                mStoryTextView.setText(R.string.T2_Story);
                mButtonTop.setText(R.string.T2_Ans1);
                mButtonBottom.setText(R.string.T2_Ans2);
                break;
            case 3:
                mStoryTextView.setText(R.string.T3_Story);
                mButtonTop.setText(R.string.T3_Ans1);
                mButtonBottom.setText(R.string.T3_Ans2);
                break;
            case 4:
                mStoryTextView.setText(R.string.T4_End); break;
            case 5:
                mStoryTextView.setText(R.string.T5_End); break;
            case 6:
                mStoryTextView.setText(R.string.T6_End); break;
        }
        if (mStoryIndex >= 4) {
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
            mButtonReset.setVisibility(View.VISIBLE);
        }
    }

    private void pushStory(boolean answer){
        if(answer) { // buttonTop pushed
            switch(mStoryIndex){
                case 1: mStoryIndex=3; break;
                case 2: mStoryIndex=3; break;
                case 3: mStoryIndex=6; break;
            }
        } else { // buttonBottom pushed
            switch(mStoryIndex) {
                case 1: mStoryIndex=2; break;
                case 2: mStoryIndex=4; break;
                case 3: mStoryIndex=5; break;
            }
        }
        showStory();
    }
}

package com.unacademy.task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.unacademy.task.customViews.CircularProgressBarView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MAIN";
    private Toolbar mToolbar;

    private EditText et_value_progress;
    private Button btn_submit;

    private CircularProgressBarView circularProgressBarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();

        initViews();

        initListeners();
    }

    private void initToolbar() {
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        assert getSupportActionBar()!=null;
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void initViews() {
        et_value_progress=findViewById(R.id.et_value_progress);
        btn_submit=findViewById(R.id.btn_submit);
        circularProgressBarView=findViewById(R.id.circularProgressBarView);

        circularProgressBarView.setStrokeWidth(20);
        circularProgressBarView.setColor(this.getResources().getColor(R.color.parrotGreen));
        circularProgressBarView.setProgress(0);
    }

    private void initListeners() {
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_value_progress!=null&&!TextUtils.isEmpty(et_value_progress.getText())) {
                    String value = et_value_progress.getText().toString();
                    Log.e(TAG, "onClick: entered " +value);
                    try {
                        int intValue = Integer.parseInt(value);
                        Log.e(TAG, "onClick: intValue "+intValue);
                        circularProgressBarView.setProgressWithAnimation(intValue);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}

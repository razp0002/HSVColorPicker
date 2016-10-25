package com.algonquincollege.razp0002.hsvcolorpicker;

import android.app.DialogFragment;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

import model.HSVModel;


/**
 *  HSVColorPicker allows you pick colors using HSV values instead of rgb.
 *
 *  @author Stan Razpopov (razp0002@algonquinlive.com)
 */


public class MainActivity extends AppCompatActivity implements Observer, SeekBar.OnSeekBarChangeListener {

    private static final String ABOUT_DIALOG_TAG = "About";
    private AboutDialogFragment mAboutDialog;

//    private AboutDialogFragment mAboutDialog;
    private TextView    mColorSwatch;
    private HSVModel    mModel;

    private SeekBar     mHueSB;
    private SeekBar     mSaturationSB;
    private SeekBar     mValueSB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mAboutDialog = new AboutDialogFragment();

        mModel = new HSVModel();
        mModel.setHue( HSVModel.MAX_HUE );
        mModel.setSaturation( HSVModel.MAX_SATURATION );
        mModel.setValue( HSVModel.MAX_VALUE );

        mModel.addObserver( this );


        mColorSwatch = (TextView) findViewById( R.id.colorSwatch );
        mHueSB = (SeekBar) findViewById( R.id.hueSb );
        mSaturationSB = (SeekBar) findViewById(R.id.saturationSb);
        mValueSB = (SeekBar) findViewById(R.id.valueSb);


        mHueSB.setMax( HSVModel.MAX_HUE.intValue() );
        mSaturationSB.setMax( HSVModel.MAX_SATURATION.intValue() );
        mValueSB.setMax( HSVModel.MAX_VALUE.intValue() );


        mHueSB.setOnSeekBarChangeListener(this);
        mSaturationSB.setOnSeekBarChangeListener(this);
        mValueSB.setOnSeekBarChangeListener(this);


        final Button blackBtn = (Button) findViewById(R.id.blackBtn);
        blackBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asBlack();
            }
        });

        final Button redBtn = (Button) findViewById(R.id.redBtn);
        redBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asRed();
            }
        });

        final Button limeBtn = (Button) findViewById(R.id.limeBtn);
        limeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asLime();
            }
        });

        final Button blueBtn = (Button) findViewById(R.id.blueBtn);
        blueBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asBlue();
            }
        });

        final Button yellowBtn = (Button) findViewById(R.id.yellowBtn);
        yellowBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asYellow();
            }
        });

        final Button cyanBtn = (Button) findViewById(R.id.cyanBtn);
        cyanBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asCyan();
            }
        });

        final Button magentaBtn = (Button) findViewById(R.id.magentaBtn);
        magentaBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asMagenta();
            }
        });

        final Button silverBtn = (Button) findViewById(R.id.silverBtn);
        silverBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asSilver();
            }
        });

        final Button grayBtn = (Button) findViewById(R.id.greyBtn);
        grayBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asGray();
            }
        });

        final Button maroonBtn = (Button) findViewById(R.id.maroonBtn);
        maroonBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asMaroon();
            }
        });

        final Button oliveBtn = (Button) findViewById(R.id.oliveBtn);
        oliveBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asOlive();
            }
        });

        final Button greenBtn = (Button) findViewById(R.id.greenBtn);
        greenBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asGreen();
            }
        });

        final Button purpleBtn = (Button) findViewById(R.id.purpleBtn);
        purpleBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asPurple();
            }
        });

        final Button tealBtn = (Button) findViewById(R.id.tealBtn);
        tealBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asTeal();
            }
        });

        final Button navyBtn = (Button) findViewById(R.id.navyBtn);
        navyBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mModel.asNavy();
            }
        });


        this.updateView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_about) {
            DialogFragment newFragment = new AboutDialogFragment();
            newFragment.show(getFragmentManager(), ABOUT_DIALOG_TAG);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        // Did the user cause this event?
        // YES > continue
        // NO  > leave this method
        if ( fromUser == false ) {
            return;
        }

        // Determine which <SeekBark> caused the event (switch + case)
        // GET the SeekBar's progress, and SET the model to it's new value
        switch ( seekBar.getId() ) {
            case R.id.hueSb:
                mModel.setHue( mHueSB.getProgress() );
                break;

            case R.id.saturationSb:
                mModel.setSaturation( mSaturationSB.getProgress() );
                break;

            case R.id.valueSb:
                mModel.setValue( mValueSB.getProgress() );
                break;

        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // No-Operation
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // No-Operation
    }



    @Override
    public void update(Observable observable, Object data) {
        this.updateView();
    }

    private void updateHueSB() {
        mHueSB.setProgress(mModel.getHue().intValue());
    }

    private void updateColorSwatch() {
        mColorSwatch.setBackgroundColor(Color.HSVToColor(new float[]{mModel.getHue()
                , mModel.getSaturation()
                , mModel.getValue()}));
    }

    private void updateSaturationSB() {
        mSaturationSB.setProgress(mModel.getSaturation().intValue());
    }

    private void updateValueSB() {
        mValueSB.setProgress(mModel.getValue().intValue());
    }


    public void updateView() {
        this.updateColorSwatch();
        this.updateHueSB();
        this.updateSaturationSB();
        this.updateValueSB();
    }
}

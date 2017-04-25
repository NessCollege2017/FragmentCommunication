package ness.edu.fragmentcommunication;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        ColorFragment.OnColorChangedListener, TextFragment.OnTextChangedListener{
    FrameLayout f1, f2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        f1 = (FrameLayout) findViewById(R.id.fr1);
        f2 = (FrameLayout) findViewById(R.id.fr2);

        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.fr1, new ColorFragment(), "colorFrag").
                commit();

        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.fr2, new TextFragment(), "textFrag").
                commit();
    }


    @Override
    public void onColorChanged(int color) {
        Fragment frag = getSupportFragmentManager().findFragmentByTag("textFrag");
        if (frag != null){
            TextFragment tf = (TextFragment) frag;
            tf.setTextColor(color);
        }
    }

    @Override
    public void onTextChanged(String text) {

    }
}

package de.mateware.snackysample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import de.mateware.snacky.Snacky;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RelativeLayout layout = (RelativeLayout) findViewById(R.id.activity_main);
        findViewById(R.id.button_default).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snacky.builder()
                      .setActivty(MainActivity.this)
                      .setActionText("ACTION")
                      .setActionClickListener(new View.OnClickListener() {
                          @Override
                          public void onClick(View v) {
                              //do something
                          }
                      })
                      .setText("Snackbar text is not cut after two lines, you can use setMaxLines(int) to achieve this")
                      .setDuration(Snacky.LENGTH_INDEFINITE)
                      .build()
                      .show();
            }
        });

        findViewById(R.id.button_success).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snacky.builder()
                      .setActivty(MainActivity.this)
                      .setText("Success")
                      .setDuration(Snacky.LENGTH_SHORT)
                      .success()
                      .show();
            }
        });
        findViewById(R.id.button_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snacky.builder()
                      .setActivty(MainActivity.this)
                      .setText("Info (with centered text)")
                      .centerText()
                      .setDuration(Snacky.LENGTH_LONG)
                      .info()
                      .show();
            }
        });
        findViewById(R.id.button_warning).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar warningSnackBar = Snacky.builder()
                                                 .setActivty(MainActivity.this)
                                                 .setText("Warning with Snackbar.Callback")
                                                 .setDuration(Snacky.LENGTH_LONG)
                                                 .warning();
                warningSnackBar.addCallback(new Snackbar.Callback() {
                    @Override
                    public void onShown(Snackbar sb) {
                        Toast toast = Toast.makeText(sb.getContext(), "onShown Callback", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }

                    @Override
                    public void onDismissed(Snackbar sb, int event) {
                        Toast toast = Toast.makeText(sb.getContext(), "onDismissed Callback, event:" + event, Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                });
                warningSnackBar.show();
            }
        });

        findViewById(R.id.button_error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snacky.builder()
                      .setView(layout)
                      .setText("Error")
                      .setDuration(Snacky.LENGTH_INDEFINITE)
                      .setActionText(android.R.string.ok)
                      .error()
                      .show();
            }
        });

        findViewById(R.id.button_custom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snacky.builder()
                      .setBackgroundColor(Color.parseColor("#0077CC"))
                      .setTextSize(18)
                      .setTextColor(Color.parseColor("#FFFFFF"))
                      .setText(
                              "This is a custom Snackbar with all possibilities of customization and an icon. It will be cutted after 4 lines of text, so it depends on your test device if you can read all of this")
                      .setMaxLines(4)
                      .centerText()
                      .setActionText("YEAH!")
                      .setActionTextColor(Color.parseColor("#66FFFFFF"))
                      .setIcon(R.mipmap.ic_launcher)
                      .setActivty(MainActivity.this)
                      .setDuration(Snacky.LENGTH_INDEFINITE)
                      .build()
                      .show();


            }
        });
    }
}

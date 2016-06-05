package techkids.mad3.learnamination;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.io.ObjectOutput;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    private Button btnNext, btnClickMe;
    private static final long DURATION = 1000;
    private static final String ROTATE_PROERTY = "rotation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNext = (Button) this.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);
        btnClickMe = (Button) this.findViewById(R.id.btnClickMe);
        btnClickMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id==R.id.btnNext) {
                 /* Create an intent that will start the main activity. */
            Intent mainIntent = new Intent(MainActivity.this,
                    Author.class);
            mainIntent.putExtra("id", "1");


            startActivity(mainIntent);
            MainActivity.this.finish();
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        }

        if (id==R.id.btnClickMe)
        {
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(btnClickMe, ROTATE_PROERTY, 0, 360);
            objectAnimator.setDuration(DURATION);
            objectAnimator.start();
        }
    }

    @Override
    public void onBackPressed() {
//        overridePendingTransition(R.anim.slide_out, R.anim.slide_in);
//        super.onBackPressed();
    }
}

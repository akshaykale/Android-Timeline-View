package akshay.spinaxon.com.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.akshaykale.swipetimeline.SwipeTimelineFragment;
import com.akshaykale.swipetimeline.TimeLineConfig;
import com.akshaykale.swipetimeline.TimelineGroupType;
import com.akshaykale.swipetimeline.TimelineObject;
import com.akshaykale.swipetimeline.TimelineObjectClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TimelineObjectClickListener {

    private SwipeTimelineFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mFragment = new SwipeTimelineFragment();

        ArrayList<TimelineObject> objs = new ArrayList<>();
        objs.add(new TestO(Long.parseLong("1483196400000"), "A"));
        objs.add(new TestO(Long.parseLong("1483196400000"), "A" ));
        objs.add(new TestO(Long.parseLong("1483196400000"), "A" ));
        objs.add(new TestO(Long.parseLong("1484146800000"), "B" ));
        objs.add(new TestO(Long.parseLong("1485961200000"), "C" ));
        objs.add(new TestO(Long.parseLong("1487084400000"), "D" ));
        objs.add(new TestO(Long.parseLong("1489244400000"), "E" ));
        objs.add(new TestO(Long.parseLong("1491922800000"), "F" ));
        objs.add(new TestO(Long.parseLong("1491922800000"), "F" ));

        TimeLineConfig.setData(objs, TimelineGroupType.DAY);
        TimeLineConfig.addOnClickListener(this);
        loadFragment(mFragment);
    }

    private void loadFragment(Fragment newFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, newFragment);
        //transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTimelineObjectClicked(TimelineObject timelineObject) {
        Toast.makeText(getApplicationContext(),"Clicked: "+timelineObject.getTitle(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTimelineObjectLongClicked(TimelineObject timelineObject) {
        Toast.makeText(getApplicationContext(),"LongClicked: "+timelineObject.getTitle(),Toast.LENGTH_LONG).show();
    }
}

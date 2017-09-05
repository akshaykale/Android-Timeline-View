package akshay.spinaxon.com.myapplication;

import android.content.Intent;
import android.net.Uri;
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

import com.akshaykale.swipetimeline.TimelineFragment;
import com.akshaykale.swipetimeline.TimelineGroupType;
import com.akshaykale.swipetimeline.TimelineObject;
import com.akshaykale.swipetimeline.TimelineObjectClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TimelineObjectClickListener {

    private TimelineFragment mFragment;

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
                Snackbar.make(view, "Android timeline view", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAction("Developer", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("http://akshaykale.com"));
                                startActivity(intent);
                            }
                        }).show();
            }
        });


        // instantiate the TimelineFragment
        mFragment = new TimelineFragment();

        ArrayList<TimelineObject> objs = loadDataInTimeline();

        //Set data
        mFragment.setData(objs, TimelineGroupType.DAY);

        //Set configurations
        mFragment.addOnClickListener(this);
        mFragment.setImageLoadEngine(new ImageLoad(getApplicationContext()));
        //TimeLineConfig.setTimelineCardTextBackgroundColour("#fff000");
        //TimeLineConfig.setTimelineIndicatorLineColour("#fff000"); //yellow line color

        //Load frag after configs and setting the data
        loadFragment(mFragment);
    }

    private ArrayList<TimelineObject> loadDataInTimeline() {
        //Load the data in a list and sort it by times in milli
        ArrayList<TimelineObject> objs = new ArrayList<>();
        objs.add(new TestO(Long.parseLong("1483196400000"), "A", "http://www.pics4learning.com/images/categories/cat-biome-360.jpg"));
        objs.add(new TestO(Long.parseLong("1483196400000"), "A", "http://www.meetingsnet.com/sites/meetingsnet.com/files/TopTipsJune1.jpg"));
        objs.add(new TestO(Long.parseLong("1483196400000"), "B", "https://www.w3schools.com/css/img_fjords.jpg" ));
        objs.add(new TestO(Long.parseLong("1483196400000"), "C" , "https://t2.uc.ltmcdn.com/pt/images/5/7/1/img_como_fazer_rosas_azuis_naturais_25175_600.jpg"));
        objs.add(new TestO(Long.parseLong("1484146800000"), "D" ,"http://i.dailymail.co.uk/i/pix/2017/01/16/20/332EE38400000578-4125738-image-a-132_1484600112489.jpg"));
        objs.add(new TestO(Long.parseLong("1485961200000"), "E", "http://i.dailymail.co.uk/i/pix/2016/09/06/11/37F60FD200000578-0-image-a-5_1473156426673.jpg" ));
        objs.add(new TestO(Long.parseLong("1485961200000"), "E", "https://www.w3schools.com/css/img_fjords.jpg" ));
        objs.add(new TestO(Long.parseLong("1485961200000"), "E", "http://i.dailymail.co.uk/i/pix/2016/09/06/11/37F60FD200000578-0-image-a-5_1473156426673.jpg" ));
        objs.add(new TestO(Long.parseLong("1487084400000"), "F" ,"http://www.nhm.ac.uk/content/dam/nhmwww/visit/Exhibitions/art-of-british-natural-history/magpie-illustration-keulemans-two-column.jpg"));
        objs.add(new TestO(Long.parseLong("1487084400000"), "F" ,"https://www.w3schools.com/css/img_fjords.jpg"));
        objs.add(new TestO(Long.parseLong("1489244400000"), "G" ,"https://cdn.pixabay.com/photo/2016/12/29/16/12/eiskristalle-1938842_960_720.jpg"));
        objs.add(new TestO(Long.parseLong("1491922800000"), "H" ,"http://www.pics4learning.com/images/categories/cat-biome-360.jpg"));
        objs.add(new TestO(Long.parseLong("1491922800000"), "I" ,"http://www.holifestival.org/images/holi-image-4-big.jpg"));
        return objs;
    }

    private void loadFragment(Fragment newFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, newFragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        loadFragment(null);

       /* if (id == R.id.action_date) {
            TimeLineConfig.setData(loadDataInTimeline(), TimelineGroupType.DAY);
            loadFragment(mFragment);
            return true;
        }

        if (id == R.id.action_month) {
            TimeLineConfig.setData(loadDataInTimeline(), TimelineGroupType.MONTH);
            loadFragment(mFragment);
            return true;
        }

        if (id == R.id.action_year) {
            TimeLineConfig.setData(loadDataInTimeline(), TimelineGroupType.YEAR);
            loadFragment(mFragment);
            return true;
        }*/

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

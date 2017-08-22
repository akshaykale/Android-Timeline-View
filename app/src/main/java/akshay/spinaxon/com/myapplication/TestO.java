package akshay.spinaxon.com.myapplication;

import com.akshaykale.swipetimeline.TimelineObject;

/**
 * Created by akshaykale on 2017/08/22.
 */

public class TestO implements TimelineObject {

    public TestO(long timeline, String name) {
        this.timeline = timeline;
        this.name = name;
    }

    long timeline;

    String name;

    @Override
    public long getTimestamp() {
        return timeline;
    }

    @Override
    public String getTitle() {
        return name;
    }
}

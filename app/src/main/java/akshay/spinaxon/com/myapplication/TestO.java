package akshay.spinaxon.com.myapplication;

import com.akshaykale.swipetimeline.TimelineObject;

/**
 * Created by akshaykale on 2017/08/22.
 */

public class TestO implements TimelineObject {

    public TestO(long timeline, String name, String info) {
        this.timeline = timeline;
        this.name = name;
        this.info = info;
    }

    long timeline;

    String name, info;

    @Override
    public long getTimestamp() {
        return timeline;
    }

    @Override
    public String getHeader() {
        return info;
    }

    @Override
    public String getTitle() {
        return name;
    }
}

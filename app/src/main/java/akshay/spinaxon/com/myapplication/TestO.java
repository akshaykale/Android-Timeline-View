package akshay.spinaxon.com.myapplication;

import com.akshaykale.swipetimeline.TimeLineObject;

/**
 * Created by akshaykale on 2017/08/22.
 */

public class TestO implements TimeLineObject {

    public TestO(long timeline, String header) {
        this.timeline = timeline;
        this.header = header;
    }

    long timeline;

    String header;

    @Override
    public long getTimestamp() {
        return timeline;
    }

    @Override
    public String getHeader() {
        return header;
    }

    @Override
    public String getName() {
        return null;
    }
}

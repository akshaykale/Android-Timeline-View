# Android_Timeline
Android timeline to display swiping cards in recycler view group by date

## Demo
![](https://github.com/akshaykale/Android_Timeline/blob/master/media/demo.gif "Demo gif")

### Usage

activity_main.xml
```
<FrameLayout
        android:layout_marginTop="65dp"
        android:id="@+id/container"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```

TestO.java 
Implement ```TimelineObject``` in your card data object
```
public class TestO implements TimelineObject {
    long timestamp;
    String name, url;

    @Override
    public long getTimestamp() {
        return timestamp;
    }
    @Override
    public String getTitle() {
        return name;
    }
    @Override
    public String getImageUrl() {
        return url;
    }
}
```


MainActivity.java
```
// instantiate the SwipeTimelineFragment
SwipeTimelineFragment mFragment = new SwipeTimelineFragment();

//Set data
TimeLineConfig.setData(loadData(), TimelineGroupType.MONTH);

//Set configurations
TimeLineConfig.addOnClickListener(this);

FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
transaction.replace(R.id.container, mFragment);
transaction.commit();
```

```loadData()``` function
```
private ArrayList<TimelineObject> loadDataInTimeline() {
        //Load the data in a list and sort it by times in milli
        ArrayList<TimelineObject> objs = new ArrayList<>();
        objs.add(new TestO(Long.parseLong("1483196400000"), "A", "url"));
        objs.add(new TestO(Long.parseLong("1483196400000"), "A", "url"));
        objs.add(new TestO(Long.parseLong("1483196400000"), "B", "url" ));
        objs.add(new TestO(Long.parseLong("1483196400000"), "C" , "url"));
        objs.add(new TestO(Long.parseLong("1484146800000"), "D" ,c"url"));
        //Sort and return
        //Sort logic
        return objs;
    }
```

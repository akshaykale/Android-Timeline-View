# Android_Timeline
Android timeline to display swiping cards in recycler view group by date

## Demo
![](https://github.com/akshaykale/Android_Timeline/blob/master/media/demo.gif "Demo gif")

### Usage

Timeline view can be loaded directly as a Fragment.

<br>

Add a container to load the fragment.
activity_main.xml 
```
<FrameLayout
        android:layout_marginTop="65dp"
        android:id="@+id/container"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```
<br>

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
<br>

Load the data into Timeline using ```loadDataInTimeline()``` function
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
<br>

Every data object must implement ```TimelineObject``` and override the methods and return valid value.
TestO.java 
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
<br>
<br>
#### Use different image loading library

For Image loading this library uses Picasso, But you ca use any library you preffer to load the image.
For this, create a class ```ImageLoad``` which  ```implements ImageLoadingEngine``` 
```
public class ImageLoad implements ImageLoadingEngine {
    Context context;
    public ImageLoad(Context context) { this.context = context; }
    
    @Override
    public void onLoadImage(ImageView imageView, String uri) {
          // Use any library you prefer to load the image into the view
    }
}
```

#### Configurations


| Function | Usage |
|---|---|
|```TimeLineConfig```<br>```.addOnClickListener();```| Implement click events on the timeline objects <br>1. ```void onTimelineObjectClicked(TimelineObject object){...}``` <br>2. ```void onTimelineObjectLongClicked(TimelineObject object) {...}```|
|```TimeLineConfig```<br>```.setImageLoadEngine(...){...}```|Add custom image loading logic|
|```TimeLineConfig```<br>```.setTimelineHeaderSize(int size){...}```|Text size of the date header|
|```TimeLineConfig```<br>```.setTimelineHeaderTextColour(String textColour)```|Set text colour of date header|
|```TimeLineConfig```<br>```.setTimelineIndicatorBackgroundColour(String textColour){...}```|Change the background colour of Timeline indicator|







<br>
<br>

```
MIT License

Copyright (c) 2017 Akshay Kale

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

```

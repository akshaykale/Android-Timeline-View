# Android-Timeline-View
Android timeline to display horizontal sliding cards in recycler view, group by Day, Month or Year.


## Demo [Video](https://youtu.be/YkOB63MkMFY) 
![](https://raw.githubusercontent.com/akshaykale/Android-Timeline-View/master/media/demo.gif "Demo gif")

<br>

### Install

Add following to application level ```build.gradle``` file<br>
``` 
//install library
compile 'com.akshaykale.android:android-timeline-view:1.0'
```

### Usage

Timeline view can be loaded directly as a Fragment.

<br>

Add a container to load the fragment.<br>

#### activity_main.xml 

```
<FrameLayout
        android:layout_marginTop="65dp"
        android:id="@+id/container"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```
<br>

#### MainActivity.java

```
// instantiate the SwipeTimelineFragment
SwipeTimelineFragment mFragment = new SwipeTimelineFragment();

//Set data
mFragment.setData(loadData(), TimelineGroupType.MONTH);

//Set configurations
mFragment.addOnClickListener(this);

FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
transaction.replace(R.id.container, mFragment);
transaction.commit();
```
<br>

#### Load the data into Timeline using ```loadDataInTimeline()``` function

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

#### Load single object into timeline using ``` addSingleObject() ``` function

```
TestO object = new TestO(Long.parseLong("1481196400000"), "ZZZ", "http://www.pics4learning.com/images/categories/cat-biome-360.jpg");

mFragment.addSingleObject(object, TimelineGroupType.DAY);
```

<br>

#### TestO.java <br>

Every data object must implement ```TimelineObject``` and override the methods and return valid value.
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

For Image loading this library uses Picasso, But you can use any library you preffer to load the image.
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
And before loading the fragment into the container add following line of code.<br>
```TimeLineConfig.setImageLoadEngine(new ImageLoad(getApplicationContext()));```

### Configurations


| Function | Usage |
|---|---|
|```addOnClickListener();```| Implement click events on the timeline objects <br>1. ```void onTimelineObjectClicked(TimelineObject object){...}``` <br>2. ```void onTimelineObjectLongClicked(TimelineObject object) {...}```|
|```setData(ArrayList<TimelineObject> list, TimelineGroupType type)```|Set data to the timeline.<br>Parameters:<br>1. List of TimelineObjects.<br>```Ex:```<br>```class Food implements TimelineObject{...}```<br>2. Group type:<br>  a> ```TimelineGroupType.DAY```<br>  b>```TimelineGroupType.MONTH```<br>  c>```TimelineGroupType.YEAR```| 
|```setImageLoadEngine(ImageLoadingEngine engin)```|Add custom image loading logic|
|```setTimelineHeaderSize(int size)```|Text size of the date header|
|```setTimelineHeaderTextColour(String textColour)```|Set text colour of date header|
|```setTimelineIndicatorBackgroundColour(String textColour)```|Change the background colour of Timeline indicator|
|```setTimelineIndicatorLineColour(String textColour)```|Chenge the timeline indicator line colour|
|```setTimelineCardTextSize(int size)```|Change the text size of timeline card|
|```setTimelineCardTextBackgroundColour(String textColour)```|Change the text background colour of card|







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

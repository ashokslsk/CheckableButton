# CheckableView Libarary

CheckableView library that features **Button** and **ImageButton** to work as a checkable view components.

This library is an example of having button components as checkable views [Official Documentation on Checkable](https://developer.android.com/reference/android/widget/Checkable.html)


#Installation
```sh
repositories {
    maven {
        url 'https://dl.bintray.com/ashokslsk/CheckableView'
    }
}
 
dependencies {
         compile 'com.dunst.check:checkablebutton:1.0.1'
}
```
#CheckableButton 
```
 <com.dunst.check.CheckableButton
        android:id="@+id/button1"
        android:layout_width="88dp"
        android:layout_height="32dp"
        android:background="@drawable/selector"
        android:text="Click1"
        android:textColor="@drawable/checkable_text_color"
        android:textSize="14sp" />
```

#CheckableImageButton
```
<com.dunst.check.CheckableImageButton
        android:id="@+id/button2"
        android:layout_width="88dp"
        android:layout_height="32dp"
        android:layout_centerInParent="true"
        android:adjustViewBounds="true"
        android:scaleType="fitCenter"
        android:background="@drawable/selector"
        android:src="@drawable/balloon"
        android:text="Click2"
        android:textColor="@drawable/checkable_text_color"
        android:textSize="14sp" />
```

##Using drawables for border
**Checkable_default_border.xml**
```
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">
    <stroke android:width="1dp" android:color="#DDDDDD" />
    <corners android:radius="2dp" />
    <solid android:color="@android:color/white" />
</shape>

```

**checkable_selected_border.xml**
```
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">
    <stroke android:color="#ED2727" android:width="1dp" />
    <corners android:radius="2dp" />
    <solid android:color="@android:color/white" />
</shape>

```
**checkable_text_color.xml**
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:state_checked="true" android:color="@android:color/darker_gray" />
    <item android:state_checkable="true" android:color="@android:color/darker_gray"/>
    <item android:color="@android:color/darker_gray"/>
</selector>

#In Java 

```
 com.dunst.check.CheckableButton mClickCheck1;
 com.dunst.check.CheckableImageButton mClickCheck2;

 //In oncreate or your fragments onView
 mClickCheck1 = (CheckableButton) findViewById(R.id.button1);
 mClickCheck2 = (CheckableImageButton) findViewById(R.id.button2);
 
 //Controls are like 
  mClickCheck1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Checked= "Button Unchecked";
                if(mClickCheck1.isChecked()){
                    Checked = "Button Checked";
                }
                Toast.makeText(MainActivity.this, Checked, Toast.LENGTH_SHORT).show();
            }
        });
        
        
  //User can also implement 
  implements CheckableButton.OnCheckedChangeListener 
  
  //And override this method for control
    @Override
    public void onCheckedChanged(CheckableButton buttonView, boolean isChecked) {

    }

```

![Library screen](https://github.com/ashokslsk/CheckableButton/blob/master/screens/Screen1.gif)



## License
```
MIT License

Copyright (c) 2016 Ashok Kumar S

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













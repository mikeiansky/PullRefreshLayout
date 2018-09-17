PullRefreshLayout  
=======
A highly customizable pull refresh layout library for Android  

![image](https://github.com/WinsonZhou/PullRefreshLayout/blob/master/screenshots/pullrefreshlayout.gif)  

for more information please see [the website][1]


Download
--------

Download the latest AAR from [Maven Central][2] or grab via Gradle:
```groovy
implementation 'com.github.winsonzhou:pullrefreshlayout:1.0.1'
```
or Maven:
```xml
<dependency>
  <groupId>com.github.winsonzhou</groupId>
  <artifactId>pullrefreshlayout</artifactId>
  <version>1.0.1</version>
  <type>pom</type>
</dependency>
```
UserGuide
--------

<com.winson.widget.pullrefreshlayout.PullRefreshLayout
        android:id="@+id/pull_refresh_layout"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <com.winson.widget.pullrefreshlayout.PullRefreshHeadLayout
            android:layout_width="match_parent"
            android:layout_height="200dp"
            android:background="@color/colorAccent"
            android:orientation="vertical">

        </com.winson.widget.pullrefreshlayout.PullRefreshHeadLayout>

        <com.winson.widget.pullrefreshlayout.PullRefreshListView
            android:id="@+id/list_view"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />

    </com.winson.widget.pullrefreshlayout.PullRefreshLayout>

[1]: https://blog.csdn.net/wenxiang423/article/details/82746029

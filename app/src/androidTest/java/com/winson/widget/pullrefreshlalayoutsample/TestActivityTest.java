package com.winson.widget.pullrefreshlalayoutsample;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by zwx on 2018/9/20.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class TestActivityTest {

    private static final String STRING_TO_BE_TYPED = "peter";

//    @Rule
//    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
//            MainActivity.class);
    @Rule
    public ActivityTestRule<TestActivity> mActivityRule = new ActivityTestRule<>(
        TestActivity.class);

    @Test
    public void sayHello() {
        onView(withId(R.id.editText)).perform(typeText(STRING_TO_BE_TYPED)); //line 1

        onView(withText("Say hello!")).perform(click()); //line 2
//        "Hello, Peter!"
//        "Hello, Peter!"'
//        String expectedText = "Hello, Peter!";
        String expectedText = "Hello, " + STRING_TO_BE_TYPED + "!";
//        String expectedText = "Hello, pete!";

        onView(withId(R.id.textView)).check(matches(withText(expectedText))); //line 3
//        onView(withId(R.id.textView)).check(matches(withText("Say hello!"))); //line 3
//        onView(withText("Say hello!")).check(matches(withId(R.id.textView))); //line 3



    }


}
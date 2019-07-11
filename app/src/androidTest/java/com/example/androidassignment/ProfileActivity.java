package com.example.androidassignment;


import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class ProfileActivity {

    @Rule
    public ActivityTestRule<Profile> testRule=
            new ActivityTestRule<>(Profile.class);
    @Test
    public void ProfileUiTest() throws Exception{
        onView(withId(R.id.recv1)).perform(scrollTo());
//
//        onView(withId(R.id.recv1)).perform(scrollTo());
//        onView(withId(R.id.linearLayout1)).perform(scrollTo());
//        onView(withId(R.id.fullnamee)).perform(scrollTo(),typeText("amrit"));
//        onView(withId(R.id.petnamee)).perform(scrollTo(),typeText("amrit"));
//        onView(withId(R.id.emaill)).perform(scrollTo(),typeText("amrit"));
//        onView(withId(R.id.phonee)).perform(scrollTo(),typeText("amrit"));
////        onView(withId(R.id.d)).perform(scrollTo(),typeText("10/12/2018"));
//        onView(withId(R.id.in_date)).perform(scrollTo());
//        onView(withId(R.id.in_date)).perform(scrollTo(),typeText("10:28"));
////        onView(withText("CANCEL")).inRoot(isDialog()).check((ViewAssertion) isDisplayed()).perform(click());
////        typeText("10/12/2018"));
////onView(withText("CANCEL")).check(doesNotExist());
//        onView(withId(R.id.in_timee)).perform(scrollTo(),typeText("10:28"));
////        onView(withText("Cancel")).check(doesNotExist());
//        onView(withId(R.id.btn_appointment)).perform(scrollTo());
//        onView(withId(R.id.btn_appointment)).perform(click());
    }
}

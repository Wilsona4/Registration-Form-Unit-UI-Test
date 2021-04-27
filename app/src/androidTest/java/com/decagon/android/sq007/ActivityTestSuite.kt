package com.decagon.android.sq007

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainActivityTest::class,
    ProfileActivityTest::class,
    ToastTest::class
)
class ActivityTestSuite
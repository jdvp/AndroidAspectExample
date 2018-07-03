package me.jdvp.androidaspectexample;

import org.junit.Rule;

/**
 * Class that can be extended by test classes that are testing behavior with observables
 *
 * Created by jdvp on 6/18/18.
 */

public class RxJavaTest {
    @Rule
    public RxJavaImmediateReturnRule rule = new RxJavaImmediateReturnRule();
}
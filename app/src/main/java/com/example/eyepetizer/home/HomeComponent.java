package com.example.eyepetizer.home;

import dagger.Subcomponent;

/**
 * @author popeg
 */
@HomeScope
@Subcomponent(modules = {HomeModule.class})
public interface HomeComponent {
    HomeFragment inject(HomeFragment fragment);
}

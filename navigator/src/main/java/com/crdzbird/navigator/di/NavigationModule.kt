package com.crdzbird.navigator.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.crdzbird.navigator.ComposeNavigator
import com.crdzbird.navigator.ITunesComposeNavigator
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {

    @Binds
    @Singleton
    abstract fun provideComposeNavigator(rheaComposeNavigator: ITunesComposeNavigator): ComposeNavigator
}

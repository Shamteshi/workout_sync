package com.workoutsync.presentation

import android.content.SharedPreferences
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SyncPresenter @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : ViewModel() {

    var state by mutableStateOf(SyncStates())

    init {
        state = state.copy(
            chestAndBackCount = loadValue("chestAndBackCount"),
            bicepsAndTricepsCount = loadValue("bicepsAndTricepsCount"),
            shoulderAndCalvesCount = loadValue("shoulderAndCalvesCount"),
            quadsAndHamstringsCount = loadValue("quadsAndHamstringsCount"),
        )
    }

    fun chestAndBack(){
       state = state.copy(chestAndBackCount = state.chestAndBackCount + 1)
        saveValue("chestAndBackCount", state.chestAndBackCount)
    }

    fun bicepsAndTriceps(){
        state = state.copy(bicepsAndTricepsCount = state.bicepsAndTricepsCount + 1)
        saveValue("bicepsAndTricepsCount", state.bicepsAndTricepsCount)
    }

    fun shoulderAndCalves(){
        state = state.copy(shoulderAndCalvesCount = state.shoulderAndCalvesCount + 1)
        saveValue("shoulderAndCalvesCount", state.shoulderAndCalvesCount)
    }

    fun quadsAndHamstrings(){
        state = state.copy(quadsAndHamstringsCount = state.quadsAndHamstringsCount + 1)
        saveValue("quadsAndHamstringsCount", state.quadsAndHamstringsCount)
    }

    private fun saveValue(key: String, newValue: Int){
        sharedPreferences.edit().putInt(key, newValue).apply()
    }

    private fun loadValue(key: String): Int{
        return sharedPreferences.getInt(key, 0)
    }
}
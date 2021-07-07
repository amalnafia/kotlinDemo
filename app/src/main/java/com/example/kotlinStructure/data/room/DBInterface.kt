package com.example.kotlinStructure.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.kotlinStructure.data.model.terminalSetting.TerminalSetting
import io.reactivex.Completable

@Dao
interface DBInterface {

    //TerminalSetting
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTerminalSetting(terminalSetting: TerminalSetting?): Completable?

}
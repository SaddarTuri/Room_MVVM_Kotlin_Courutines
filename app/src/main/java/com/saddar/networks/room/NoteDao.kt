package com.saddar.networks.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    //OnConflict means same words should be ignored
    //suspend is coroutine function run in background thread
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("Select * from notes_table order by id ASC")
    fun getAllNote(): LiveData<List<Note>>
}
package com.example.runningapp.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RunDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("Select * from running_table order by timestamp desc")
    fun getAllRunsSortedByDate():LiveData<List<Run>>

    @Query("Select * from running_table order by timeInMillis desc")
    fun getAllRunsSortedByTimeInMillis():LiveData<List<Run>>

    @Query("Select * from running_table order by caloriesBurned desc")
    fun getAllRunsSortedByCaloriesBurned():LiveData<List<Run>>

    @Query("Select * from running_table order by distanceInMeters desc")
    fun getAllRunsSortedByDistance():LiveData<List<Run>>

    @Query("Select * from running_table order by avgSpeedInKMH desc")
    fun getAllRunsSortedByAverageSpeedInKMH():LiveData<List<Run>>

    @Query("Select SUM(timeInMillis) from running_table")
    fun getTotalTimeInMillis():LiveData<Long>

    @Query("Select SUM(caloriesBurned) from running_table")
    fun getTotalCaloriesBurned():LiveData<Int>

    @Query("Select SUM(distanceInMeters) from running_table")
    fun getTotalDistance():LiveData<Int>

    @Query("Select AVG(avgSpeedInKMH) from running_table")
    fun getAvgOfTotalAvgSpeed():LiveData<Float>
}
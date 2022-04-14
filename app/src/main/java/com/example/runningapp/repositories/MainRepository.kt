package com.example.runningapp.repositories

import com.example.runningapp.db.Run
import com.example.runningapp.db.RunDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    val runDao: RunDao
){
    suspend fun upsertRun(run : Run)= runDao.upsertRun(run)

    suspend fun deleteRun(run: Run)=runDao.deleteRun(run)

    fun getAllRunsSortedByDate()=runDao.getAllRunsSortedByDate()

    fun getAllRunsSortedByDistance()=runDao.getAllRunsSortedByDistance()

    fun getAllRunsSortedByTimeInMillis()=runDao.getAllRunsSortedByTimeInMillis()

    fun getAllRunsSortedByCaloriesBurned()=runDao.getAllRunsSortedByCaloriesBurned()

    fun getAllRunsSortedByAverageSpeedInKMH()=runDao.getAllRunsSortedByAverageSpeedInKMH()

    fun getTotalTimeInMillis()=runDao.getTotalTimeInMillis()

    fun getTotalCaloriesBurned()=runDao.getTotalCaloriesBurned()

    fun getTotalDistance()=runDao.getTotalDistance()

    fun getAvgOfTotalAvgSpeed()=runDao.getAvgOfTotalAvgSpeed()

}
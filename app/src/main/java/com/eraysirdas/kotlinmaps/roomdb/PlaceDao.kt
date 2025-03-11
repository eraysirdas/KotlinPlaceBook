package com.eraysirdas.kotlinmaps.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.eraysirdas.kotlinmaps.model.Place
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface PlaceDao {

    @Query("SELECT * FROM Place")
    fun getAll() : Flowable<List<Place>>

    @Insert
    fun insert(place : Place) : Completable

    @Delete
    fun delete(place : Place) : Completable

    @Query("UPDATE Place SET name = :name, latitude = :latitude, longitude = :longitude WHERE id = :id")
    fun updatePlace(id: Int, name: String, latitude: Double, longitude: Double): Completable

}
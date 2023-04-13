package com.hw.demo.cursor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = List(100) { (0..1000).random() } //Creates a list of size 100 filled with random integers between 0 and 1000 inclusive.
        val sortedList = quickSort(list) //Calls the quickSort function to sort the list and assigns the sorted list to a new variable called sortedList.
        // Iterate through each element in sortedList and print it using Log
        sortedList.forEach { value ->
            Log.d("MainActivity", value.toString())
        }
    }
}

/**
 * 快速排序
 */
fun quickSort(list: List<Int>): List<Int> {
    if (list.size < 2) {
        return list
    }
    val pivot = list[list.size / 2]
    val less = list.filter { it < pivot }
    val equal = list.filter { it == pivot }
    val greater = list.filter { it > pivot }
    return quickSort(less) + equal + quickSort(greater)
}
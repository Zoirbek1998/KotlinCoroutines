package com.example.kotlincoroutines

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlincoroutines.databinding.ActivityMainBinding
import com.example.kotlincoroutines.model.User
import com.example.kotlincoroutines.viewModel.UserViewModel

class MainActivity : AppCompatActivity()
//    ,CoroutineScope
{
    lateinit var binding: ActivityMainBinding
//    lateinit var apiService :ApiServices
//    lateinit var job: Job
    private  val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        apiService = ApiClient.getRetrofit().create(ApiServices::class.java)
//        job = Job()


//        launch {
//            val userList = apiService.getUsers()
//            showUsers(userList)
//            Log.d(TAG, "onCreate: $userList")
//        }

        val viewModel = ViewModelProvider(this)[UserViewModel::class.java]

        viewModel.getUserLiveData().observe(this, Observer {
            showUsers(it)
        })

    }

    private fun showUsers(userList: List<User>) {
        binding.tv.text = userList.toString()
    }

//    override val coroutineContext: CoroutineContext
//        get() = Dispatchers.Main + job+coroutineExceptionHandler

//    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
//        print("Handle $exception in CoroutineErceptionHandler")
//
//    }

//    override fun onPause() {
//        job.cancel()
//        Log.d(TAG, "onPause: cancel job")
//        super.onPause()
//    }

//    override fun onDestroy() {
//        job.cancel()
//        Log.d(TAG, "onCreate: cancel job")
//        super.onDestroy()
//
//
//    }
}
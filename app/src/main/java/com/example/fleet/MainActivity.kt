package com.example.fleet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fleet.ui.main.MainFragment
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCenter.start(
            application, BuildConfig.APPCENTER_API_KEY,
            Analytics::class.java, Crashes::class.java
        )

        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

}

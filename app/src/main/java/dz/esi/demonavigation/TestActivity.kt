package dz.esi.demonavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager

class TestActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        val test : DrawerLayout
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

    }
}

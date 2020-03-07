package dz.esi.demonavigation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        when (id) {
            R.id.action_viewpager -> ViewPagerActivity()
            R.id.action_menu -> ViewMenuActivity()
            R.id.action_barre -> ViewBarreActivity()
            R.id.action_drawer -> ViewDrawerActivity()
            R.id.action_icons -> ViewIconsActivity()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun ViewIconsActivity() {
        val intent = Intent(this, BarreIconesActivity::class.java)
        startActivity(intent)
    }

    private fun ViewDrawerActivity() {
        val intent = Intent(this, NavigationDrawerActivity::class.java)
        startActivity(intent)
    }

    private fun ViewBarreActivity() {
        val intent = Intent(this, BarreActionsActivity::class.java)
        startActivity(intent)
    }

    private fun ViewMenuActivity() {
        val intent = Intent(this, MenuNavigationActivity::class.java)
        startActivity(intent)
    }

    private fun ViewPagerActivity() {
        val intent = Intent(this, ViewPagerActivity::class.java)
        startActivity(intent)
    }


}

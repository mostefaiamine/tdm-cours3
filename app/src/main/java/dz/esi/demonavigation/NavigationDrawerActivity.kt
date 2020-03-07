package dz.esi.demonavigation

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import kotlinx.android.synthetic.main.activity_navigation_drawer.*

class NavigationDrawerActivity : AppCompatActivity() {

    private var composants: Array<String>? = null
    private var menu: ListView? = null
    private var drawer: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)
        composants = resources.getStringArray(R.array.action_composants)
        menu = findViewById<ListView>(R.id.menuGauche)
        menu?.setAdapter(ArrayAdapter<String>(this, R.layout.drawer_list_item, composants!!))
        drawer = findViewById<DrawerLayout>(R.id.drawer_layout)

        menu?.setOnItemClickListener(
                DrawerItemClickListener()
        )
        menuGauche.visibility = View.VISIBLE
        content_frame.setOnClickListener({
            drawer_layout.openDrawer(GravityCompat.START)
        })
    }

    inner class DrawerItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            selectItem(position)
        }
    }

    private fun selectItem(position: Int) {
        val f = fragmentHelper.getFragment(position)
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, f)
                .commit()

        // Highlight the selected item, update the title, and close the drawer
        menu?.setItemChecked(position, true)


        title = composants?.get(position)


        menu?.let { drawer?.closeDrawer(it) }

    }
}

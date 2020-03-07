package dz.esi.demonavigation

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager


class ViewPagerActivity : AppCompatActivity(), Composant1.ParentActivity {
    override fun Signal() {
        val toast = Toast.makeText(applicationContext, "Un appel dans View Pager", Toast.LENGTH_SHORT)
        toast.show()
    }

    private var pager: ViewPager? = null
    private var adapter: AppSectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        adapter = AppSectionsPagerAdapter(supportFragmentManager)
        pager = findViewById<ViewPager>(R.id.pager)
        pager?.setAdapter(adapter)
    }

    class AppSectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment? {
            when (position) {
                0 -> return Composant1()
                1 -> return Composant2()
                2 -> return Composant3()
                3 -> return Composant4()
            }
            return null
        }

        override fun getCount(): Int {
            return 4
        }

        override fun getPageTitle(position: Int): CharSequence {
            when (position) {
                0 -> return "Composant 1"
                1 -> return "Composant 2"
                2 -> return "Composant 3"
                3 -> return "Composant 4"
            }
            return ""
        }
    }
}

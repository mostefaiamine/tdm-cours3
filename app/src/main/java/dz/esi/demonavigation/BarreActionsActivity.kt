package dz.esi.demonavigation

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class BarreActionsActivity : AppCompatActivity(), Composant1.ParentActivity {
    override fun Signal() {
        val toast = Toast.makeText(applicationContext, "Un appel dans barre d'actions", Toast.LENGTH_SHORT)
        toast.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barre_actions)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.barre_actions, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        val id = item?.itemId

        when (id) {
            R.id.action_composant1 -> ShowFragment(0)
            R.id.action_composant2 -> ShowFragment(1)
            R.id.action_composant3 -> ShowFragment(2)
            R.id.action_composant4 -> ShowFragment(3)
        }

        return super.onOptionsItemSelected(item!!)
    }

    private fun ShowFragment(id: Int) {
        val f = fragmentHelper.getFragment(id)
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.rel_container, f).commit()
    }
}

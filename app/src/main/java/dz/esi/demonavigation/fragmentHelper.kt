package dz.esi.demonavigation

import androidx.fragment.app.Fragment


/**
 * Created by Amine on 03/03/2018.
 */
object fragmentHelper{
    fun getFragment(id: Int): Fragment {
        when (id) {
            0 -> return Composant1()
            1 -> return Composant2()
            2 -> return Composant3()
            else -> return Composant4()
        }

    }
}
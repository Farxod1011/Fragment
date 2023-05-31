package uz.farxod.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import uz.farxod.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setFragment(BlankFragment())

        //         Navigation         //

        //  val objectFragment = BlankFragment()        //fragment class dan obyekt olamiz
        val fragmentManager = supportFragmentManager.beginTransaction()     //bu bir fragmentni boshqasiga almashtireydigon class
        fragmentManager.add(R.id.fragment_container, BlankFragment()).commit()     //shuni ichini almashtiramiz  commit()-ishga tushuramiz

    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(androidx.fragment.R.id.fragment_container_view_tag, fragment).commit()
    }
}
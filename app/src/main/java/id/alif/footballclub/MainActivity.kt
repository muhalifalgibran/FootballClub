package id.alif.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainUI().setContentView(this)

        val list = findViewById<RecyclerView>(MainUI.recyc);
        initData()

        list.layoutManager = LinearLayoutManager(this)
        val listener : (Item) -> Unit = {
            startActivity(intentFor<DetailClub>("club" to it))
        }
        list.adapter = RecyclerViewAdapter(this, items, listener)
    }


    private fun initData(){

        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val desc = resources.getStringArray(R.array.club_desc)
        items.clear()

        for (i in name.indices) {
            items.add(Item(name[i],image.getResourceId(i, 0), desc[i]))
        }

        //Recycle the typed array
        image.recycle()
    }
}

package id.alif.footballclub

import android.view.View
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView


class MainUI: AnkoComponent<MainActivity> {

    companion object {
        val recyc = 3;
    }

    override fun createView(ui: AnkoContext<MainActivity>)= with(ui) {
        verticalLayout{
            padding = dip(16)
            recyclerView{
                id = recyc
            }.lparams(width= matchParent, height = matchParent)
        }
    }
}
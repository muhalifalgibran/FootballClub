package id.alif.footballclub

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*



class item_list : AnkoComponent<ViewGroup> {

    companion object {
        val imageClub = 1
        val nameClub = 2
    }
    override fun createView(ui: AnkoContext<ViewGroup>): View {

        val container =
            ui.linearLayout{
            orientation = LinearLayout.HORIZONTAL
            padding = dip(16)

            imageView() {
                id = imageClub
            }.lparams(width = dip(50), height = dip(50))

            textView("Chelsea") {
                id = nameClub
            }.lparams(width = wrapContent, height = wrapContent) {
                margin = dip(10)
            }
        }

        return container
    }
}
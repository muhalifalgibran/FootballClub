package id.alif.footballclub

import android.media.Image
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.abc_activity_chooser_view.*
import org.jetbrains.anko.*
import org.w3c.dom.Text

class DetailClub : AppCompatActivity() {

    lateinit var name: TextView
    lateinit var imageClub: ImageView
    lateinit var clubDesc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val item: Item = intent.extras.getParcelable("club")

        verticalLayout(){
            gravity = Gravity.CENTER_HORIZONTAL
            padding = dip(20)
           // nameTextView = textView()
           imageClub = imageView(){

            }.lparams(width = dip(60), height = dip(60))

            name = textView(item.name){

            }.lparams(width = wrapContent, height = wrapContent){
                margin = dip(15)
            }

            clubDesc = textView(item.desc).lparams(width = matchParent, height = wrapContent)

        }

//        val intent = intent
//        name = intent.getStringExtra("name")
//        nameTextView.text = name
        val url: Int? = item.image
           Picasso.get()
            .load(item.image!!)
               .fit()
               .into(imageClub)
    }
}
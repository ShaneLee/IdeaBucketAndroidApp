package ee.shanel.ideabucket.idealist

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import ee.shanel.ideabucket.IdeaManager
import ee.shanel.ideabucket.MainActivity
import ee.shanel.ideabucket.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_idea_list.*

class IdeaListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_idea_list)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val activityIntent = Intent(this, MainActivity::class.java)
            startActivity(activityIntent)
        }

        IdeaList.adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            IdeaManager.ideasArray)

//        ListNotes.setOnItemClickListener { parent, view, position, id ->
//            val activityIntent = Intent(this, MainActivity::class.java)
//            activityIntent.putExtra(EXTRA_NOTE_POSITION, position)
//            startActivity(activityIntent)
        }
    }

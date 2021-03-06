package ee.shanel.ideabucket

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import ee.shanel.ideabucket.idealist.IdeaListActivity

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var ideaViewModel: IdeaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        ideaViewModel = IdeaViewModel()

        submitButton.setOnClickListener { view ->
            ideaViewModel.submit(ideaText.text.toString(), categoryText.text.toString())
            Snackbar.make(view, "Idea Submitted", Snackbar.LENGTH_LONG).show()
            ideaText.setText("")
            categoryText.setText("")
        }


        fab.setOnClickListener { view ->
            val activityIntent = Intent(this, IdeaListActivity::class.java)
            startActivity(activityIntent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

package ee.shanel.ideabucket

import ee.shanel.ideabucket.rest.RestController

object IdeaManager {
    val ideas = HashMap<Int, IdeaData>()
    var ideasArray = ArrayList<IdeaData>()
    init {
        initialiseIdeas()
    }

    private fun initialiseIdeas() {
        ideasArray = RestController.getIdeas().ideas
        ideasArray.add(IdeaData(1, "Test", "Category"))
    }
}
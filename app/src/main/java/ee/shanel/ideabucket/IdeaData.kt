package ee.shanel.ideabucket

data class IdeaData(val ideas_id: Int, val idea: String, val category: String?) {
    override fun toString(): String {
        return "Idea: $idea \n\n Category: $category"
    }
}

data class IdeaList(val ideas: ArrayList<IdeaData>)
package ee.shanel.ideabucket

data class IdeaFormState(val ideaError: Int? = null,
                         val categoryError: Int? = null,
                         val isDataValid: Boolean = false)
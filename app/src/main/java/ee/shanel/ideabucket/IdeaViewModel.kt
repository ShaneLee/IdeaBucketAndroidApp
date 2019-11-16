package ee.shanel.ideabucket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ee.shanel.ideabucket.rest.SubmitIdea

class IdeaViewModel: ViewModel() {
    private val _ideaForm = MutableLiveData<IdeaFormState>()
    val ideaFormState: LiveData<IdeaFormState> = _ideaForm

    fun submit(idea: String, category: String) {
        SubmitIdea.submit(idea, category)
    }

    fun submitDataChanged(idea: String, category: String) {
        //        if (!isIdeaValid(idea)) {
//            _submitForm.value = SubmitFormState(ideaError = R.string.invalid_username)
//        } else if (!isCategoryValid(category)) {
//            _submitForm.value = SubmitFormState(categoryError = R.string.invalid_password)
//        } else {
        _ideaForm.value = IdeaFormState(isDataValid = true)
//        }
    }


    private fun isIdeaValid(idea: String): Boolean {
        return idea.isNotBlank()
    }

    private fun isCategoryValid(category: String): Boolean {
        return category.isNotBlank()
    }
}
package ru.tsu.wstraining3

import android.content.Context
import androidx.core.graphics.drawable.toBitmap
import org.json.JSONObject

class JsonUtils(private val activity: Context) {
    private val sharedPref = SharedPreference(activity)
    private val appConst = AppConstants

    private fun saveRunningScene() {
        val jsonObj = JSONObject()
        jsonObj.put(pictureString, appConst.runningDrawableName)
        jsonObj.put(speechString, activity.getString(R.string.speechRunning))
        jsonObj.put(optionOneString, activity.getString(R.string.optionOneRunning))
        jsonObj.put(optionTwoString, activity.getString(R.string.optionTwoRunning))
        sharedPref.saveString(appConst.runningString, jsonObj.toString())
    }

    private fun saveFieldScene() {
        val jsonObj = JSONObject()
        jsonObj.put(pictureString, appConst.fieldsDrawableName)
        jsonObj.put(speechString, activity.getString(R.string.speechField))
        jsonObj.put(optionOneString, activity.getString(R.string.optionOneField))
        jsonObj.put(optionTwoString, activity.getString(R.string.optionTwoField))
        sharedPref.saveString(appConst.fieldString, jsonObj.toString())
    }

    private fun saveCampingScene() {
        val jsonObj = JSONObject()
        jsonObj.put(pictureString, appConst.campingDrawableName)
        jsonObj.put(speechString, activity.getString(R.string.speechCamping))
        jsonObj.put(optionOneString, activity.getString(R.string.optionOneCamping))
        jsonObj.put(optionTwoString, activity.getString(R.string.optionTwoCamping))
        sharedPref.saveString(appConst.campingString, jsonObj.toString())
    }

    private fun saveFilmScene() {
        val jsonObj = JSONObject()
        jsonObj.put(pictureString, appConst.filmDrawableName)
        jsonObj.put(speechString, activity.getString(R.string.speechFilm))
        jsonObj.put(optionOneString, activity.getString(R.string.optionOneFilm))
        jsonObj.put(optionTwoString, activity.getString(R.string.optionTwoFilm))
        sharedPref.saveString(appConst.filmString, jsonObj.toString())
    }

    private fun savePreparingHalloweenScene() {
        val jsonObj = JSONObject()
        jsonObj.put(pictureString, appConst.halloweenPreparingDrawableName)
        jsonObj.put(speechString, activity.getString(R.string.speechPreparingHalloween))
        jsonObj.put(optionOneString, activity.getString(R.string.optionOnePreparingHalloween))
        jsonObj.put(optionTwoString, activity.getString(R.string.optionTwoPreparingHalloween))
        sharedPref.saveString(appConst.preparingHalloweenString, jsonObj.toString())
    }

    private fun saveCostumesScene() {
        val jsonObj = JSONObject()
        jsonObj.put(pictureString, appConst.halloweenCostumesDrawableName)
        jsonObj.put(speechString, activity.getString(R.string.speechCostumes))
        jsonObj.put(optionOneString, activity.getString(R.string.optionOneCostumes))
        jsonObj.put(optionTwoString, activity.getString(R.string.optionTwoCostumes))
        sharedPref.saveString(appConst.costumesString, jsonObj.toString())
    }

    private fun saveFilmLastScenePositive() {
        val jsonObj = JSONObject()
        jsonObj.put(pictureString, appConst.filmDrawableName)
        jsonObj.put(speechString, activity.getString(R.string.speechFilmPositive))
        jsonObj.put(optionOneString, activity.getString(R.string.answerLast))
        sharedPref.saveString(appConst.filmPositiveString, jsonObj.toString())
    }

    private fun saveFilmLastSceneNegative() {
        val jsonObj = JSONObject()
        jsonObj.put(pictureString, appConst.filmDrawableName)
        jsonObj.put(speechString, activity.getString(R.string.speechFilmNegative))
        jsonObj.put(optionOneString, activity.getString(R.string.answerLast))
        sharedPref.saveString(appConst.filmNegativeString, jsonObj.toString())
    }

    private fun saveCostumesLastScenePositive() {
        val jsonObj = JSONObject()
        jsonObj.put(pictureString, appConst.halloweenCostumesDrawableName)
        jsonObj.put(speechString, activity.getString(R.string.speechCostumesPositive))
        jsonObj.put(optionOneString, activity.getString(R.string.answerLast))
        sharedPref.saveString(appConst.costumesPositiveString, jsonObj.toString())
    }

    private fun saveCostumesLastSceneNegative() {
        val jsonObj = JSONObject()
        jsonObj.put(pictureString, appConst.halloweenCostumesDrawableName)
        jsonObj.put(speechString, activity.getString(R.string.speechCostumesNegative))
        jsonObj.put(optionOneString, activity.getString(R.string.answerLast))
        sharedPref.saveString(appConst.costumesNegativeString, jsonObj.toString())
    }

    fun saveScenes() {
        saveCampingScene()
        saveFieldScene()
        saveRunningScene()
        savePreparingHalloweenScene()
        saveFilmScene()
        saveCostumesScene()
        saveFilmLastScenePositive()
        saveFilmLastSceneNegative()
        saveCostumesLastScenePositive()
        saveCostumesLastSceneNegative()
    }

    fun getScene(key: String) = sharedPref.getString(key)

    fun ifScenesAlreadyExist() : Boolean {
        val isExistString = sharedPref.getString(appConst.runningString)
        return isExistString != appConst.emptyString
    }

    companion object LocalConstants {
        const val pictureString = "picture"
        const val speechString = "speech"
        const val optionOneString = "optionOne"
        const val optionTwoString = "optionTwo"
    }
}
package ru.tsu.wstraining3

import android.content.Context
import androidx.core.graphics.drawable.toBitmap
import org.json.JSONObject

class JsonUtils(private val activity: Context) {
    private val sharedPref = SharedPreference(activity)

    private fun saveRunningScene() {
        val jsonObj = JSONObject()
        jsonObj.put("picture", "running_back")
        jsonObj.put("speech", activity.getString(R.string.speechRunning))
        jsonObj.put("optionOne", activity.getString(R.string.optionOneRunning))
        jsonObj.put("optionTwo", activity.getString(R.string.optionTwoRunning))
        sharedPref.saveString("running", jsonObj.toString())
    }

    private fun saveFieldScene() {
        val jsonObj = JSONObject()
        jsonObj.put("picture", "fields_back")
        jsonObj.put("speech", activity.getString(R.string.speechField))
        jsonObj.put("optionOne", activity.getString(R.string.optionOneField))
        jsonObj.put("optionTwo", activity.getString(R.string.optionTwoField))
        sharedPref.saveString("field", jsonObj.toString())
    }

    private fun saveCampingScene() {
        val jsonObj = JSONObject()
        jsonObj.put("picture", "camping_back")
        jsonObj.put("speech", activity.getString(R.string.speechCamping))
        jsonObj.put("optionOne", activity.getString(R.string.optionOneCamping))
        jsonObj.put("optionTwo", activity.getString(R.string.optionTwoCamping))
        sharedPref.saveString("camping", jsonObj.toString())
    }

    private fun saveFilmScene() {
        val jsonObj = JSONObject()
        jsonObj.put("picture", "film_back")
        jsonObj.put("speech", activity.getString(R.string.speechFilm))
        jsonObj.put("optionOne", activity.getString(R.string.optionOneFilm))
        jsonObj.put("optionTwo", activity.getString(R.string.optionTwoFilm))
        sharedPref.saveString("film", jsonObj.toString())
    }

    private fun savePreparingHalloweenScene() {
        val jsonObj = JSONObject()
        jsonObj.put("picture", "halloween_preparing_back")
        jsonObj.put("speech", activity.getString(R.string.speechPreparingHalloween))
        jsonObj.put("optionOne", activity.getString(R.string.optionOnePreparingHalloween))
        jsonObj.put("optionTwo", activity.getString(R.string.optionTwoPreparingHalloween))
        sharedPref.saveString("preparingHalloween", jsonObj.toString())
    }

    private fun saveCostumesScene() {
        val jsonObj = JSONObject()
        jsonObj.put("picture", "halloween_costumes_back")
        jsonObj.put("speech", activity.getString(R.string.speechCostumes))
        jsonObj.put("optionOne", activity.getString(R.string.optionOneCostumes))
        jsonObj.put("optionTwo", activity.getString(R.string.optionTwoCostumes))
        sharedPref.saveString("costumes", jsonObj.toString())
    }

    private fun saveFilmLastScenePositive() {
        val jsonObj = JSONObject()
        jsonObj.put("picture", "film_back")
        jsonObj.put("speech", activity.getString(R.string.speechFilmPositive))
        jsonObj.put("option", activity.getString(R.string.answerLast))
        sharedPref.saveString("filmPositive", jsonObj.toString())
    }

    private fun saveFilmLastSceneNegative() {
        val jsonObj = JSONObject()
        jsonObj.put("picture", "film_back")
        jsonObj.put("speech", activity.getString(R.string.speechFilmNegative))
        jsonObj.put("option", activity.getString(R.string.answerLast))
        sharedPref.saveString("filmNegative", jsonObj.toString())
    }

    private fun saveCostumesLastScenePositive() {
        val jsonObj = JSONObject()
        jsonObj.put("picture", "halloween_costumes_back")
        jsonObj.put("speech", activity.getString(R.string.speechCostumesPositive))
        jsonObj.put("option", activity.getString(R.string.answerLast))
        sharedPref.saveString("costumesPositive", jsonObj.toString())
    }

    private fun saveCostumesLastSceneNegative() {
        val jsonObj = JSONObject()
        jsonObj.put("picture", "halloween_costumes_back")
        jsonObj.put("speech", activity.getString(R.string.speechCostumesNegative))
        jsonObj.put("option", activity.getString(R.string.answerLast))
        sharedPref.saveString("costumesNegative", jsonObj.toString())
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
        val isExistString = sharedPref.getString("running")
        return isExistString != ""
    }
}
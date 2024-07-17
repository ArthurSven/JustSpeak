package com.devapps.justspeak_10

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.devapps.justspeak_10.data.remote.model.UserData
import com.devapps.justspeak_10.data.remote.repository.GoogleClientAuth
import com.devapps.justspeak_10.ui.Screens.German.GermanAddFlashCard
import com.google.android.gms.auth.api.identity.Identity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito


@RunWith(AndroidJUnit4::class)
class AddFlashcardTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    val context = LocalContext.current.applicationContext
    val googleClientAuth by lazy {
        GoogleClientAuth(
            context,
            oneTapClient = Identity.getSignInClient(context)
        )

    val fakeUserData = UserData(
        "dfbdbbfgngfgb",
        "Artska",
        "artska@gmail.com",
        "xcbbdfnfgngfn"
    )
    val fakeGoogleClientAuth = Mockito.mock(GoogleClientAuth::class.java)

    @Test
    fun addFlashcard_success() {
        // Start the GermanAddFlashCard composable
        composeTestRule.setContent {
            GermanAddFlashCard(
                germanAddFlashcardNavController = /* Your NavController instance */,
                homeNaviController = /* Your NavController instance */,
                userData = /* Your UserData instance */,
                onSignOut = {}
            )
        }

        // Input German and English translations
        composeTestRule.onNodeWithText("German").performTextInput("Hallo")
        composeTestRule.onNodeWithText("English translation").performTextInput("Hello")

        // Click the Add flashcard button
        composeTestRule.onNodeWithText("Add flashcard").performClick()

        // Verify the success message
        composeTestRule.onNodeWithText("Flashcard has successfully created").assertExists()
    }

    @Test
    fun addFlashcard_failure() {
        // Start the GermanAddFlashCard composable
        composeTestRule.setContent {
            GermanAddFlashCard(
                germanAddFlashcardNavController = /* Your NavController instance */,
                homeNaviController = /* Your NavController instance */,
                userData = /* Your UserData instance */,
                onSignOut = {}
            )
        }

        // Click the Add flashcard button without input
        composeTestRule.onNodeWithText("Add flashcard").performClick()

        // Verify the failure message
        composeTestRule.onNodeWithText("Please fill in both German and English translations.").assertExists()
    }
}
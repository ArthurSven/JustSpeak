package com.devapps.justspeak_10

import android.app.Activity.RESULT_OK
import android.content.IntentSender
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.Animatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devapps.justspeak_10.ui.destinations.Signup
import com.devapps.justspeak_10.ui.destinations.SplashScreen
import com.devapps.justspeak_10.ui.destinations.Start
import com.devapps.justspeak_10.ui.theme.AzureBlue
import com.devapps.justspeak_10.ui.theme.JustSpeak10Theme
import com.devapps.justspeak_10.ui.viewmodels.AuthViewModel
import com.devapps.justspeak_10.ui.viewmodels.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.layout.ContentScale
import com.devapps.justspeak_10.data.remote.model.UserData
import com.devapps.justspeak_10.data.remote.repository.GoogleClientAuth
import com.devapps.justspeak_10.ui.Components.UserBar
import com.devapps.justspeak_10.ui.Screens.German.GermanNavigation
import com.devapps.justspeak_10.ui.destinations.Check
import com.devapps.justspeak_10.ui.destinations.GermanNavigation
import com.devapps.justspeak_10.ui.destinations.Signout
import com.devapps.justspeak_10.ui.theme.Purple40
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Navigation()
        }
    }
}

@Composable
fun Navigation() {
    val context = LocalContext.current.applicationContext
    val coroutineScope = rememberCoroutineScope()
    val authViewModel = viewModel<AuthViewModel>()
    val state by authViewModel.state.collectAsStateWithLifecycle()

    val googleClientAuth by lazy {
        GoogleClientAuth(
            context,
            oneTapClient = Identity.getSignInClient(context)
        )
    }

    val startNavController = rememberNavController()
    NavHost(navController = startNavController, startDestination = SplashScreen.route) {
        composable(SplashScreen.route) {
            SplashScreen(startNavController)
        }
        composable(Signup.route) {
            SignUpScreen(startNavController)
        }
        composable(Start.route) {
            SelectLanguageScreen(
                userData = googleClientAuth.getSignedInUser(),
                navController = startNavController,
                onSignOut = {
                    coroutineScope.launch {
                        googleClientAuth.signOut()
                        Toast.makeText(context, "Signed out", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
        composable(GermanNavigation.route) {
            GermanNavigation(startNavController)
        }
        composable(Check.route) {
            LaunchedEffect(key1 = Unit) {
                if(googleClientAuth.getSignedInUser() != null) {
                    if (state.isSignInSuccessful) {
                    }
                    startNavController.navigate(Start.route)
                } else {
                    startNavController.navigate(Signup.route)
                }
            }
        }
        composable(Signout.route) {
           LaunchedEffect(Unit) {
                googleClientAuth.signOut()
            }

        }
    }
}

@Composable
fun SplashScreen(navController: NavController) {

    val scale = remember {
     Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(
                durationMillis = 1000,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3000)
        navController.navigate(Check.route)
    }
Column(
    modifier = Modifier
        .fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Image(
        painter = painterResource(id = R.drawable.logoblue),
        contentDescription = null)
}
}

@Composable
fun SignUpScreen(navController: NavController) {
    val context = LocalContext.current.applicationContext
    val coroutineScope = rememberCoroutineScope()
    val authViewModel = viewModel<AuthViewModel>()
    val state by authViewModel.state.collectAsStateWithLifecycle()

    val googleClientAuth by lazy {
        GoogleClientAuth(
            context,
            oneTapClient = Identity.getSignInClient(context)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 20.dp)
            .background(color = Color.White)
    ) {
        Spacer(modifier = Modifier
            .height(40.dp))
        Image(
            painter = painterResource(id = R.drawable.logoblue),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            alignment = Alignment.Center)
        Spacer(modifier = Modifier
            .height(80.dp))
        Text(
            text = "Welcome to JustSpeak",
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.Black,
            color = AzureBlue,
            modifier = Modifier
                .fillMaxWidth())
        Spacer(modifier = Modifier
            .height(5.dp))
        Text(
            text = "Let's get you onboard, your language journey is one step closer!",
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            color = Color.DarkGray,
            modifier = Modifier
                .fillMaxWidth())
        Spacer(modifier = Modifier
            .height(60.dp))

        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.StartIntentSenderForResult(),
            onResult = { result ->
                if(result.resultCode == RESULT_OK) {
                    coroutineScope.launch {
                        val signInResult = googleClientAuth.signInWithIntent(
                            intent = result.data ?: return@launch
                        )
                        authViewModel.onSignInResult(signInResult)
                    }
                }
            })
        SocialLoginButton(
            onClick = {
                      coroutineScope.launch {
                          val signInIntentSender = googleClientAuth.signIn()
                          launcher.launch(
                              IntentSenderRequest.Builder(
                                  signInIntentSender ?: return@launch
                              ).build()
                          )
                      }
            },
            color = AzureBlue,
            text = "Sign in with Google",
            iconResId = R.drawable.google_without
        )
        LaunchedEffect(key1 = state.isSignInSuccessful) {
            if (state.isSignInSuccessful) {
                Toast.makeText(
                    context,
                    "Sign in successful",
                    Toast.LENGTH_LONG
                ).show()
                navController.navigate(Start.route)
                authViewModel.resetState()
            }
        }

    }
}

@Composable
fun SocialLoginButton(
    onClick: () -> Unit,
    color: Color,
    text: String,
    iconResId: Int
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = Color.White)
            .clickable(onClick = onClick)
            .border(
                1.dp,
                color = AzureBlue,
                shape = RoundedCornerShape(15.dp)
            )
    ) {
        Surface(
            modifier = Modifier
                .background(color = AzureBlue)
                .border(
                    1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = AzureBlue),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = text,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(start = 30.dp)
                )
                Spacer(modifier = Modifier
                    .width(30.dp))
                Image(painter = painterResource(id = iconResId),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
            }
        }
    }
}

@Composable
fun SelectLanguageScreen(
    userData: UserData?,
    navController: NavController,
    onSignOut: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        UserBar(userData)
        Spacer(modifier = Modifier
            .height(50.dp))
        Text(text = "Select your language journey..",
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 20.dp),
            textAlign = TextAlign.Center)
        LanguageCard(
            onClick = {
                navController.navigate(GermanNavigation.route)
            },
            backgroundColor = AzureBlue,
            country = R.drawable.deutschland,
            language = "German",
            borderColor = Color.Blue,
            content = "German is one of the most commonly " +
                    "used languages in the European Union and national language of Germany")
        LanguageCard(
            onClick = { /*TODO*/ },
            backgroundColor = Purple40,
            country = R.drawable.malawi,
            language = "Chichewa",
            borderColor = Color.Blue,
            content = "Chichewa is the official language of the Republic of Malawi and comes from" +
                    " the bantu language family")
    }
}

@Composable
fun LanguageCard(
    onClick: () -> Unit,
    backgroundColor: Color,
    country: Int,
    language: String,
    borderColor: Color,
    content: String
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            colors = CardDefaults.elevatedCardColors(
                containerColor = backgroundColor
            )

            ,
            modifier = Modifier
                .padding(all = 20.dp)
                .height(200.dp)
                .clickable {
                    onClick()
                }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 20.dp)
            ) {
                Image(
                    painter = painterResource(country),
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .border(
                            BorderStroke(5.dp, borderColor),
                            CircleShape
                        )
                )
                Spacer(modifier = Modifier
                    .width(10.dp))
                Column {
                    Text(text = language,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White)
                    Text(text = content,
                        fontSize = 16.sp,
                        color = Color.White)
                }

            }
        }
    }

}


@Composable
@Preview(showBackground = true)
fun ScreenPreview() {

}
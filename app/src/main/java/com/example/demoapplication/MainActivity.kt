package com.example.demoapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.demoapplication.ui.theme.DemoApplicationTheme
import com.example.demoapplication.repository.models.User
import com.example.demoapplication.repository.viewModels.UserViewModel
import com.example.demoapplication.views.PostScreen
import com.example.demoapplication.views.Screen
import com.example.demoapplication.views.UserListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userViewModel by viewModels<UserViewModel>()
        setContent {
            DemoApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background)
                {
                    userViewModel.getUserList()
                    Navigation(userList = userViewModel.userListResponse)
                }
            }
        }
    }
}

@Composable
fun Navigation(userList: List<User>)
{
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.UserListScreen.route)
    {
        composable(route = Screen.UserListScreen.route)
        {
            UserListScreen(userList = userList, navController = navController)
        }

        composable(
            route = Screen.PostScreen.route + "/{post}",
            arguments = listOf(
                navArgument("post")
                {
                    type = NavType.StringType
                    defaultValue = "No Post"
                    nullable = true
                }
            )
        )
        {
                entry -> PostScreen(postBody = entry.arguments?.getString("postBody"))
        }
    }


}



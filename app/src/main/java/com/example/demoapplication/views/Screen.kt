package com.example.demoapplication.views

sealed class Screen(val route: String)
{
    object UserListScreen: Screen("user_list_screen")
    object PostScreen: Screen("post_screen")

    fun withArgs(vararg args: String): String{
        return buildString {
            append(route)
            args.forEach {
                    arg -> append("/$arg")
            }
        }
    }
}

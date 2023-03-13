package com.example.demoapplication.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.demoapplication.repository.models.User

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UserItem(user: User, navController: NavController)
{
    Card(
        modifier = Modifier
            .padding(4.dp, 4.dp)
            .fillMaxWidth()
            .height(75.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp,
        /*onClick = {
            var postBody: String = ""
            for(posts in postList)
            {
                if(posts.user_id == user.id)
                {
                    postBody = posts.body
                    break
                }
            }
            navController.navigate(Screen.PostScreen.withArgs(postBody))
        }*/
        )
    {
        Row(
            Modifier
                .padding(4.dp)
                .fillMaxWidth())
        {
            Column()
            {
                Text(text = user.name, modifier = Modifier.padding(4.dp))
                //Spacer(modifier = Modifier.width(16.dp))
                Text(text = user.id.toString(), modifier = Modifier.padding(4.dp))
            }

            Spacer(modifier = Modifier.width(100.dp))

            Column() {
                Text(text = "Status:", modifier = Modifier.padding(4.dp))
                //Spacer(modifier = Modifier.width(16.dp))
                Text(text = user.status, modifier = Modifier.padding(4.dp))

            }

        }
    }

}

@Composable
fun UserListScreen(userList: List<User>, navController: NavController)
{
    LazyColumn()
    {
        itemsIndexed(items = userList)
        {
                index, item -> UserItem(user = item, navController)
        }
    }
}


@Composable
fun PostScreen(postBody : String?)
{
    if (postBody != null) {
        Text(text = postBody)
    }
}

package com.example.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.data.DataSource
import com.example.courses.model.Topic
import com.example.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FinalScreen()
                }
            }
        }
    }
}

@Composable
fun CourseCard(topic : Topic , modifier: Modifier = Modifier){
    Card(
        modifier = modifier
    ) {
        Row (){
            Image(painter = painterResource(id = topic.image) , contentDescription = null)
            Column (Modifier.padding(top = 4.dp)){
                Text(
                    text = stringResource(id = topic.name) , modifier = Modifier.
                padding(start = 16.dp , end = 16.dp , bottom = 8.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row (
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically){
                    Image(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier.padding(start = 16.dp)
                        )
                    Text(
                        text = topic.number.toString() ,
                        modifier = Modifier.padding(start = 8.dp),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }

        }
    }
}

@Composable
fun CoursesGrid(topics: List<Topic>, modifier: Modifier = Modifier){
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(topics) { topic ->
            CourseCard(topic = topic)
        }
    }
}
@Composable
fun FinalScreen(){
    CoursesGrid(topics = DataSource.getTopics.topics, modifier = Modifier.fillMaxSize())
}


@Preview(showBackground = true)
@Composable
fun CardPreview(modifier: Modifier = Modifier){
//    CourseCard(topic = Topic(R.string.architecture,53,R.drawable.architecture))
    FinalScreen()
}


package com.example.codelab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codelab2.data.movieData
import com.example.codelab2.ui.bottomNav.BottomNavScreen
import com.example.codelab2.ui.theme.CodeLab2Theme
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //MovieApp()
            BottomNavScreen()
        }
    }
}

@Composable
fun MovieApp() {
    CodeLab2Theme {
        Scaffold(bottomBar = { BottomNavigation() }
        ) { paddingValues ->
            HomeScreen(Modifier.padding(paddingValues))
        }
    }
}

@Preview
@Composable
fun MovieAppPreview() {
    MovieApp()
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp),
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(modifier = Modifier.padding(horizontal = 16.dp))
        HomeSection(
            title = R.string.trending_movie
        ) {
            TrendingBodyElementRow()
        }
        HomeSection(
            title = R.string.popular_movie
        ) {
            PopularBodyGridElement()
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun HomeSectionPreview() {
    HomeSection(
        title = R.string.popular_movie,
        content = { PopularBodyGridElement() }
    )

}

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {

    Column(modifier) {
        Text(
            text = stringResource(id = title).uppercase(Locale.ROOT),
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .paddingFromBaseline(
                    top = 40.dp,
                    bottom = 8.dp
                )
                .padding(horizontal = 16.dp)
        )
        content()
    }

}

@Preview
@Composable
fun BottomNavigationPreview() {
    BottomNavigation()
}

@Composable
fun BottomNavigation(modifier: Modifier = Modifier) {
    BottomNavigation(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.background
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text(text = "Home")
            },
            selected = true,
            onClick = {}
        )

        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null
                )
            },
            label = {
                Text(text = "Star")
            },
            selected = false,
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CodeLab2Theme {
        SearchBar()
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        placeholder = {
            Text(text = stringResource(R.string.search))
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp),
    )
}


@Preview(showBackground = true)
@Composable
fun TrendingBodyElementRowPreview() {
    TrendingBodyElementRow()
}

@Composable
fun TrendingBodyElementRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier,
        contentPadding = PaddingValues(16.dp)
    ) {
        items(movieData) { items ->
            TrendingBodyElement(
                drawable = items.drawable,
                name = items.name
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TrendingBodyElementPreview() {
    TrendingBodyElement(
        drawable = R.drawable.shawshank,
        name = R.string.shawshank,
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun TrendingBodyElement(
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int,
    @StringRes name: Int
) {

    Column(
        modifier = modifier.size(width = 100.dp, height = 120.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(name),
            style = MaterialTheme.typography.h6,
            modifier = Modifier.paddingFromBaseline(
                top = 24.dp, bottom = 8.dp
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }

}

@Preview
@Composable
fun PopularBodyGridElementPreview() {
    PopularBodyGridElement()
}

@Composable
fun PopularBodyGridElement(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(150.dp),
    ) {
        items(movieData) { item ->
            PopularBodyElement(
                drawable = item.drawable,
                name = item.name,
                modifier = Modifier.height(66.dp)
            )
        }
    }
}

@Preview
@Composable
fun PopularBodyElementPreview() {
    PopularBodyElement(
        modifier = Modifier.padding(8.dp),
        drawable = R.drawable.thor,
        name = R.string.thor
    )
}

@Composable
fun PopularBodyElement(
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int,
    @StringRes name: Int
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .width(210.dp)
        ) {
            Image(
                painter = painterResource(id = drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(66.dp)
            )
            Text(
                text = stringResource(id = name),
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(horizontal = 16.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }

}
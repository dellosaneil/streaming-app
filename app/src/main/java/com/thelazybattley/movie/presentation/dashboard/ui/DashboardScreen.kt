package com.thelazybattley.movie.presentation.dashboard.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.thelazybattley.common.theme.LocalColors
import com.thelazybattley.common.theme.MovieTheme
import com.thelazybattley.movie.R
import com.thelazybattley.movie.presentation.dashboard.DashboardEvent
import com.thelazybattley.movie.presentation.dashboard.DashboardUiState
import com.thelazybattley.movie.presentation.dashboard.DashboardViewModel


@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    val viewModel = hiltViewModel<DashboardViewModel>()
    val uiState by viewModel.state.collectAsState()
    val events by viewModel.events.collectAsState(initial = null)

    DashboardScreen(
        modifier = modifier, uiState = uiState, event = events
    )
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    uiState: DashboardUiState,
    event: DashboardEvent?
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = LocalColors.current.white1),
        contentPadding = PaddingValues(start = 16.dp)
    ) {
        item {
            DashboardMovieList(
                movies = uiState.nowPlayingMovies,
                groupName = stringResource(R.string.now_showing)
            )
        }
    }
}


@Preview
@Composable
private fun PreviewDashboard() {
    MovieTheme {
        DashboardScreen(
            uiState = DashboardUiState(

            ),
            event = null
        )
    }
}

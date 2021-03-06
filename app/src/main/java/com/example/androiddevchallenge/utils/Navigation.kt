/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.utils

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.ui.components.PuppyList
import com.example.androiddevchallenge.ui.screens.Home
import com.example.androiddevchallenge.ui.screens.PuppyDetails

@ExperimentalStdlibApi
@ExperimentalFoundationApi
@Composable
fun SetupNavigation(navHostController: NavHostController) {
    NavHost(navHostController, startDestination = Destinations.HOME.route) {
        composable(Destinations.HOME.route) {
            Home { puppy ->
                navigateToPuppyDetails(navController = navHostController, puppy = puppy)
            }
        }
        composable(Destinations.PUPPY_DETAILS.route) {
            val puppy = navHostController.previousBackStackEntry?.arguments?.getParcelable<Puppy>(PUPPY_KEY)
            PuppyDetails(puppy = puppy)
        }
    }
}

enum class Destinations(val route: String) {
    HOME("puppy_list"),
    PUPPY_DETAILS("puppy_details")
}

private fun navigateToPuppyDetails(
    navController: NavHostController,
    puppy: Puppy
) {
    navController.currentBackStackEntry
        ?.arguments?.putParcelable(PUPPY_KEY, puppy)
    navController.navigate(Destinations.PUPPY_DETAILS.route)
}

private const val PUPPY_KEY = "puppy"
package com.crdzbird.navigator

import androidx.navigation.NamedNavArgument

sealed class Screen(
    baseRoute: String,
    navArguments: List<NamedNavArgument> = emptyList()
) {
    val route: String = baseRoute.appendArguments(navArguments)

    object DashboardScreen : Screen("dashboard_screen")
    object DetailScreen : Screen("detail_screen")
}

private fun String.appendArguments(navArguments: List<NamedNavArgument>): String {
    val mandatoryArguments = navArguments.filter { it.argument.defaultValue == null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "/", prefix = "/") { "{${it.name}}" }
        .orEmpty()
    val optionalArguments = navArguments.filter { it.argument.defaultValue != null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "&", prefix = "?") { "${it.name}={${it.name}}" }
        .orEmpty()
    return "$this$mandatoryArguments$optionalArguments"
}
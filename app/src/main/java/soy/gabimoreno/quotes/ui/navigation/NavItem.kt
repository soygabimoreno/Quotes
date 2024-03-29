package soy.gabimoreno.quotes.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument
import soy.gabimoreno.quotes.R

enum class NavItem(
    val navCommand: NavCommand,
    val icon: ImageVector,
    @StringRes val title: Int,
) {
    HOME(
        NavCommand.ContentType(Feature.QUOTES),
        Icons.Default.Home,
        R.string.home
    ),
    SETTINGS(
        NavCommand.ContentType(Feature.TWO),
        Icons.Default.Settings,
        R.string.settings
    ),
    THREE(
        NavCommand.ContentType(Feature.THREE),
        Icons.Default.Face,
        R.string.three
    ),
    FOUR(
        NavCommand.ContentType(Feature.FOUR),
        Icons.Default.Phone,
        R.string.four
    ),
    FIVE(
        NavCommand.ContentType(Feature.FIVE),
        Icons.Default.DateRange,
        R.string.five
    )
}

sealed class NavCommand(
    internal val feature: Feature,
    internal val subRoute: String = "home",
    private val navArgs: List<NavArg> = emptyList(),
) {
    class ContentType(feature: Feature) : NavCommand(feature)

    class ContentTypeDetail(feature: Feature) : NavCommand(
        feature,
        "detail",
        listOf(NavArg.ItemId)
    ) {
        fun createRoute(itemId: Long) = "${feature.route}/$subRoute/$itemId"
    }

    val route = run {
        val argValues = navArgs.map { "{${it.key}}" }
        listOf(feature.route)
            .plus(subRoute)
            .plus(argValues)
            .joinToString("/")
    }

    val args = navArgs.map {
        navArgument(it.key) {
            type = it.navType
        }
    }
}

enum class NavArg(
    val key: String,
    val navType: NavType<*>,
) {
    ItemId(
        "itemId",
        NavType.IntType
    )
}

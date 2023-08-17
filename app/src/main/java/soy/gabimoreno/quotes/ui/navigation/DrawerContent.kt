package soy.gabimoreno.quotes.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun DrawerContent(
    drawerOptions: List<NavItem>,
    selectedIndex: Int,
    onOptionClick: (NavItem) -> Unit,
) {
    Box(
        modifier = Modifier
            .background(
                Brush.verticalGradient(
                    listOf(
                        MaterialTheme.colors.primaryVariant,
                        MaterialTheme.colors.secondary
                    )
                )
            )
            .height(200.dp)
            .fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(16.dp))
    drawerOptions.forEachIndexed { index, navItem ->
        val selected = selectedIndex == index
        val colors = MaterialTheme.colors
        Row(
            modifier = Modifier
                .clickable { onOptionClick(navItem) }
                .fillMaxWidth()
                .padding(
                    8.dp,
                    4.dp
                )
                .clip(RoundedCornerShape(4.dp))
                .background(color = if (selected) colors.primary.copy(alpha = 0.12f) else colors.surface)
                .padding(12.dp)
        ) {
            Icon(
                imageVector = navItem.icon,
                tint = if (selected) colors.primary else colors.onSurface.copy(alpha = ContentAlpha.medium),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(24.dp))
            Text(
                text = stringResource(id = navItem.title),
                color = if (selected) colors.primary else colors.onSurface,
                style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
            )
        }
    }
}

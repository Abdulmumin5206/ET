package com.example.tracker.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit

/**
 * Text component with no animations
 */
@Composable
fun NoAnimText(
    text: String,
    fontSize: TextUnit,
    fontWeight: FontWeight = FontWeight.Normal,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = fontSize,
        fontWeight = fontWeight,
        modifier = modifier,
        softWrap = true,
        overflow = TextOverflow.Visible, // No ellipsis animation
        maxLines = Int.MAX_VALUE // No line truncation animation
    )
}

/**
 * Clickable modifier with no ripple animation
 */
fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = this.clickable(
    interactionSource = remember { MutableInteractionSource() },
    indication = null, // No ripple effect
    onClick = onClick
)

/**
 * Icon with no animations
 */
@Composable
fun NoAnimIcon(
    imageVector: ImageVector,
    contentDescription: String? = null,
    modifier: Modifier = Modifier
) {
    Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        modifier = modifier
    )
}

/**
 * Row with icon and text, no animations
 */
@Composable
fun NoAnimIconWithText(
    icon: ImageVector,
    text: String,
    fontSize: TextUnit,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.noRippleClickable(onClick)
    ) {
        NoAnimIcon(imageVector = icon)
        NoAnimText(text = text, fontSize = fontSize)
    }
} 
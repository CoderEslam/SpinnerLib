package com.chaaraapp.`spinner-compose`

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.doubleclick.spinner.theme.GrayLight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.doubleclick.spinner.theme.Black
import com.doubleclick.spinner.theme.BlueLight
import com.doubleclick.spinner.theme.BlueLightBackground


@Composable
fun <T> Spinner(
    modifier: Modifier = Modifier,
    borderColor: Color = GrayLight,
    shape: Shape = RoundedCornerShape(12.dp),
    items: List<T>,
    selectedItem: T,
    onItemSelected: (T) -> Unit,
    itemToString: (T) -> String = { it.toString() }, // Default toString conversion
    content: @Composable (() -> Unit) = {}
) {
    var expanded by remember { mutableStateOf(false) }
    val rotationAngle by animateFloatAsState(
        targetValue = if (expanded) 0f else 180f,
        animationSpec = tween(durationMillis = 300) // Adjust duration as needed
    )
    LaunchedEffect(selectedItem) {
        if (selectedItem != null) {
            Log.d("selectedItem", selectedItem.toString())
            onItemSelected(selectedItem)
        }
    }


    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .border(width = 1.dp, color = borderColor, shape = shape)
            .background(color = Color.White, shape = shape)
            .shadow(
                elevation = 1.dp,
                shape = shape
            )
            .background(
                color = Color.White,
                shape = shape
            )
    ) {
        Box(
            modifier = modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = itemToString(selectedItem),
                color = Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        expanded = true
                    }
                    .height(50.dp)
                    .padding(horizontal = 4.dp, vertical = 16.dp),
                fontSize = 18.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                softWrap = false,
                textAlign = TextAlign.Center,
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                items.forEach { item ->
                    DropdownMenuItem(
                        text = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                content()
                                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = itemToString(item),
                                    color = if (item == selectedItem) BlueLight else Black,
                                    modifier = Modifier.fillMaxWidth(),
                                    fontSize = 18.sp,
                                )
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        },
                        onClick = {
                            onItemSelected(item)
                            expanded = false
                        },
                        modifier = Modifier.background(
                            color = if (item == selectedItem) BlueLightBackground.copy(0.5f) else Color.Transparent,
                            shape = if (item == selectedItem) RoundedCornerShape(4.dp) else RoundedCornerShape(
                                0.dp
                            )
                        )
                    )
                }
            }
        }
        Image(
            painter = painterResource(R.drawable.baseline_arrow_back_ios_new_24),
            contentDescription = "",
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .size(24.dp)
                .rotate(rotationAngle)
                .clickable {
                    expanded = !expanded
                },
            colorFilter = ColorFilter.tint(color = Black)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Spinner(
        items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5"),
        selectedItem = "",
        onItemSelected = {

        }
    )
}
package com.example.googlesolution.presentation.drawer_destinations

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.R
import com.example.googlesolution.ui.theme.lightGreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AboutUsPage(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.surface,
            contentColor = MaterialTheme.colors.onSurface,
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.round_arrow_back_ios_new_24),
                        contentDescription = "Back"
                    )
                }
            },
            title = {
                Text(
                    text = "About Us",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    ),
                )
            }
        )
    }) {
        // TODO: Add About Us content here:
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .verticalScroll(rememberScrollState())
                .background(Color.White)
            ,
                ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.easidial_logo1),
                    contentDescription = "About Us Image",
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.FillBounds,
                )
                Text(
                    text = "Ubuntu Kwanzaa",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    ),
                )
                Text(
                    text = stringResource(id = R.string.versionNumber),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    ),
                    modifier = Modifier
                        .alpha(0.8f)
                )
            }
            Text(
                text = "A Project Proposal Submitted to the Faculty of Computing and Informatics for the Study Leading to a Project in Partial Fulfillment of the requirements for the Award of the Degree of Bachelor of computer science of Mbarara University of Science and Technology",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    textAlign = TextAlign.Justify
                ),
                modifier = Modifier.padding(8.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Supervisor: ",

                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    textAlign = TextAlign.Justify
                ),
                modifier = Modifier.padding(8.dp)
            )

            Text(
                text = "Dr. NTWARI RICHARD ",

                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    textAlign = TextAlign.Justify
                ),
                modifier = Modifier.padding(8.dp)
            )

            Text(
                text = "rntwari@must.ac.ug, +256-782776696",

                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    textAlign = TextAlign.Justify
                ),
                modifier = Modifier.padding(8.dp)
            )


            Text(
                text = "Contact Information",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                ),
                modifier = Modifier
                    .padding(top = 16.dp)
                    .alpha(0.8f)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.call),
                        contentDescription = "Call",
                        modifier = Modifier
                            .size(36.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.Black),
                        tint = Color.White
                    )
                }
                Text(
                    text = "+256 785711337",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    ),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.email),
                        contentDescription = "Email",
                        modifier = Modifier
                            .size(36.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.Black),
                        tint = Color.White
                    )
                }
                Text(
                    text = "2020bcs092@std.must.ac.ug",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    ),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.map_location),
                        contentDescription = "Call",
                        modifier = Modifier
                            .size(36.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.Black),
                        tint = Color.White
                    )
                }
                Text(
                    text = "Mbarara University of Science and Technology",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    ),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }


        }
    }
}

@Preview
@Composable
fun AboutUsPagePrev() {
    AboutUsPage(rememberNavController())
}

// Expandable card for Terms of Use and Privacy Policy
@Composable
fun AboutExpandableCard(
    title: String,
    content: @Composable () -> Unit,
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White)
        ,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .background(Color.White)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.White)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.subtitle2,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .weight(1f)
                        .alpha(0.8f),
                    textAlign = TextAlign.Start
                )
                Icon(
                    imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Expand/Collapse",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(24.dp)
                        .padding()
                        .background(lightGreen, CircleShape)
                )
            }
            if (expanded) {
                content()
                // TODO - IMPROVE ON CONTENT STYLING
            }
        }
    }
}
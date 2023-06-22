package com.example.googlesolution.presentation.homeviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.R
import com.example.googlesolution.ui.theme.EarthDark
import com.example.googlesolution.ui.theme.GoogleSolutionTheme
import com.example.googlesolution.ui.theme.lightGreener

@Composable
fun HomeView(
    navController: NavHostController,
) {
    MaterialTheme {
        Scaffold(
            modifier = Modifier
                //.background(BlueMildest)
                .fillMaxSize(),
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    //.background(BlueMildest)
                    .verticalScroll(rememberScrollState())
            ) {
                // SDG reference
                // Banner - Mission + Team + Vision
                LazyRow(
                    modifier = Modifier.padding(8.dp),
                ) {
                    item {
                        Card(
                            shape = RoundedCornerShape(24.dp),
                            modifier = Modifier
                                .padding(5.dp)
                                .width(350.dp)
                                .height(160.dp),
                            elevation = 4.dp,
                            backgroundColor = MaterialTheme.colors.surface
                        ) {
                            Column(
                                modifier = Modifier
                                    // .background(MaterialTheme.colors.primaryVariant)
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "Ubuntu Kwanzaa",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .padding(8.dp),
                                )
                                Text(
                                    text = "Connect to a network of emergency services, ensuring quick response times and expert medical care.",
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .padding(start = 8.dp, end = 8.dp)
                                        .alpha(0.9f),
                                )
                            }
                        }
                    }

                    item {
                        Card(
                            shape = RoundedCornerShape(24.dp),
                            modifier = Modifier
                                .padding(5.dp)
                                .width(350.dp)
                                .height(160.dp),
                            elevation = 4.dp,
                            backgroundColor = MaterialTheme.colors.surface
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(8.dp)
                            ) {
                                Text(
                                    text = "Fast and Reliable",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .padding(8.dp),
                                )
                                Text(
                                    text = "Tap a button to alert emergency services in your area, and saving lives.",
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .padding(start = 8.dp, end = 8.dp)
                                        .alpha(0.9f),
                                )
                            }
                        }
                    }

                    item {
                        Card(
                            shape = RoundedCornerShape(24.dp),
                            modifier = Modifier
                                .padding(5.dp)
                                .width(350.dp)
                                .height(160.dp),
                            elevation = 4.dp,
                            backgroundColor = MaterialTheme.colors.surface
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(8.dp)
                            ) {
                                Text(
                                    text = "Location Sharing",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .padding(8.dp),
                                )
                                Text(
                                    text = "Our app uses advanced GPS technology to pinpoint your exact location and share it with emergency responders, allowing them to reach you faster.",
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .padding(start = 8.dp, end = 8.dp)
                                        .alpha(0.9f),
                                )
                            }
                        }
                    }

                    item {
                        Card(
                            shape = RoundedCornerShape(24.dp),
                            modifier = Modifier
                                .padding(5.dp)
                                .width(350.dp)
                                .height(160.dp),
                            elevation = 4.dp,
                            backgroundColor = MaterialTheme.colors.surface
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(8.dp)
                            ) {
                                Text(
                                    text = "Vital Information",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .padding(8.dp),
                                )
                                Text(
                                    text = "Store your medical history, allergies, and emergency contacts securely within the app, enabling medical professionals to make informed decisions.",
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .padding(start = 8.dp, end = 8.dp)
                                        .alpha(0.9f),
                                )
                            }
                        }
                    }

                    item {
                        Card(
                            shape = RoundedCornerShape(24.dp),
                            modifier = Modifier
                                .padding(5.dp)
                                .width(350.dp)
                                .height(160.dp),
                            elevation = 4.dp,
                            backgroundColor = MaterialTheme.colors.surface
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(8.dp)
                            ) {
                                Text(
                                    text = "Emergency Contacts",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .padding(8.dp),
                                )
                                Text(
                                    text = " Easily add and manage emergency contacts, ensuring your loved ones are informed in critical situations.",
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .padding(start = 8.dp, end = 8.dp)
                                        .alpha(0.9f),
                                )
                            }
                        }
                    }

                    item {
                        Card(
                            shape = RoundedCornerShape(24.dp),
                            modifier = Modifier
                                .padding(5.dp)
                                .width(350.dp)
                                .height(160.dp),
                            elevation = 4.dp,
                            backgroundColor = MaterialTheme.colors.surface
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(8.dp)
                            ) {
                                Text(
                                    text = "AI-Assisted CPR and Hemostasis",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .padding(8.dp),
                                )
                                Text(
                                    text = "AI-assisted CPR and Hemostasis feature to provide step-by-step instructions and guidance)",
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .padding(start = 8.dp, end = 8.dp)
                                        .alpha(0.9f),
                                )
                            }
                        }
                    }

                    item {
                        Card(
                            shape = RoundedCornerShape(24.dp),
                            modifier = Modifier
                                .padding(5.dp)
                                .width(350.dp)
                                .height(160.dp),
                            elevation = 4.dp,
                            backgroundColor = MaterialTheme.colors.surface
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(8.dp)
                            ) {
                                Text(
                                    text = "SOS: Immediate Assistance at Your Fingertips",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .padding(8.dp),
                                )
                                Text(
                                    text = " Users can activate the SOS button within the app with a single tap, triggering an alert to emergency services in their area",
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .padding(start = 8.dp, end = 8.dp)
                                        .alpha(0.9f),
                                )
                            }
                        }
                    }


                }
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        shape = RoundedCornerShape(24.dp),
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(5.dp)
                            .height(180.dp),
                        elevation = 4.dp,
                        backgroundColor = MaterialTheme.colors.surface
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(8.dp)
                        ) {
                            Text(
                                text = "Hospitals",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(8.dp),
                            )
                            Text(
                                text = "In case of emergency, get help",
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .padding(start = 8.dp, end = 8.dp, bottom = 32.dp)
                                    .alpha(0.9f),
                            )
                            IconButton(
                                onClick = {
                                    navController.navigate("hospitalsview")
                                },
                                modifier = Modifier
                                    .padding()
                                    .align(Alignment.End)
                                    .background(Color.Black, CircleShape)
                                    .clip(CircleShape)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowForward,
                                    contentDescription = "arrow forward",
                                    tint = MaterialTheme.colors.onSecondary,
                                )

                            }
                        }
                    }
                    Card(
                        shape = RoundedCornerShape(24.dp),
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(5.dp)
                            .height(180.dp),
                        elevation = 4.dp,
                        backgroundColor = MaterialTheme.colors.secondary
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(8.dp)
                        ) {
                            Text(
                                text = "Ambulances",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(8.dp),
                            )
                            Text(
                                text = "Access Emergency Services",
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .padding(start = 8.dp, end = 8.dp, bottom = 32.dp)
                                    .alpha(0.9f),
                            )
                            IconButton(
                                onClick = {
                                    navController.navigate("ambulances")
                                },
                                modifier = Modifier
                                    .padding()
                                    .align(Alignment.End)
                                    .background(Color.Black, CircleShape)
                                    .clip(CircleShape)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowForward,
                                    contentDescription = "arrow forward",
                                    tint = MaterialTheme.colors.onSecondary,
                                )

                            }
                        }
                    }


                }
                Row(
                    modifier = Modifier
                        .padding(8.dp, top = 0.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        shape = RoundedCornerShape(24.dp),
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(5.dp)
                            .height(180.dp),
                        elevation = 4.dp, backgroundColor = MaterialTheme.colors.surface
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(8.dp)
                        ) {
                            Text(
                                text = "CPR",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(8.dp),
                            )
                            Text(
                                text = "AI Assisted CPR and Hemostasis",
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .padding(start = 8.dp, end = 8.dp, bottom = 32.dp)
                                    .alpha(0.9f),
                            )
                            IconButton(
                                onClick = {
                                    navController.navigate("emergencylessons")
                                },
                                modifier = Modifier
                                    .padding()
                                    .align(Alignment.End)
                                    .background(Color.Black, CircleShape)
                                    .clip(CircleShape)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowForward,
                                    contentDescription = "arrow forward",
                                    tint = MaterialTheme.colors.onSecondary,
                                )

                            }
                        }

                    }
                    Card(
                        shape = RoundedCornerShape(24.dp),
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(5.dp)
                            .height(180.dp),
                        elevation = 4.dp,
                        backgroundColor = MaterialTheme.colors.secondary
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(8.dp)
                        ) {
                            Text(
                                text = "SOS",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(8.dp),
                            )
                            Text(
                                text = "Active an Emergency SOS",
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .padding(start = 8.dp, end = 8.dp, bottom = 32.dp)
                                    .alpha(0.9f),
                            )
                            IconButton(
                                onClick = {
                                    navController.navigate("")
                                },
                                modifier = Modifier
                                    .padding()
                                    .align(Alignment.End)
                                    .background(Color.Red, CircleShape)
                                    .clip(CircleShape)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowForward,
                                    contentDescription = "arrow forward",
                                    tint = MaterialTheme.colors.onSecondary,
                                )

                            }
                        }

                    }



                }
                Row(
                    modifier = Modifier
                        .padding(8.dp, top = 0.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        shape = RoundedCornerShape(24.dp),
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(5.dp)
                            .height(180.dp),
                        elevation = 4.dp, backgroundColor = MaterialTheme.colors.secondary
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(8.dp)
                        ) {
                            Text(
                                text = "Report",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(8.dp),
                            )
                            Text(
                                text = "Report an Emergency Incident",
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .padding(start = 8.dp, end = 8.dp, bottom = 32.dp)
                                    .alpha(0.9f),
                            )
                            IconButton(
                                onClick = {
                                    navController.navigate("")
                                },
                                modifier = Modifier
                                    .padding()
                                    .align(Alignment.End)
                                    .background(EarthDark, CircleShape)
                                    .clip(CircleShape)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowForward,
                                    contentDescription = "arrow forward",
                                    tint = MaterialTheme.colors.onSecondary,
                                )

                            }
                        }

                    }}

                Card(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(MaterialTheme.colors.background),
                    elevation = 4.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        MilestoneBox(
                            milestoneName = "Assisted CPR and Hemostasis",
                            milestoneNumber = "AI",
                            modifier = Modifier.weight(1f)
                        )
                        Box(
                            modifier = Modifier
                                .background(Color.Black, RoundedCornerShape(4.dp))
                                .height(100.dp)
                                .width(1.dp)
                        )
                        MilestoneBox(
                            milestoneName = "Heart And Fall Detection",
                            milestoneNumber = "WearOS",
                            modifier = Modifier.weight(1f)
                        )
                        Box(
                            modifier = Modifier
                                .background(Color.Black, RoundedCornerShape(4.dp))
                                .height(100.dp)
                                .width(1.dp)
                        )
                        MilestoneBox(
                            milestoneName = "Family, Police + Emergency Services with a Tap",
                            milestoneNumber = "Inform",
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                Text(
                    text = "Ubuntu Kwanzaa",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 20.dp)
                        .alpha(0.8f),
                )
                Text(
                    text = "All in One Emergency Service Assistant",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 4.dp, bottom = 16.dp)
                        .alpha(0.5f),
                )
            }
        }
    }
}


// card for the milestones
@Composable
fun MilestoneBox(
    milestoneName: String,
    milestoneNumber: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = milestoneNumber,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = milestoneName,
            fontSize = 12.sp,
            fontWeight = FontWeight.ExtraLight,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AboutUsViewPreview() {
    GoogleSolutionTheme(darkTheme = false) {
        HomeView(navController = rememberNavController())
    }
}



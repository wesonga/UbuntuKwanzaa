package com.example.googlesolution.presentation.hosplocationview

import android.location.Location
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


@Composable
fun HospitalsMapView(
    navController: NavHostController,
) {
    val context = LocalContext.current
    val mapView = MapView(context).apply {
        onCreate(null)
        getMapAsync { googleMap ->
            // Setting Kenya as the map's location
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(-0.0236, 37.9062)))

            // Adding markers for hospitals around Nairobi

            val nairobi = LatLng(-0.607160, 30.654503)
            val hospitals = listOf(
                Pair("Holy Innocents Children's Hospital, Mbarara", LatLng(-0.6204463949633742, 30.647948986125567)),
                Pair("Mbarara Regional Referral Hospital", LatLng(-0.6187298815962092, 30.635417705495847)),
                Pair("Mbarara Doctors' Plaza Hospital", LatLng(-0.6105787623606836, 30.659533075239665)),
                Pair("Ruharo Mission Hopital",
                    LatLng(-0.6118322324613144, 30.63085065178205)),
                Pair("Divine Mercy Hospital (Father Bash Foundation)",
                    LatLng(-0.6086032381414471, 30.645203591202648)),
                Pair("Mayanja Memorial Hospital", LatLng(-0.589702415031032, 30.671669713210434)),
                Pair("Mbarara University And Referral Hospital Eye Centre", LatLng(-0.6126234986397199, 30.657469002106417)),
                Pair("Mbarara Hospital", LatLng(-0.6142128716406423, 30.657128402648055)),
                Pair("International Medical Center - IMC Mbarara", LatLng(-0.6051460240293377, 30.663053694109653)),
                Pair("CITY MEDICAL CHAMBERS HOSPITAL -MBARARA", LatLng(-0.6090504760593405, 30.6659763358789)),
                Pair("Mbarara Community Hospital",
                    LatLng(-0.5824155641235814, 30.653404670194476)),
                Pair("Mbarara Medical Specialists Clinic", LatLng(-0.6080346418428046, 30.66245197958615)),
                Pair("C-Care IMC Mbarara", LatLng(-0.6073480150134621, 30.660649531960797)),
                Pair("Marie Stopes Mbarara Center",
                    LatLng(-0.607694020454075, 30.647051632573316)),
                Pair("Ruharo Eye Centre", LatLng(-0.6109661304005568, 30.631097853355023)),
                )


            hospitals.forEach {
                googleMap.addMarker(
                    MarkerOptions().position(it.second).title(it.first)
                )
            }

            // Zoom in on the closest hospital to Nairobi
            val closestHospital = hospitals.minByOrNull {
                val location1 = Location("")
                location1.latitude = it.second.latitude
                location1.longitude = it.second.longitude

                val location2 = Location("")
                location2.latitude = nairobi.latitude
                location2.longitude = nairobi.longitude

                location1.distanceTo(location2)
            }
            closestHospital?.let {
                val zoomLevel = 12f
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(it.second, zoomLevel))
            }
        }
    }
        AndroidView(
            factory = { mapView }
        ) {
            it.onResume()
        }
}


// Preview
@Preview
@Composable
fun PreviewHospitalsMapView() {
    HospitalsMapView(navController = rememberNavController())
}
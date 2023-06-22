package com.example.googlesolution.datalayer.screensviewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.googlesolution.R
import kotlinx.coroutines.flow.*

class HospitalsViewModel: ViewModel(){

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _hospitals = MutableStateFlow(allhospitals)

    val hospitals = searchText
        .combine(_hospitals) { text, hospitals ->
            if (text.isBlank()) {
                hospitals
            } else {
                hospitals.filter {
                    it.doesMatchSearchuery(text)
                }
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _hospitals.value
        )

    fun onSearchTermChange(text: String) {
        _searchText.value = text
    }
}
data class Hospital(
    val hospImage: Int,
    val name: String,
    val about: String,
    val contact: String,
    val location: String,
    val services: String,
    val hasAmbulance: Boolean,
) {
    fun doesMatchSearchuery(query: String): Boolean {
        val matchingCombinations = listOf(
            "${name}${contact}",
            "${name.first()} ${contact}",
            "${name} ${contact.first()}",
            "${name} ${contact}",
            "${name.first()} ${contact.first()}",
            "${name.first()} ${location.first()}",
            "${hasAmbulance}",
        )
        return matchingCombinations.any{
            it.contains(query, ignoreCase = true)
        }
    }
}

private val allhospitals =
    listOf(
        Hospital(
            hospImage = R.drawable.holyinnocents,
            name = "Holy Innocents Children's Hospital, Mbarara",
            about = "A non-political, non-sectarian, faith-based children’s hospital in Mbarara",
            contact = "0774634279",
            location = "Mwinzi-Isingiro Road",
            services = "Emergency, Surgery, Pediatrics",
            hasAmbulance = true
        ),
        Hospital(
            hospImage = R.drawable.referral,
            name = "Mbarara Regional Referral Hospital",
            about = " A Government owned referral hospital and a teaching hospital for The Medical School of Mbarara University of Science and Technology.",
            contact = "0701995356",
            location = "Mbarara Town Council",
            services = "Emergency, Surgery, Pediatrics",
            hasAmbulance = true
        ),
        Hospital(
            hospImage = R.drawable.plaza,
            name = "Mbarara Doctors' Plaza Hospital",
            about = "A specialized hospital providing a range of healthcare services",
            contact = "0702336110",
            location = " Opposite Bank of Uganda, Adit Mall",
            services = "Emergency, Cardiology, Neurology",
            hasAmbulance = true
        ),
        Hospital(
            hospImage = R.drawable.ruharo,
            name = "Ruharo Mission Hopital",
            about = "A Private-Not-For-Profit Faith based Hospital of Church of Uganda-under Ankole Diocese",
            contact = "0393248462",
            location = "Mbarara Bushenyi Road",
            services = "Emergency, Oncology, Dermatology, Psychiatry",
            hasAmbulance = true
        ),
        Hospital(
            hospImage = R.drawable.divine,
            name = "Divine Mercy Hospital",
            about = "Father Bash Foundation",
            contact = "0772618751",
            location = "Rwebikona",
            services = "Emergency, Ophthalmology, Orthopedics",
            hasAmbulance = true
        ),
        Hospital(
            hospImage = R.drawable.memorial,
            name = "Mayanja Memorial Hospital",
            about = "Mbarara Municiple Council./P.O.Box 920, Mbarara",
            contact = "0392962665",
            location = "Kabale-Mbarara Road",
            services = "Emergency, Gynecology, Urology, Radiology",
            hasAmbulance = true
        ),
        Hospital(
            hospImage = R.drawable.eye,
            name = "Mbarara University And Referral Hospital Eye Centre",
            about = "Mbarara University of Science and Technology",
            contact = "0701995356",
            location = "Mbarara University of Science and Technology",
            services = "Emergency, Ophthalmology",
            hasAmbulance = false
        ),
        Hospital(
            hospImage = R.drawable.mbra,
            name = "Mbarara Hospital",
            about = "Mbarara District Regional Referral Hospital",
            contact = "0701995356",
            location = "Mbarara District Regional Referral Hospital",
            services = "Emergency, Surgery, Pediatrics",
            hasAmbulance = true
        ),
        Hospital(
            hospImage = R.drawable.imc,
            name = "International Medical Center - IMC Mbarara",
            about = "IMC Mbarara",
            contact = "0393280696",
            location = "Upper Ground Floor Mbarara Commercial Complex",
            services = "Emergency, Obstetrics, Cardiology, Neurology",
            hasAmbulance = false
        ),
        Hospital(
            hospImage = R.drawable.city,
            name = "City Medical Chambers Hospital -Mbarara",
            about = "Plot 28 Mac Allister Road Lugazi Round About Opposite Kabaterine Kindegarten, Mbarara",
            contact = "0200909495",
            location = "Lugazi Round About Opposite Kabaterine Kindegarten, Mbarara",
            services = "Oncology, Dermatology, Emergency",
            hasAmbulance = false
        ),
        Hospital(
            hospImage = R.drawable.community,
            name = "Mbarara Community Hospital",
            about = "Mbarara Municiple Council, Mbarara",
            contact = "0485421445",
            location = "Kakkika",
            services = "Emergency, Ophthalmology, Orthopedics",
            hasAmbulance = false
        ),
        Hospital(
            hospImage = R.drawable.specialists,
            name = "Mbarara Medical Specialists Clinic",
            about = "Mbarara Medical Specialists Clinic",
            contact = "0701050856",
            location = "27 Bananuka Rd, Mbarara",
            services = "Emergency, Gynecology, Urology, Radiology",
            hasAmbulance = true
        ),
        Hospital(
            hospImage = R.drawable.ccare,
            name = "C-Care IMC Mbarara",
            about = "IMC",
            contact = "0393280696",
            location = "Amazon House, Mbarara - Masaka Rd",
            services = "Emergency, Dentistry, Ophthalmology, Orthopedics",
            hasAmbulance = false
        ),
        Hospital(
            hospImage = R.drawable.marie,
            name = "Marie Stopes Mbarara Center",
            about = "Marie Stopes",
            contact = "0800220333",
            location = "Plot 8, McAlister Road, Mbarara",
            services = "Emergency, Surgery, Pediatrics",
            hasAmbulance = false
        ),

    )

data class TopHospitals(
    val hospImage: Int,
    val hospitalName: String,
    val hospitalContacts: String,
    val hasAmbulance: Boolean
)

val topHospitals = listOf(
    TopHospitals(
        hospImage = R.drawable.referral,
        hospitalName = "Mbarara Regional Referral Hospital",
        hospitalContacts = "0701995356",
        hasAmbulance = true
    ),
    TopHospitals(
        hospImage = R.drawable.ruharo,
        hospitalName = "Ruharo Mission Hopital",
        hospitalContacts = "0393248462",
        hasAmbulance = true
    ),
    TopHospitals(
        hospImage = R.drawable.memorial,
        hospitalName = "Mayanja Memorial Hospital",
        hospitalContacts = "0392962665",
        hasAmbulance = true
    ),
    TopHospitals(
        hospImage = R.drawable.plaza,
        hospitalName = "Mbarara Doctors' Plaza Hospital",
        hospitalContacts = "0702336110",
        hasAmbulance = true
    ),
    TopHospitals(
        hospImage = R.drawable.divine,
        hospitalName = "Divine Mercy Hospital",
        hospitalContacts = "0772618751",
        hasAmbulance = true
    ),
)

// AMBULANCES
data class TopAmbulances(
    val ambImage: Int,
    val name: String,
    val contact: String,
    val location: String,
)

val topAmbulances =
    listOf(
        TopAmbulances(
            ambImage = R.drawable.ambulance_mbra,
            name = "Mbarara Regional Referral Ambulance",
            contact = "0701995356",
            location = "Mbarara Town Council",
        ),
        TopAmbulances(
            ambImage = R.drawable.ambulance_red,
            name = "Red Cross Ambulance",
            contact = "0414258701",
            location = "Maternal, Newborn, and Child Health Institute",
        ),
        TopAmbulances(
            ambImage = R.drawable.ambulance_ruharo,
            name = "Ruharo Mission Ambulance",
            contact = "0393248462",
            location = "Mbarara Bushenyi Road",
        ),
        TopAmbulances(
            ambImage = R.drawable.ambulance_maya,
            name = "Mayanja Memorial Ambulance",
            contact = "0392962665",
            location = "Kabale-Mbarara Road",
        ),
        TopAmbulances(
            ambImage = R.drawable.ambulance_plaza,
            name = "Mbarara Doctors' Plaza Ambulance",
            contact = "0702336110",
            location = "Opposite Bank of Uganda, Adit Mall",
        ),
        TopAmbulances(
            ambImage = R.drawable.ambulance_bash,
            name = "Divine Mercy Ambulance",
            contact = "0772618751",
            location = "Rwebikona",
        ),
    )

// AMBULANCES
class AmbulancesViewModel: ViewModel(){

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _ambulances = MutableStateFlow(allambulances)

    val ambulances = searchText
        .combine(_ambulances) { text, ambulances ->
            if (text.isBlank()) {
                ambulances
            } else {
                ambulances.filter {
                    it.doesMatchSearchuery(text)
                }
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _ambulances.value
        )

    fun onSearchTermChange(text: String) {
        _searchText.value = text
    }
}

data class Ambulances(
    val ambImage: Int,
    val name: String,
    val contact: String,
) {
    fun doesMatchSearchuery(query: String): Boolean {
        val matchingCombinations = listOf(
            "${name}${contact}",
            "${name.first()} ${contact}",
            "${name} ${contact.first()}",
            "${name} ${contact}",
            "${name} ${contact.first()}",
            "${name.first()} ${contact}",
            "${name.first()} ${contact.first()}"
        )
        return matchingCombinations.any{
            it.contains(query, ignoreCase = true)
        }
    }
}

val allambulances =
    listOf(
        Ambulances(
            ambImage = R.drawable.ambulance_mbra,
            name = "Mbarara Referral",
            contact = "0701995356",
        ),
        Ambulances(
            ambImage = R.drawable.ambulance_red,
            name = "Red Cross Ambulance",
            contact = "0414258701",
        ),
        Ambulances(
            ambImage = R.drawable.ambulance_ruharo,
            name = "Ruharo Mission",
            contact = "0393248462",
        ),
        Ambulances(
            ambImage = R.drawable.ambulance_plaza,
            name = "Mbarara Doctors' Plaza",
            contact = "0702336110",
        ),

        Ambulances(
            ambImage = R.drawable.ambulance_maya,
            name = "Mayanja Memorial",
            contact = "0392962665",
        ),
        Ambulances(
            ambImage = R.drawable.ambulance_bash,
            name = "Divine Mercy",
            contact = "0772618751",
        ),
        Ambulances(
            ambImage = R.drawable.ambulance_city,
            name = "City Medical",
            contact = "0772618751",
        ),
        Ambulances(
            ambImage = R.drawable.ambulance_holy,
            name = "Holy Innocents",
            contact = "0776164640",
        )
    )

// EMERGENCY LESSONS
class LessonsViewModel: ViewModel(){

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _lessons = MutableStateFlow(alllessons)

    val lessons = searchText
        .combine(_lessons) { text, lessons ->
            if (text.isBlank()) {
                lessons
            } else {
                lessons.filter {
                    it.doesMatchSearchuery(text)
                }
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _lessons.value
        )

            fun onSearchTermChange(text: String) {
                _searchText.value = text
            }
}



data class EmergencyLessons(
    val lessonImage: Int,
    val lessonName: String,
    val description: String,
    val severityState: String,
) {
    fun doesMatchSearchuery(query: String): Boolean {
        val matchingCombinations = listOf(
            "${lessonName}",
            "${description}",
            "${severityState}"
        )
        return matchingCombinations.any{
            it.contains(query, ignoreCase = true)
        }
    }
}

private val alllessons =
    listOf(
        // Allergic reactions
        EmergencyLessons(
            lessonImage = R.drawable.allergic_reactions,
            lessonName = "Allergic Reactions",
            description = "An allergic reaction is a reaction to a substance that your body sees as harmful. The immune system makes antibodies to fight the substance. These antibodies cause symptoms such as a rash, hives, or swelling. An allergic reaction is a medical emergency. If you think you or someone else is having an allergic reaction, call 911 right away.",
            severityState = "Mild"
        ),
        // add asthma attacks
        EmergencyLessons(
            lessonImage = R.drawable.asthma_attacks,
            lessonName = "Asthma Attacks",
            description = "Asthma is a lung disease that causes the airways to narrow and swell. This makes it hard to breathe. Asthma attacks can be mild, moderate, or severe. An asthma attack is a medical emergency. If you think you or someone else is having an asthma attack, call 911 right away.",
            severityState = "Mild"

        ),
        EmergencyLessons(
            lessonImage = R.drawable.learn_cardiac,
            lessonName = "Heart Attack",
            description = "Cardiac arrest is a medical emergency that occurs when the heart suddenly stops beating. This can lead to a sudden loss of consciousness, absence of breathing and pulse, and ultimately brain damage or death if not treated promptly. The severity of cardiac arrest is extremely high, as it can lead to irreversible damage to vital organs within minutes if not treated immediately. The survival rate is relatively low, and immediate CPR and defibrillation are essential to increase the chances of successful resuscitation and survival. Cardiac Arrest is a life threatening medical emergency. If you think you or someone else is having a heart attack, call 911 right away.",
            severityState = "Life threatening"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.burns,
            lessonName = "Burns",
            description = "A burn is damage to the skin or other tissues caused by heat, electricity, chemicals, or radiation. Burns can be minor, such as a sunburn, or major, such as a burn from a fire or an explosion. Burns can affect the skin, muscles, tendons, ligaments, and bones. A burn is a medical emergency. If you think you or someone else has a burn, call 911 right away.",
            severityState = "Mild"
        ),
        // add carbon monoxide poisoning
        EmergencyLessons(
            lessonImage = R.drawable.learn_poison,
            lessonName = "Carbon Monoxide Poisoning",
            description = "Carbon monoxide is a colorless, odorless gas. It's produced when fuel doesn't burn completely. Carbon monoxide can build up in enclosed spaces. This can cause poisoning. Carbon monoxide poisoning is a medical emergency. If you think you or someone else is having carbon monoxide poisoning, call 911 right away.",
            severityState = "Life threatening"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.choking,
            lessonName = "Choking",
            description = "Choking is when food, an object, or another substance blocks the airway. This can cause breathing problems or even death. Choking is a medical emergency. If you think you or someone else is choking, call 911 right away.",
            severityState = "Mild"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.cpr,
            lessonName = "CPR",
            description = "CPR stands for cardiopulmonary resuscitation. It's a lifesaving technique that combines chest compressions with rescue breaths. CPR is used when someone's heart has stopped or when they're not breathing normally. CPR can keep oxygen-rich blood flowing to the brain and other vital organs until emergency medical services arrive. CPR is a medical emergency. If you think you or someone else needs CPR, call 911 right away.",
            severityState = "Life threatening"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.diabetes,
            lessonName = "Diabetes",
            description = "Diabetes is a disease in which your blood glucose, or blood sugar, levels are too high. Glucose comes from the foods you eat. Insulin is a hormone that helps the glucose get into your cells to give them energy . With diabetes, your body either doesn't make enough insulin or can't use its own insulin as well as it should. This causes glucose to build up in your blood instead of going into your cells. Over time, high blood glucose can cause serious health problems.",
            severityState = "Mild"
        ),
        // add drowning
        EmergencyLessons(
            lessonImage = R.drawable.drowning,
            lessonName = "Drowning",
            description = "Drowning is when a person's breathing or ability to move is impaired by being in or under water. Drowning can happen in as little as 30 seconds. Drowning is a medical emergency. If you think you or someone else is drowning, call 911 right away.",
            severityState = "Life threatening"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.electric_shock,
            lessonName = "Electrical Shock",
            description = "An electrical shock occurs when the body comes into contact with an electrical source. This can happen when a person touches a live wire or when a person is struck by lightning. Electrical shocks can cause burns, muscle spasms, and even death. An electrical shock is a medical emergency. If you think you or someone else has been shocked, call 911 right away.",
            severityState = "Life threatening"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.fainting,
            lessonName = "Fainting",
            description = "Fainting is a temporary loss of consciousness caused by a lack of blood flow to the brain. It's also called syncope. Fainting can be caused by a variety of things, including low blood sugar, dehydration, and heart problems. Fainting is a medical emergency. If you think you or someone else is fainting, call 911 right away.",
            severityState = "Mild"
        ),
        // add febrile seizures
        EmergencyLessons(
            lessonImage = R.drawable.seizures,
            lessonName = "Febrile Seizures",
            description = "A febrile seizure is a seizure that happens when a child has a fever. Febrile seizures are common in children. They usually last less than 15 minutes. Most febrile seizures are harmless. But they can be a medical emergency. If you think your child is having a febrile seizure, call 911 right away.",
            severityState = "Mild"

        ),
        EmergencyLessons(
            lessonImage = R.drawable.frosbite,
            lessonName = "Frostbite",
            description = "Frostbite is a condition that occurs when your skin and tissues freeze. It most often affects your fingers, toes, ears, and nose. Frostbite can cause permanent damage to your body. Frostbite is a medical emergency. If you think you or someone else has frostbite, call 911 right away.",
            severityState = "Mild"
        ),
        // add head injuries
        EmergencyLessons(
            lessonImage = R.drawable.head_injury,
            lessonName = "Head Injuries",
            description = "A head injury is any injury to the head or brain. Head injuries can be mild, such as a bump or bruise, or severe, such as a skull fracture or traumatic brain injury. Head injuries are a medical emergency. If you think you or someone else has a head injury, call 911 right away.",
            severityState = "Severe"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.learn_heart,
            lessonName = "Heart Attack",
            description = "A heart attack occurs when the flow of blood to the heart is blocked. This can happen when a blood clot forms in an artery that supplies blood to the heart muscle. The heart muscle begins to die, and the heart can't pump blood as well as it should. A heart attack is a medical emergency. If you think you or someone else is having a heart attack, call 911 right away.",
            severityState = "Life threatening"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.heat_stroke,
            lessonName = "Heatstroke",
            description = "Heatstroke is a serious medical condition that occurs when your body becomes unable to control its temperature. This happens when your body produces too much heat and can't sweat enough to cool down. Heatstroke can cause damage to your brain, heart, kidneys, and other organs. Heatstroke is a medical emergency. If you think you or someone else has heatstroke, call 911 right away.",
            severityState = "Life threatening"
        ),
        // add insect bites
        EmergencyLessons(
            lessonImage = R.drawable.insect_bites,
            lessonName = "Insect Bites",
            description = "Insect bites are caused by stinging insects, such as bees, wasps, and hornets. Insect bites can cause pain, swelling, and itching. Insect bites are a medical emergency. If you think you or someone else has been bitten by an insect, call 911 right away.",
            severityState = "Mild"
        ),

        EmergencyLessons(
            lessonImage = R.drawable.hypothermia,
            lessonName = "Hypothermia",
            description = "Hypothermia is a condition in which your body temperature drops below 95°F (35°C). Hypothermia can occur when you're exposed to cold temperatures for a long time or when you're in very cold water. Hypothermia can cause your heart, brain, and other vital organs to slow down or stop working. Hypothermia is a medical emergency. If you think you or someone else has hypothermia, call 911 right away.",
            severityState = "Life threatening"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.learn_poison,
            lessonName = "Poisoning",
            description = "Poisoning occurs when you take in a substance that can harm your body. This can happen when you eat or drink something poisonous, breathe in poisonous fumes, or get a poisonous substance on your skin. Poisoning can cause a variety of symptoms, including nausea, vomiting, diarrhea, and seizures. Poisoning is a medical emergency. If you think you or someone else has been poisoned, call 911 right away.",
            severityState = "Life threatening"
        ),
        // add snake bites
        EmergencyLessons(
            lessonImage = R.drawable.snake_bite,
            lessonName = "Snake Bites",
            description = "Snake bites are caused by venomous snakes. Snake bites can cause pain, swelling, and itching. Snake bites are a medical emergency. If you think you or someone else has been bitten by a snake, call 911 right away.",
            severityState = "Mild"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.severe_bleeding,
            lessonName = "Severe Bleeding",
            description = "Severe bleeding is bleeding that won't stop on its own. It can be caused by a variety of things, including cuts, broken bones, and puncture wounds. Severe bleeding is a medical emergency. If you think you or someone else is bleeding severely, call 911 right away.",
            severityState = "Life threatening"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.seizures,
            lessonName = "Seizures",
            description = "A seizure is a sudden change in the way your brain works. It can cause changes in your behavior or how your body works. Seizures can be caused by a variety of things, including high fevers, head injuries, and certain medical conditions. Seizures are a medical emergency. If you think you or someone else is having a seizure, call 911 right away.",
            severityState = "Mild"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.learn_stroke,
            lessonName = "Stroke",
            description = "A stroke occurs when blood flow to part of your brain is interrupted or reduced, depriving brain tissue of oxygen and nutrients. This can cause brain cells to die. A stroke is a medical emergency. If you think you or someone else is having a stroke, call 911 right away.",
            severityState = "Life threatening"
        ),
        // add suicidal thoughts
        EmergencyLessons(
            lessonImage = R.drawable.suicidal_thoughts,
            lessonName = "Suicidal Thoughts",
            description = "Suicidal thoughts are thoughts about killing yourself. Suicidal thoughts can be caused by a variety of things, including depression, anxiety, and substance abuse. Suicidal thoughts are a medical emergency. If you think you or someone else is having suicidal thoughts, call 911 right away.",
            severityState = "Mild"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.traumatic_brain_injury,
            lessonName = "Traumatic Brain Injury",
            description = "A traumatic brain injury (TBI) occurs when a bump, blow, or jolt to the head causes damage to the brain. A TBI can cause a variety of symptoms, including headaches, dizziness, and memory loss. A TBI is a medical emergency. If you think you or someone else has a TBI, call 911 right away.",
            severityState = "Life threatening"
        ),
        // add unconsciousness
        EmergencyLessons(
            lessonImage = R.drawable.nose_bleed,
            lessonName = "Nose Bleeding",
            description = "Nose bleeding is bleeding from the nose. Nose bleeding can be caused by a variety of things, including colds, allergies, and nose picking. Nose bleeding is a medical emergency. If you think you or someone else is bleeding from the nose, call 911 right away.",
            severityState = "Mild"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.domestic_violence,
            lessonName = "Domestic Violence",
            description = "Domestic violence is a pattern of abusive behavior in any relationship that is used by one partner to gain or maintain power and control over another intimate partner. Domestic violence can be physical, sexual, emotional, economic, or psychological actions or threats of actions that influence another person. This includes any behaviors that intimidate, manipulate, humiliate, isolate, frighten, terrorize, coerce, threaten, blame, hurt, injure, or wound someone. Domestic violence is a medical emergency. If you think you or someone else is experiencing domestic violence, call 911 right away.",
            severityState = "Mild"
        ),
    )


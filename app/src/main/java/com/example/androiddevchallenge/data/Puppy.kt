package com.example.androiddevchallenge.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Farouk on 27/02/2021.
 */

@Parcelize
data class Puppy(
    val name: String,
    val gender: Gender,
    val age: String,
    val bio: String,
    val imageUrl: String
) : Parcelable {

    enum class Gender {
        MALE,
        FEMALE
    }

    companion object {
        private val puppyPhotos by lazy {
            fun String.url(): String {
                return "https://images.unsplash.com/$this?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MXwyMTQ2N3wwfDF8c2VhcmNofDF8fHB1cHBpZXN8ZW58MHx8fA&ixlib=rb-1.2.1&q=80&w=1080"
            }
            listOf(
                "photo-1560807707-8cc77767d783".url(),
                "photo-1601979031925-424e53b6caaa".url(),
                "photo-1565708097881-bbf4ecf47cc1".url(),
                "photo-1574293876203-8bded53be0f0".url(),
                "photo-1559076728-a51fe1c1f97a".url(),
                "photo-1608831540955-35094d48694a".url(),
                "photo-1555325084-b068599743c9".url(),
                "photo-1537151672256-6caf2e9f8c95".url(),
                "photo-1577447217290-a609cd45101f".url(),
                "photo-1612555788151-a6b40429d7e9".url(),
            )
        }

        private val puppiesNames = listOf(
            "Milo",
            "Rick",
            "Racky",
            "Malia",
            "Jacky",
            "Maddie",
            "Buster",
            "Frankie",
            "Apollo",
            "Rex",
        )

        operator fun invoke(): Puppy {
            val index = (0..9).random()
            val name = puppiesNames.random()
            val age = (1..10).random()
            val gender = if ((0..1).random() == 0) {
                Gender.FEMALE
            } else {
                Gender.MALE
            }
            return Puppy(
                name,
                gender = gender,
                age = "$age months old",
                bio = "$name love playing and going outside. Always waiting for your next command.",
                imageUrl = puppyPhotos[index]
            )
        }
    }
}
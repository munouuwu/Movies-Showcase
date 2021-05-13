package com.dicoding.moviesshowcase.repo

import com.dicoding.moviesshowcase.R
import com.dicoding.moviesshowcase.model.Data

object DataMovies {
    fun listDataMovies(): List<Data> {
        val list = ArrayList<Data>()

        list.add(
            Data(
                "MV_1",
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "Action, Sci-Fi, Adventure",
                "2019",
                "2h 2m",
                "English",
                72,
                R.drawable.poster_alita
            )
        )

        list.add(
            Data(
                "MV_2",
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "Music, Drama, History",
                "2018",
                "2h 15m",
                "English",
                80,
                R.drawable.poster_bohemian
            )
        )

        list.add(
            Data(
                "MV_3",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "Adventure, Fantasy, Drama",
                "2018",
                "2h 14m",
                "English",
                69,
                R.drawable.poster_crimes
            )
        )

        list.add(
            Data(
                "MV_4",
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "Animation, Family, Adventure",
                "2019",
                "1h 44m",
                "English",
                78,
                R.drawable.poster_how_to_train
            )
        )

        list.add(
            Data(
                "MV_5",
                "Overlord",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                "Horror, War, Sci-Fi",
                "2018",
                "1h 50m",
                "English",
                67,
                R.drawable.poster_overlord
            )
        )

        return list
    }

    fun listDataTvs(): List<Data> {
        val list = ArrayList<Data>()

        list.add(
            Data(
                "TV_1",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "Crime, Drama, Mystery, Action & Adventure",
                "2012",
                "42m x 170 Episodes",
                "English",
                66,
                R.drawable.poster_arrow
            )
        )

        list.add(
            Data(
                "TV_2",
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                "1986",
                "25m x 153 Episodes",
                "Japanese",
                81,
                R.drawable.poster_dragon_ball
            )
        )

        list.add(
            Data(
                "TV_3",
                "Game of Thrones",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "Sci-Fi & Fantasy, Drama, Action & Adventure",
                "2011",
                "1h x 73 Episodes",
                "English",
                84,
                R.drawable.poster_god
            )
        )

        list.add(
            Data(
                "TV_4",
                "Hanna",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "Action & Adventure, Drama",
                "2019",
                "50m x 16 Episodes",
                "English",
                75,
                R.drawable.poster_hanna
            )
        )

        list.add(
            Data(
                "TV_5",
                "The Walking Dead",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "2012",
                "42m x 153 Episodes",
                "English",
                81,
                R.drawable.poster_the_walking_dead
            )
        )

        return list
    }
}
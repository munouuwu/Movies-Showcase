package com.dicoding.moviesshowcase.repo

import com.dicoding.moviesshowcase.data.source.local.entity.MvEntity
import com.dicoding.moviesshowcase.data.source.local.entity.TvEntity
import com.dicoding.moviesshowcase.data.source.remote.response.GenreResponse
import com.dicoding.moviesshowcase.data.source.remote.response.MvResponse
import com.dicoding.moviesshowcase.data.source.remote.response.TvResponse

object DataMovies {
    lateinit var listGenre : List<GenreResponse>

    fun listDataDummyMoviesResponse(): List<MvResponse> {
        val list = ArrayList<MvResponse>()

        listGenre = listOf(GenreResponse(1, "Action"))

        list.add(
            MvResponse(
                1,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                200,
                listGenre,
                "en",
                72.0,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg"
            )
        )

        list.add(
            MvResponse(
                2,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                200,
                listGenre,
                "en",
                72.0,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg"
            )
        )

        list.add(
            MvResponse(
                3,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                200,
                listGenre,
                "en",
                72.0,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg"
            )
        )

        list.add(
            MvResponse(
                4,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                200,
                listGenre,
                "en",
                72.0,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg"
            )
        )

        list.add(
            MvResponse(
                5,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                200,
                listGenre,
                "en",
                72.0,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg"
            )
        )

        list.add(
            MvResponse(
                6,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                200,
                listGenre,
                "en",
                72.0,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg"
            )
        )

        list.add(
            MvResponse(
                7,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                200,
                listGenre,
                "en",
                72.0,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg"
            )
        )

        list.add(
            MvResponse(
                8,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                200,
                listGenre,
                "en",
                72.0,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg"
            )
        )

        list.add(
            MvResponse(
                9,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                200,
                listGenre,
                "en",
                72.0,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg"
            )
        )

        list.add(
            MvResponse(
                10,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                200,
                listGenre,
                "en",
                72.0,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg"
            )
        )

        return list
    }

    fun listDataDummyTvsResponse(): List<TvResponse> {
        val list = ArrayList<TvResponse>()

        listGenre = listOf(GenreResponse(1, "Action"))

        list.add(
            TvResponse(
                1,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10/10/2012",
                listGenre,
                170,
                7,
                "en",
                70.0,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg"
            )
        )

        list.add(
            TvResponse(
                2,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10/10/2012",
                listGenre,
                170,
                7,
                "en",
                70.0,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg"
            )
        )

        list.add(
            TvResponse(
                3,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10/10/2012",
                listGenre,
                170,
                7,
                "en",
                70.0,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg"
            )
        )

        list.add(
            TvResponse(
                4,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10/10/2012",
                listGenre,
                170,
                7,
                "en",
                70.0,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg"
            )
        )

        list.add(
            TvResponse(
                5,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10/10/2012",
                listGenre,
                170,
                7,
                "en",
                70.0,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg"
            )
        )

        list.add(
            TvResponse(
                6,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10/10/2012",
                listGenre,
                170,
                7,
                "en",
                70.0,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg"
            )
        )

        list.add(
            TvResponse(
                7,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10/10/2012",
                listGenre,
                170,
                7,
                "en",
                70.0,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg"
            )
        )

        list.add(
            TvResponse(
                8,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10/10/2012",
                listGenre,
                170,
                7,
                "en",
                70.0,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg"
            )
        )

        list.add(
            TvResponse(
                9,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10/10/2012",
                listGenre,
                170,
                7,
                "en",
                70.0,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg"
            )
        )

        list.add(
            TvResponse(
                10,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10/10/2012",
                listGenre,
                170,
                7,
                "en",
                70.0,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg"
            )
        )

        return list
    }

    fun listDataDummyMovies(): List<MvEntity> {
        val list = ArrayList<MvEntity>()

        list.add(
            MvEntity(
                1,
                1,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                200,
                "Action",
                "en",
                72.0,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg",
                true
            )
        )

        list.add(
            MvEntity(
                2,
                2,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                200,
                "Action",
                "en",
                72.0,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg",
                true
            )
        )

        list.add(
            MvEntity(
                3,
                3,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                200,
                "Action",
                "en",
                72.0,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg",
                true
            )
        )

        list.add(
            MvEntity(
                4,
                4,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                200,
                "Action",
                "en",
                72.0,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg",
                false
            )
        )

        list.add(
            MvEntity(
                5,
                5,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                200,
                "Action",
                "en",
                72.0,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg",
                false
            )
        )

        list.add(
            MvEntity(
                6,
                6,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                200,
                "Action",
                "en",
                72.0,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg",
                false
            )
        )

        list.add(
            MvEntity(
                7,
                7,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                200,
                "Action",
                "en",
                72.0,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg",
                false
            )
        )

        list.add(
            MvEntity(
                8,
                8,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                200,
                "Action",
                "en",
                72.0,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg",
                false
            )
        )

        list.add(
            MvEntity(
                9,
                9,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                200,
                "Action",
                "en",
                72.0,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg",
                false
            )
        )

        list.add(
            MvEntity(
                10,
                10,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                200,
                "Action",
                "en",
                72.0,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg",
                false
            )
        )

        return list
    }

    fun listDataDummyTvs(): List<TvEntity> {
        val list = ArrayList<TvEntity>()

        list.add(
            TvEntity(
                1,
                1,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10/10/2012",
                "Action",
                100,
                3,
                "en",
                70.0,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg",
                true
            )
        )

        list.add(
            TvEntity(
                2,
                2,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10/10/2012",
                "Action",
                100,
                3,
                "en",
                70.0,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg",
                true
            )
        )

        list.add(
            TvEntity(
                3,
                3,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10/10/2012",
                "Action",
                100,
                3,
                "en",
                70.0,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg",
                true
            )
        )

        list.add(
            TvEntity(
                4,
                4,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10/10/2012",
                "Action",
                100,
                3,
                "en",
                70.0,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg",
                false
            )
        )

        list.add(
            TvEntity(
                5,
                5,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10/10/2012",
                "Action",
                100,
                3,
                "en",
                70.0,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg",
                false
            )
        )

        list.add(
            TvEntity(
                6,
                6,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10/10/2012",
                "Action",
                100,
                3,
                "en",
                70.0,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg",
                false
            )
        )

        list.add(
            TvEntity(
                7,
                7,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10/10/2012",
                "Action",
                100,
                3,
                "en",
                70.0,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg",
                false
            )
        )

        list.add(
            TvEntity(
                8,
                8,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10/10/2012",
                "Action",
                100,
                3,
                "en",
                70.0,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg",
                false
            )
        )

        list.add(
            TvEntity(
                9,
                9,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10/10/2012",
                "Action",
                100,
                3,
                "en",
                70.0,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg",
                false
            )
        )

        list.add(
            TvEntity(
                10,
                10,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10/10/2012",
                "Action",
                100,
                3,
                "en",
                70.0,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg",
                false
            )
        )

        return list
    }
}

package com.dicoding.moviesshowcase.repo

import com.dicoding.moviesshowcase.data.Data
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

    fun listDataDummyMovies(): List<Data> {
        val list = ArrayList<Data>()

        list.add(
            Data(
                1,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "Action",
                "02/14/2019",
                200,
                "en",
                72.0,
                null,
                null,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg"
            )
        )

        list.add(
            Data(
                2,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "Action",
                "02/14/2019",
                200,
                "en",
                72.0,
                null,
                null,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg"
            )
        )

        list.add(
            Data(
                3,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "Action",
                "02/14/2019",
                200,
                "en",
                72.0,
                null,
                null,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg"
            )
        )

        list.add(
            Data(
                4,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "Action",
                "02/14/2019",
                200,
                "en",
                72.0,
                null,
                null,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg"
            )
        )

        list.add(
            Data(
                5,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "Action",
                "02/14/2019",
                200,
                "en",
                72.0,
                null,
                null,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg"
            )
        )

        list.add(
            Data(
                6,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "Action",
                "02/14/2019",
                200,
                "en",
                72.0,
                null,
                null,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg"
            )
        )

        list.add(
            Data(
                7,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "Action",
                "02/14/2019",
                200,
                "en",
                72.0,
                null,
                null,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg"
            )
        )

        list.add(
            Data(
                8,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "Action",
                "02/14/2019",
                200,
                "en",
                72.0,
                null,
                null,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg"
            )
        )

        list.add(
            Data(
                9,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "Action",
                "02/14/2019",
                200,
                "en",
                72.0,
                null,
                null,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg"
            )
        )

        list.add(
            Data(
                10,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "Action",
                "02/14/2019",
                200,
                "en",
                72.0,
                null,
                null,
                "xRWht48C2V8XNfzvPehyClOvDni.jpg"
            )
        )

        return list
    }

    fun listDataDummyTvs(): List<Data> {
        val list = ArrayList<Data>()

        list.add(
            Data(
                1,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "Action",
                "10/10/2012",
                null,
                "en",
                70.0,
                100,
                3,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg"
            )
        )

        list.add(
            Data(
                2,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "Action",
                "10/10/2012",
                null,
                "en",
                70.0,
                100,
                3,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg"
            )
        )

        list.add(
            Data(
                3,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "Action",
                "10/10/2012",
                null,
                "en",
                70.0,
                100,
                3,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg"
            )
        )

        list.add(
            Data(
                4,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "Action",
                "10/10/2012",
                null,
                "en",
                70.0,
                100,
                3,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg"
            )
        )

        list.add(
            Data(
                5,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "Action",
                "10/10/2012",
                null,
                "en",
                70.0,
                100,
                3,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg"
            )
        )

        list.add(
            Data(
                6,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "Action",
                "10/10/2012",
                null,
                "en",
                70.0,
                100,
                3,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg"
            )
        )

        list.add(
            Data(
                7,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "Action",
                "10/10/2012",
                null,
                "en",
                70.0,
                100,
                3,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg"
            )
        )

        list.add(
            Data(
                8,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "Action",
                "10/10/2012",
                null,
                "en",
                70.0,
                100,
                3,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg"
            )
        )

        list.add(
            Data(
                9,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "Action",
                "10/10/2012",
                null,
                "en",
                70.0,
                100,
                3,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg"
            )
        )

        list.add(
            Data(
                10,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "Action",
                "10/10/2012",
                null,
                "en",
                70.0,
                100,
                3,
                "elbLQbocvW9vwrHRjYTSjXr5BX5.jpg"
            )
        )

        return list
    }
}

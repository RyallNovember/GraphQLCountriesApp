package com.ryall.graphqlcountriesapp.data

import com.ryall.CountriesQuery
import com.ryall.CountryQuery
import com.ryall.graphqlcountriesapp.domain.DetailedCountry
import com.ryall.graphqlcountriesapp.domain.SimpleCountry

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry {
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
        currency = currency ?: "No currency",
        languages = languages.mapNotNull { it.name },
        continent = continent.name
    )
}

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital"
    )
}
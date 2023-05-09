package com.ryall.graphqlcountriesapp.data

import com.apollographql.apollo3.ApolloClient
import com.ryall.CountriesQuery
import com.ryall.CountryQuery
import com.ryall.graphqlcountriesapp.domain.CountryClient
import com.ryall.graphqlcountriesapp.domain.DetailedCountry
import com.ryall.graphqlcountriesapp.domain.SimpleCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient

) : CountryClient {
    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }
}
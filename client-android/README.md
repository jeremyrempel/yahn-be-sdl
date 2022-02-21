# org.openapitools.client - Kotlin client library for OpenAPI definition

## Requires

* Kotlin 1.4.30
* Gradle 6.8.3

## Build

First, create the gradle wrapper script:

```
gradle wrapper
```

Then, run:

```
./gradlew check assemble
```

This runs all tests and packages the library.

## Features/Implementation Notes

* Supports JSON inputs/outputs, File inputs, and Form inputs.
* Supports collection formats for query parameters: csv, tsv, ssv, pipes.
* Some Kotlin and Java types are fully qualified to avoid conflicts with types defined in OpenAPI definitions.
* Implementation of ApiClient is intended to reduce method counts, specifically to benefit Android targets.

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *http://localhost:8080*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ViewControllerApi* | [**home**](docs/ViewControllerApi.md#home) | **GET** /api/home | 
*ViewControllerApi* | [**viewOne**](docs/ViewControllerApi.md#viewone) | **GET** /api/detail | 


<a name="documentation-for-models"></a>
## Documentation for Models

 - [org.openapitools.client.models.Content](docs/Content.md)
 - [org.openapitools.client.models.Screen](docs/Screen.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

All endpoints do not require authorization.

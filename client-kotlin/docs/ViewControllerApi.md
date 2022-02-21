# ViewControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**home**](ViewControllerApi.md#home) | **GET** /api/home | 
[**viewOne**](ViewControllerApi.md#viewOne) | **GET** /api/detail | 


<a name="home"></a>
# **home**
> Screen home()



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ViewControllerApi()
try {
    val result : Screen = apiInstance.home()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ViewControllerApi#home")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ViewControllerApi#home")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Screen**](Screen.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="viewOne"></a>
# **viewOne**
> Screen viewOne(id)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ViewControllerApi()
val id : kotlin.String = id_example // kotlin.String | 
try {
    val result : Screen = apiInstance.viewOne(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ViewControllerApi#viewOne")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ViewControllerApi#viewOne")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**|  |

### Return type

[**Screen**](Screen.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined


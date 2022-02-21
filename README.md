# Overview

SDL based backend for Hacker News API. Current API involves multiple callbacks to make a similar API call.

## Projects
* [server](https://github.com/jeremyrempel/yahn-be-sdl/tree/main/server)
* autogenerated clients: [kotlin](https://github.com/jeremyrempel/yahn-be-sdl/tree/main/client-kotlin) |  [swift](https://github.com/jeremyrempel/yahn-be-sdl/tree/main/client-swift)

## API Docs
* ui: [swagger ui](http://localhost:8080/webjars/swagger-ui/index.html)
* json: [open api v3](http://localhost:8080/v3/api-docs)

## Sample Responses

### Home
```json
{
   "title":"Home",
   "content":{
      "data":[
         {
            "title":"Item 1",
            "text":"Item 1 content",
            "link":"/api/item/1"
         },
         {
            "title":"Item 2",
            "text":"Item 2 content",
            "link":"/api/item/2"
         }
      ],
      "type":"list"
   }
}
```

### Details
```json
{
   "title":"View 1",
   "content":{
      "text":"data: 1",
      "type":"detail"
   }
}
```


## Generator Docs

* [kotlin](https://openapi-generator.tech/docs/generators/kotlin)
* [swift5](https://openapi-generator.tech/docs/generators/swift5)

<#import "apiRequest.ftl" as ApiRequest>
<#import "info.ftl" as Info>
{
    "info": ${Info.info}
    "item": [<@ApiRequest.ApiRequests collection.apiRequests/>]
}
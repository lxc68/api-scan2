<#macro ApiRequests apiRequests>
    <#list apiRequests as apiRequest>
        {
        "name": "${apiRequest.name}",
        "request": {
                        "method": "${apiRequest.request.method}",
                        "header": [],
                        "url": {
                                    "raw": "${apiRequest.request.url.raw}",
                                    "protocol": "${apiRequest.request.url.protocol}",
                                    "host": [<#list apiRequest.request.url.hosts as host>
                                                "${host}"<#if host?is_last == false>,</#if></#list>
                                            ],
                                    "port": "${apiRequest.request.url.port}",
                                    "path": [<#list apiRequest.request.url.paths as path>
                                                "${path}"<#if path?is_last == false>,</#if></#list>
                                            ],
                                    "query": [<#list apiRequest.request.url.querys as query>
                                                {"key": "${query.key}",
                                                "value": "${query.value}"}<#if query?is_last == false>,</#if></#list>
                                            ]
                                }
                    },
        "response": []
        }<#if apiRequest?is_last == false>,</#if>
    </#list>
</#macro>

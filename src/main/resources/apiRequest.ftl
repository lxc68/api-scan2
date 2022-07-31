<#macro ApiRequests apiRequests>
    <#list apiRequests as apiRequest>
        {
        "name": "${apiRequest.name}",
        "event": [
            {
                "listen": "test",
                "script": {
                "exec": [
                        !pm.test("令牌验证通过", function () {
                        var jsondata = JSON.parse(responseBody); //把响应正文转化为json对象
                        var status = jsondata.status; //json对象名.键名
                        pm.expect(status).to.oneOf([200,500]);
                    });"
                ],
                "type": "text/javascript"
                }
            }
        ],
        "request": {
                        "method": "${apiRequest.request.method}",
                        "header": [{
                                        "key": "token",
                                        "value": "手动填充就好",
                                        "type": "text"
                        }],
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

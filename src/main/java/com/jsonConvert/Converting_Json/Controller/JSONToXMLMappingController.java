
package com.jsonConvert.Converting_Json.Controller;

import com.github.underscore.U;
import com.jsonConvert.Converting_Json.Model.RequestModel;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.json.XML;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class JSONToXMLMappingController {

    @PostMapping(path = "/mapJsontoXML", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody
    RequestModel mapJsonToXML(@RequestBody final RequestModel request) {
        return request;
    }

    @PostMapping("/mapXMLtoJson")
    public  String mapXMLtoJson() {
         String XML_TEXT = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";
//        return request;
        return XML.toJSONObject(XML_TEXT).toString();
    }
    @PostMapping(path = "/mapXMLtoJson1", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RequestModel mapXMLtoJson1(@RequestBody RequestModel request) {
        return request;
    }
    @PostMapping("/mapJsonToXml1")
    public  String mapJsonToXml1() {
        String json = "{\"name\":\"JSON\",\"integer\":1,\"double\":2.0,\"boolean\":true,\"nested\": {\"id\":42},"
                + "\"array\":[1,2,3]}";
        String xml = U.jsonToXml(json);
        U.xmlToJson(xml);
        return xml;
    }

}

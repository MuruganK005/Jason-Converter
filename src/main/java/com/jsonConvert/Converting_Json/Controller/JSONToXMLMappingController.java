
package com.jsonConvert.Converting_Json.Controller;

import com.jsonConvert.Converting_Json.Model.RequestModel;
import org.springframework.http.MediaType;
import org.json.XML;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JSONToXMLMappingController {

    @PostMapping(path = "/mapJsontoXML", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody
    RequestModel mapJsonToXML(@RequestBody final RequestModel request) {
        return request;
    }

    @PostMapping(path = "/mapXMLtoJson", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String mapXMLtoJson(@RequestBody final RequestModel request) {
         String XML_TEXT = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";
//        return request;
        return XML.toJSONObject(XML_TEXT).toString();
    }
}

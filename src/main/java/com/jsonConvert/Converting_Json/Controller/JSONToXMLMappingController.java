
package com.jsonConvert.Converting_Json.Controller;

import com.github.underscore.U;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jsonConvert.Converting_Json.Model.Jsoobj;
import com.jsonConvert.Converting_Json.Model.RequestModel;
import org.springframework.http.MediaType;
import org.json.XML;
import org.springframework.web.bind.annotation.*;

@RestController
public class JSONToXMLMappingController {

    //convert JSON Object  to XML Format
    @PostMapping(path = "/mapJsontoXML", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public RequestModel mapJsonToXML(@RequestBody final RequestModel request) {
        return request;
    }
    //convert XML Default Data to JSON Format
    @PostMapping("/mapXMLtoJson")
    public  String mapXMLtoJson() {
         String XML_TEXT = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";
        return XML.toJSONObject(XML_TEXT).toString();
    }
    //convert XML Object  to JSON Format
    @PostMapping(path = "/mapXMLtoJson1", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RequestModel mapXMLtoJson1(@RequestBody RequestModel request) {
        return request;
    }
    //convert Json Default Data to Xml Format
    @PostMapping("/mapJsonToXml1")
    public  String mapJsonToXml1() {
        String json = "{\"name\":\"JSON\",\"integer\":1,\"double\":2.0,\"boolean\":true,\"nested\": {\"id\":42},"
                + "\"array\":[1,2,3]}";
        String xml = U.jsonToXml(json);
        U.xmlToJson(xml);
        return xml;
    }
    @PostMapping(path = "/Gson")
    public RequestModel createName(){
        String jsonString = "{\"id\": 1,\n" +
                "    \"name\": \"javapedia.net\",\n" +
                "    \"skillSet\": [\n" +
                "        {\n" +
                "            \"skillName\": \"java\",\n" +
                "            \"category\": \"server programming\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"skillName\": \"angular\",\n" +
                "            \"category\": \"frontend programming\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"skillName\": \"\",\n" +
                "            \"category\": \"database\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        RequestModel student = gson.fromJson(jsonString,RequestModel.class);
        return student;
//
//        jsonString = gson.toJson(student);
//        return jsonString;
    }
    @PostMapping(path = "/GsonObject")
    public RequestModel gson1(@RequestBody Jsoobj jhghfg){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String fdg = jhghfg.getDfrg();
        RequestModel student = gson.fromJson(fdg,RequestModel.class);
        return student;
    }

}

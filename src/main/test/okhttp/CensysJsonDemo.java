package okhttp;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CensysJsonDemo {

    public static void main(String[] args) {
        String result = "{  \"code\": 200,  \"status\": \"OK\",  \"result\": {    \"ip\": \"8.8.8.8\",    \"services\": [      {        \"port\": 53,        \"service_name\": \"DNS\",        \"transport_protocol\": \"UDP\",        \"extended_service_name\": \"DNS\",        \"dns\": {          \"server_type\": \"FORWARDING\"        }      },      {        \"port\": 443,        \"service_name\": \"HTTP\",        \"transport_protocol\": \"TCP\",        \"extended_service_name\": \"HTTPS\",        \"http\": {          \"request\": {            \"method\": \"GET\",            \"uri\": \"https://8.8.8.8/\",            \"headers\": {              \"User_Agent\": [                \"Mozilla/5.0 (compatible; CensysInspect/1.1; +https://about.censys.io/)\"              ],              \"Accept\": [                \"*/*\"              ]            }          },          \"response\": {            \"body\": \"<!DOCTYPE html>...\",            \"protocol\": \"HTTP/1.1\",            \"body_size\": 1000,            \"status_code\": 404,            \"status_reason\": \"Not Found\",            \"headers\": {              \"Content_Length\": [                \"<REDACTED>\"              ],              \"Content_Type\": [                \"text/html; charset=UTF-8\"              ],              \"Server\": [                \"HTTP server (unknown)\"              ],              \"Date\": [                \"<REDACTED>\"              ]            },            \"html_tags\": [              \"<title>Error 404 (Not Found)!!1</title>\",              \"<meta charset=utf-8>\",              \"<meta name=viewport content=\\\"initial-scale=1, minimum-scale=1, width=device-width\\\">\"            ]          }        },        \"certificate\": \"e58e89a726d80bb0219b218c3ab9d818b4be75d77959508400d660ebe1c1be3d\",        \"tls\": {}      }    ],    \"location_updated_at\": \"2021-03-30T14:53:12.980328Z\",    \"location\": {      \"continent\": \"North America\",      \"country\": \"United States\",      \"country_code\": \"US\",      \"postal_code\": \"48104\",      \"timezone\": \"America/Michigan\",      \"coordinates\": {        \"latitude\": \"42.273\",        \"longitude\": \"-83.751\"      },      \"registered_country\": \"United States\",      \"registered_country_code\": \"US\"    },    \"autonomous_system_updated_at\": \"2021-04-09T17:33:12.118684Z\",    \"autonomous_system\": {      \"asn\": 15169,      \"description\": \"GOOGLE\",      \"bgp_prefix\": \"8.8.8.0/24\",      \"name\": \"GOOGLE\",      \"country_code\": \"US\"    },    \"operating_system\": {      \"product\": \"Linux\",      \"vendor\": \"Ubuntu\",      \"version\": \"18.04\",      \"edition\": \"bionic\",      \"uniform_resource_identifier\": \"cpe:2.3:o:*:linux:*:*:*:*:*:*:*:*\",      \"other\": {}    },    \"last_updated_at\": \"2021-07-29T07:08:27.610Z\"  }}";

        JSONObject resultObject = JSONObject.parseObject(result);
        int code = Integer.parseInt(resultObject.get("code").toString());
        if (code == 200) {
            Map<String, Object> mapResult = new HashMap<>();
            JSONObject resultJSONObject = resultObject.getJSONObject("result");
            JSONArray services = resultJSONObject.getJSONArray("services");
            for (int i = 0; i < services.size(); i++) {
                JSONObject serviceJsonObject = (JSONObject) services.get(0);
                mapResult.put("port" + (i + 1), serviceJsonObject.get("port"));
                mapResult.put("service_name" + (i + 1), serviceJsonObject.get("service_name"));
                mapResult.put("transport_protocol" + (i + 1), serviceJsonObject.get("transport_protocol"));
            }
            Object locationUpdatedAt = resultJSONObject.get("location_updated_at");
            //时间格式化
            mapResult.put("location_updated_at", locationUpdatedAt);
            mapResult.get("location");



            System.out.println(mapResult);

        }
    }

}

package com.first.maptest;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class HospitalApi {
    String apiUrl = "http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncLcinfoInqire";
    String apiKey = "=GDhL22cwi46u1oRJt6eX4pqfXy0b0jSB8sF1eJszial+cYZZEdyiaY+xuOe6LjXp6BpXSvvtQ2tVOkee/A0kag==";

    public ArrayList<HospitalData> getData() {
        //return data와 관련된 부분
        ArrayList<HospitalData> dataArr = new ArrayList<HospitalData>();

        //네트워킹 작업은 메인스레드에서 처리하면 안된다. 따로 스레드를 만들어 처리하자
        Thread t = new Thread() {
            @Override
            public void run() {
                try {

                    //url과 관련된 부분
                    String fullurl = apiUrl + "=GDhL22cwi46u1oRJt6eX4pqfXy0b0jSB8sF1eJszial+cYZZEdyiaY+xuOe6LjXp6BpXSvvtQ2tVOkee/A0kag==" + apiKey + "&returnType=XML";
                    URL url = new URL(fullurl);
                    InputStream is = url.openStream();

                    //xmlParser 생성
                    XmlPullParserFactory xmlFactory = XmlPullParserFactory.newInstance();
                    XmlPullParser parser = xmlFactory.newPullParser();
                    parser.setInput(is,"utf-8");

                    //xml과 관련된 변수들
                    boolean WGS84_LON = false, WGS84_LAT = false;
                    Double latitude = Double.valueOf("");
                    Double longitude = Double.valueOf("");

                    //본격적으로 파싱
                    while(parser.getEventType() != XmlPullParser.END_DOCUMENT) {
                        int type = parser.getEventType();
                        HospitalData data = new HospitalData();

                        //태그 확인
                        if(type == XmlPullParser.START_TAG) {
                            if (parser.getName().equals("col")) {
                                if (parser.getAttributeValue(0).equals("위도"))
                                    WGS84_LON = true;
                                else if (parser.getAttributeValue(0).equals("경도"))
                                    WGS84_LAT = true;
                            }
                        }
                        //내용 확인
                        else if(type == XmlPullParser.TEXT) {
                            if (WGS84_LON) {
                                latitude = Double.valueOf(parser.getText());
                                WGS84_LON = false;
                            } else if (WGS84_LAT) {
                                longitude = Double.valueOf(parser.getText());
                                WGS84_LAT = false;
                            }

                        }
                        //내용 다 읽었으면 데이터 추가
                        else if (type == XmlPullParser.END_TAG && parser.getName().equals("item")) {
                            data.setLatitude(Double.valueOf(latitude));
                            data.setLongitude(Double.valueOf(longitude));

                            dataArr.add(data);
                        }

                        type = parser.next();
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        };
        try {
            t.start();
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return dataArr;
    }
}



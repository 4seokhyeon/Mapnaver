package com.first.maptest;

import android.util.Log;

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
    String apiUrl = "http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncFullDown";
    String apiKey = "SPDSn%2FBJUGuyatbQ8AZUwNo1QheqcTgc2Ljmn7uE%2BuoVo3CfD1ceb57Lb%2FQE8Y3lhzGwq2%2F%2Becds93iK0kNTsg%3D%3D";

    public ArrayList<HospitalData> getData() {
        //return data와 관련된 부분
        ArrayList<HospitalData> dataArr = new ArrayList<HospitalData>();

        //네트워킹 작업은 메인스레드에서 처리하면 안된다. 따로 스레드를 만들어 처리하자
        Thread t = new Thread() {
            @Override
            public void run() {
                try {

                    //url과 관련된 부분
                    String fullurl = apiUrl + "?serviceKey=" + apiKey + "&returnType=XML";
                    URL url = new URL(fullurl);
                    InputStream is = url.openStream();

                    //xmlParser 생성
                    XmlPullParserFactory xmlFactory = XmlPullParserFactory.newInstance();
                    XmlPullParser parser = xmlFactory.newPullParser();
                    parser.setInput(is,"utf-8");

                    //xml과 관련된 변수들
                    boolean bName = false, bLat = false, bLong = false,bAddr=false, bTell=false;
                    String name = "", latitude = "", longitude = "",addr="",tell="";

                    //본격적으로 파싱
                    while(parser.getEventType() != XmlPullParser.END_DOCUMENT) {
                        int type = parser.getEventType();
                        HospitalData  data = new HospitalData ();

                        //태그 확인
                        if(type == XmlPullParser.START_TAG) {

                                if (parser.getName().equals("dutyAddr"))
                                    bAddr = true;
                                else if(parser.getName().equals("dutyName"))
                                    bName = true;
                                else if(parser.getName().equals("dutyTel1"))
                                    bTell = true;
                                else if (parser.getName().equals("wgs84Lat"))
                                    bLat = true;
                                else if (parser.getName().equals("wgs84Lon"))
                                    bLong = true;

                        }
                        //내용 확인
                        else if(type == XmlPullParser.TEXT) {
                             if (bAddr) {
                                addr = parser.getText();
                                bAddr = false;
                            }
                            else if (bName) {
                                name = parser.getText();
                                bName = false;
                            }
                            else if (bTell) {
                                tell = parser.getText();
                                bTell = false;
                            }
                            else if (bLat) {
                                latitude = parser.getText();
                                bLat = false;
                            } else if (bLong) {
                                longitude = parser.getText();
                                bLong = false;
                            }
                        }
                        //내용 다 읽었으면 데이터 추가
                        else if (type == XmlPullParser.END_TAG && parser.getName().equals("item")) {
                            data.setDutyName(name);
                            data.setWGS84_LAT(Double.parseDouble(latitude));
                            data.setWGS84_LON(Double.parseDouble(longitude));
                            data.setDutyAddr(addr);
                            data.setDutyTel1(tell);


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






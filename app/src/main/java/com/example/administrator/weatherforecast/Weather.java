package com.example.administrator.weatherforecast;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/11/7.
 */

public class Weather implements Serializable{


    /**
     * code : 200
     * msg : 成功!
     * data : {"yesterday":{"date":"20日星期二","high":"高温 10℃","fx":"东北风","low":"低温 -1℃","fl":"<![CDATA[3-4级]]>","type":"多云"},"city":"北京","aqi":"66","forecast":[{"date":"21日星期三","high":"高温 9℃","fengli":"<![CDATA[3-4级]]>","low":"低温 -3℃","fengxiang":"西北风","type":"晴"},{"date":"22日星期四","high":"高温 8℃","fengli":"<![CDATA[<3级]]>","low":"低温 -3℃","fengxiang":"南风","type":"晴"},{"date":"23日星期五","high":"高温 7℃","fengli":"<![CDATA[<3级]]>","low":"低温 -1℃","fengxiang":"无持续风向","type":"多云"},{"date":"24日星期六","high":"高温 9℃","fengli":"<![CDATA[<3级]]>","low":"低温 -3℃","fengxiang":"西南风","type":"晴"},{"date":"25日星期天","high":"高温 10℃","fengli":"<![CDATA[<3级]]>","low":"低温 -3℃","fengxiang":"北风","type":"晴"}],"ganmao":"天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。","wendu":"2"}
     */

    private int code;
    private String msg;
    private Data data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        /**
         * yesterday : {"date":"20日星期二","high":"高温 10℃","fx":"东北风","low":"低温 -1℃","fl":"<![CDATA[3-4级]]>","type":"多云"}
         * city : 北京
         * aqi : 66
         * forecast : [{"date":"21日星期三","high":"高温 9℃","fengli":"<![CDATA[3-4级]]>","low":"低温 -3℃","fengxiang":"西北风","type":"晴"},{"date":"22日星期四","high":"高温 8℃","fengli":"<![CDATA[<3级]]>","low":"低温 -3℃","fengxiang":"南风","type":"晴"},{"date":"23日星期五","high":"高温 7℃","fengli":"<![CDATA[<3级]]>","low":"低温 -1℃","fengxiang":"无持续风向","type":"多云"},{"date":"24日星期六","high":"高温 9℃","fengli":"<![CDATA[<3级]]>","low":"低温 -3℃","fengxiang":"西南风","type":"晴"},{"date":"25日星期天","high":"高温 10℃","fengli":"<![CDATA[<3级]]>","low":"低温 -3℃","fengxiang":"北风","type":"晴"}]
         * ganmao : 天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。
         * wendu : 2
         */

        private Yesterday yesterday;
        private String city;
        private String aqi;
        private String ganmao;
        private String wendu;
        private List<Forecast> forecast;

        public Yesterday getYesterday() {
            return yesterday;
        }

        public void setYesterday(Yesterday yesterday) {
            this.yesterday = yesterday;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAqi() {
            return aqi;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public List<Forecast> getForecast() {
            return forecast;
        }

        public void setForecast(List<Forecast> forecast) {
            this.forecast = forecast;
        }

        public static class Yesterday {
            /**
             * date : 20日星期二
             * high : 高温 10℃
             * fx : 东北风
             * low : 低温 -1℃
             * fl : <![CDATA[3-4级]]>
             * type : 多云
             */

            private String date;
            private String high;
            private String fx;
            private String low;
            private String fl;
            private String type;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class Forecast {
            /**
             * date : 21日星期三
             * high : 高温 9℃
             * fengli : <![CDATA[3-4级]]>
             * low : 低温 -3℃
             * fengxiang : 西北风
             * type : 晴
             */

            private String date;
            private String high;
            private String fengli;
            private String low;
            private String fengxiang;
            private String type;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getFengli() {
                return fengli;
            }

            public void setFengli(String fengli) {
                this.fengli = fengli;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getFengxiang() {
                return fengxiang;
            }

            public void setFengxiang(String fengxiang) {
                this.fengxiang = fengxiang;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}

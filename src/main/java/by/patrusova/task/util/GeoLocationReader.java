package by.patrusova.task.util;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CountryResponse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

public class GeoLocationReader {

    private final static Logger LOGGER = LogManager.getLogger();
    private final static String HEADER = "X-FORWARDED-FOR";
    private final static String PATH_TO_GEO_DB = "src\\main\\resources\\static\\GeoLite2-Country.mmdb";

    public GeoLocationReader() {
    }

    public String getClientCountryByIp(HttpServletRequest request) {
        String clientIp = "";
        if (request != null) {
            clientIp = request.getHeader(HEADER);
            if (clientIp == null || "".equals(clientIp)) {
                clientIp = request.getRemoteAddr();
            }
        }
        GeoLocationReader reader = new GeoLocationReader();
        return reader.findCountry(clientIp);
    }

    private String findCountry(String ip) {
        File database = new File(PATH_TO_GEO_DB);
        String country = "";
        try {
            DatabaseReader dbReader = new DatabaseReader.Builder(database).build();
            CountryResponse response = dbReader.country(InetAddress.getByName(ip));
            country = response.getCountry().getName();
        } catch (IOException | GeoIp2Exception e) {
            LOGGER.log(Level.ERROR, "Wrong access to Geo DB");
            e.printStackTrace();
        }
        return country;
    }

}

package wiki.soma.common.constants;

import java.util.regex.Pattern;

public class CrawlConstants {

    public static final String URL_36KR = "https://36kr.com/";

    public static final Pattern PATTERN = Pattern.compile("<a\\b[^>]+\\bhref=\"([^\"]*)\"[^ target=\"_blank\" rel=\"noopener noreferrer\">]*>([\\s\\S]*?)</a>");

}

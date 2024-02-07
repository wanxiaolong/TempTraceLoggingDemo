package com.demo.trace.logging;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

@Slf4j
public class MaskPatternLayout extends PatternLayout {

    private Pattern pattern;
    private List<String> maskPatterns = new ArrayList<>();

    public MaskPatternLayout() {
    }

    //在logback.xml中配置了<maskPattern>，这里需要有个方法与之对应，用来创建完整的MaskPatternLayout对象
    public void addMaskPattern(String maskPattern) {
        this.maskPatterns.add(maskPattern);
        this.pattern = Pattern.compile(String.join("|", maskPatterns), 8);
    }

    @Override
    public String doLayout(ILoggingEvent event) {
        return maskLog(super.doLayout(event));
    }

    private String maskLog(String message) {
        StringBuilder stringBuilder = new StringBuilder(message);
        Matcher matcher = pattern.matcher(stringBuilder);
        while(matcher.find()) {
            //遍历所有匹配的组。matcher.groupCount()返回总共的匹配数目
            IntStream.rangeClosed(1, matcher.groupCount()).forEach((group) -> {
                if (matcher.group(group) != null) {
                    //遍历一个匹配项中的所有字符，将它们设置成'*'
                    IntStream.range(matcher.start(group), matcher.end(group)).forEach((i) -> {
                        stringBuilder.setCharAt(i, '*');
                    });
                }
            });
        }
        return stringBuilder.toString();
    }
}

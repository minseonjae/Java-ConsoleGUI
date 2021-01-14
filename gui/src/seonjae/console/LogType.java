package seonjae.console;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LogType {
    NONE(null, -1), INFO("정보", 0), WARNING("경고", 1), DANGER("위험", 2);

    private String name;
    private int id;
}

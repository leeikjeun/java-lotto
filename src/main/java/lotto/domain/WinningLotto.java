package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public enum WinningLotto {

    NOTTING_PLACE(0,0,0,"당첨안됨"),
    FIVE_PLACE(3,0 , 5000, "5등"),
    FOUR_PLACE(4,0 , 50000, "4등"),
    THREE_PLACE(5,0 , 1500000, "3등"),
    TWO_PLACE(5,1 , 30000000, "2등"),
    ONE_PLACE(6, 0 ,2000000000, "1등");

    public final int condition; // 맞은 번호 갯수
    public final int bounsCondition;
    public final int winningAmount; // 당첨금액
    public final String name;

    private static final Map<Integer, WinningLotto> CONDITION_MAP = new HashMap<>();

    static {
        // 2등을 제외한 기본값 셋팅
        Arrays.stream(WinningLotto.values())
                .filter(winningLotto -> winningLotto != TWO_PLACE)
                .forEach(winningLotto -> CONDITION_MAP.put(winningLotto.condition, winningLotto));
    }

    WinningLotto(int condition, int bounsCondition ,int winningAmount, String name){
        this.condition = condition;
        this.bounsCondition = bounsCondition;
        this.winningAmount = winningAmount;
        this.name = name;
    }

    public static WinningLotto getWinnerCondition(int condition, int bounsCondition){

        if(condition == 5 && bounsCondition == 1)
            return TWO_PLACE;

        return CONDITION_MAP.getOrDefault(condition, NOTTING_PLACE);
    }

}

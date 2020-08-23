package me.hyunseok;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TestListener implements Listener {

    @EventHandler
    // onEvent = 메서드 이름
    // PlayerJoinEvent = 변수 종류
    // event = 그 변수의 명칭 (매개 변수 명칭)
    public void onEvent(PlayerJoinEvent event){
        Player player = event.getPlayer();
        A_Class aClass = new A_Class(5);
        // Player 객체는 GameProflie 이라는 매개변수를 통해서 생성이 돼.
        // GameProfile 에는 UUID 랑 플레이어 이름이 저장이 되어있는 객체.
        // GameProfile을 받아와서, 이거에 맞춰서 자체적으로 설정을 한다음. 플레이어 객체가 만들어져.
        // 객체(인스턴스)와 클래스의 개념을 잘 이해하고 있지 않으면, 코딩을 못해. 그래서 이게 개념 잡기가 좀 빡세서, 자바는 초심자에게 권해지지 않아.
        // Class = 설계도
        // 객체 = 결과물
        // 민수,현석,민준 = 결과물
        // 플레이어 = 설계도.
        // 과제.
        // 플레아어가 들어오면, 다이아몬드 1개를 받을수 있도록 해봐.
        aClass.sex();
        aClass.getByeonSu();
        //문자열끼리 덧셈이 돼.
        // "sex" + "fuck"
        // -> sexfuck
        player.kickPlayer("씨발련 잘왔다. 나가라. FUCK YOU "+ aClass.getByeonSu());
        // 씨발련 잘왔다. 나가라. FUCK YOU 5
    }
}

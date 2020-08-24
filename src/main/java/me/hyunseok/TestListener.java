package me.hyunseok;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class TestListener implements Listener {

    static int count = 0;

    // static = 정적. (멈춰있는, 딱딱한, 고정)
    // 전역. (전체 통용 변수)
    // 얘는 클래스 변수라고도 함.
    // 각 개체마다 플레이어 이름이 다를꺼 아니야.
    // 각 개체마다 최대 HP는 20이라고.

    // static int MAX_HEALTH_SCALE = 20;
    // 모든 개체의 변수가 똑같이 저 동일한 값을 가짐. 공통값. 상수.
    // 만약에 19되면 모든 플레이어 싹다 최대 HP 19.
    // 언제 쓰이냐. 이 객체가 쓰이는데 있어서, 공통된 값을 가져야 할때 씀.
    static int VALUE;

    final static HashMap<UUID, Player> PLAYERS = new HashMap<>();
    final static List<Material> brokenBlocks = new ArrayList<>();
    final static HashMap<Material, Integer> map = new HashMap<>();
    //플레이어 전체 목록. 이게 여러개일리가 없잖음. 단 1개.

    List<String> asf;
    // 배열. 목록.

    HashMap<Integer, String> mapz;
    //키값 Integer를 넣으면 그에 대응하는 String 값을 출력함.
    //대표적인 해쉬맵구조: ItemStack의 인첸트 목록.

    // 접근 제어자, Access Modifier.
    // 너 개인 프로젝트에서는 사실 신경 많이 쓸 필요 없음.

    public int publicValue;
    //위로 올라갈수록 공개 변수
    //어디서든 접근 가능. 다른 프로젝트에서도 접근 가능함.
    protected int protectedVaule;
    int value;
    //패키지 같으면 접근 가능 = default int value;
    private int privateValue;
    //내부 변수. 다른데서 못씀
    //아래로 내려갈수록 내부 변수

    //한번 설정되면 못바꿈.
    public final void aMethod(){ }

    @EventHandler
    // onEvent = 메서드 이름
    // PlayerJoinEvent = 변수 종류
    // event = 그 변수의 명칭 (매개 변수 명칭)
    public void onEvent(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.getInventory().addItem(new ItemStack(Material.DIAMOND, 1));
        //자바의 특징: 사람이 읽을수 있음.
        //그래서 축약어 사용을 자바는 지양해. 별로 권장하지 않아.
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
        //player.kickPlayer("씨발련 잘왔다. 나가라. FUCK YOU "+ aClass.getByeonSu());
        // 씨발련 잘왔다. 나가라. FUCK YOU 5
        player.sendMessage("오늘 서버에 들어온 사람은 " + count + "명 입니다.");
        StringBuilder b = new StringBuilder();
        for(Material mat : brokenBlocks){
            b.append(mat.name() +",");
        }
        player.sendMessage("여지껏 깨진 블럭:" + b.toString());
        count++;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        brokenBlocks.add(event.getBlock().getType());
        if(!map.containsKey(event.getBlock().getType())) {
            map.put(event.getBlock().getType(), 0);
        }
        //null 그래서 초기화 작업임.

        map.put(event.getBlock().getType() , map.get(event.getBlock().getType()) +1);
        // 해당 블럭 타입을 집어넣고, 맵에 저장되있는 값을 불러온다음 +1.
        event.getPlayer().sendMessage("이 블럭은 타입이"+ event.getBlock().getType() + "이며," +" 오늘 " + map.get(event.getBlock().getType()) +"번 깨졌습니다.");
        //메세지 출력
    }

    @EventHandler
    public void getInventoryClick(InventoryClickEvent event){
        event.getCurrentItem().getItemMeta().setUnbreakable(true);
    }

    @EventHandler
    public void onFlightAttempt(PlayerToggleFlightEvent event) {

        if(event.isFlying() && event.getPlayer().getGameMode() != GameMode.CREATIVE) {

            event.getPlayer().setVelocity(event.getPlayer().getVelocity().add(new org.bukkit.util.Vector(0.0,0.25,0.0)));

            event.setCancelled(true);

        }

    }

/*
    public void onAsdf(BlockBreakEvent event){
       //아이템 인첸트 맵을 가져옵니다.
       //날카로움 레벨을 가져옵니다.

       if(true){

       } else if(true){

       }

       while(true){
           break;
       }

       for(int i = 1; 1<10; i++){
           break;
       }

       int adf = 1;
       double adff;
       String fdff = "fuck";

       List<String> aList;
       HashMap<Integer, String> map;
       // Key - Value
        // 숫자 값을 넣으면, 그에 대응하는 String 값을 불러옴.
        HashMap<UUID, Player> players;
        // UUID를 키로, 그에 맞는 Player 객체를 불러옴.
    }

 */
}

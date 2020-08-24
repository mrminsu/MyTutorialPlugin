package me.hyunseok;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

//JavaPlugin 객체를 상속, Listener를 구현
public class MyTutorialPlugin extends JavaPlugin implements Listener {

    //메서드 덮어씌우기
    @Override
    public void onEnable(){
        //플러그인 시작할때
        Bukkit.getLogger().info("니애미 씨발련아");
        Bukkit.getPluginManager().registerEvents(new TestListener(), this);
        TestListener test = new TestListener();
        test.publicValue = 5;
        test.value = 4;
        //Bukkit.getPluginManager().registerEvents(this, this);
    }

    //메서드 덮어씌우기
    @Override
    public void onDisable(){
        //플러그인 꺼질때
        Bukkit.getLogger().info("느금마 씨발련아");
    }

    @EventHandler
    public void onEvent(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.kickPlayer("씨발련 잘왔다. 나가라. FUCK YOU");
    }

}

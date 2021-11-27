package hszy.ydy.speed_runner;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;

import static org.bukkit.potion.PotionEffectType.DAMAGE_RESISTANCE;
import static org.bukkit.potion.PotionEffectType.WEAKNESS;

public class MyListener implements Listener {
    @EventHandler
    public void onAttack(EntityDamageByEntityEvent event)// 监听伤害事件
    {
        if (event.getEntity() instanceof Player)// 检测是否是player受到攻击,以及player是否是speedrunner即拥有龙蛋
        {
            //(event.getEntity()).sendMessage(String.valueOf(((Player) event.getEntity()).getHealth()));//text
            if ((((Player) event.getEntity()).getInventory()).contains(Material.DRAGON_EGG)) {
                if (((Player) event.getEntity()).getHealth() - event.getFinalDamage() <= 0) {
                    //降低血量至半颗心
                    event.setDamage(((Player) event.getEntity()).getHealth() - 1);
                    //移除flag并给予20秒抗性提升Ⅴ和虚弱
                    (((Player) event.getEntity()).getInventory()).remove(Material.DRAGON_EGG);
                    int i = 0;
                    PotionEffect p1 = new PotionEffect(DAMAGE_RESISTANCE, 400, 4, false);//加抗性提升Ⅴ
                    PotionEffect p2 = new PotionEffect(WEAKNESS,300,0,false);//加虚弱
                    while (!((((Player) event.getEntity()).addPotionEffect(p1))&&(((Player) event.getEntity()).addPotionEffect(p2))))//如果不行多试几次
                    {
                        i++;
                        if (i >= 5) break;
                    }
                }
            }
        }
    }
}

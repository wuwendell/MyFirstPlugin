package us.wendell.MyFirstPlugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MyFirstPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        //startup
        //reloads
        //plugin reloads
    }

    @Override
    public void onDisable() {
        //shutdown
        //reloads
        //plugin reloads
    }

    // /hello <-- Hey welcome!

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(label.equalsIgnoreCase("hello")){
            if(sender instanceof Player){
                // player sent it
                Player player = (Player) sender;
                if(player.hasPermission("hello.use")){
                    player.sendMessage(ChatColor.BOLD + "What's up!");
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&1H&2a&3v&4e &5f&6u&7n&8!"));
                }else{
                    player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                }
            }else{
                // console sent it
                sender.sendMessage(ChatColor.DARK_BLUE + "What's up console!");
            }
            return true;
        }else{
            return false;
        }

    }
}

package us.wendell.MyFirstPlugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * A demonstration plugin going from creating the project structure all the way to running on a test server.
 */
public class MyFirstPlugin extends JavaPlugin {
    public final String pluginName = "MyFirstPlugin";

    @Override
    public void onEnable() {
        //startup
        //reloads
        //plugin reloads
        getLogger().info(pluginName + " has been enabled!");
    }

    @Override
    public void onDisable() {
        //shutdown
        //reloads
        //plugin reloads
        getLogger().info(pluginName + " has been disabled!");
    }

    /**
     * Command /hello. Says hello to the player or console, depending on who's sending it and if they have permission.
     * @param sender the sender of the command: Console, or Player
     * @param cmd the command itself
     * @param label the name of the command sent, in this case, must be 'hello'.
     * @param args the arguments passed to the command.
     * @return true or false, depending on if the command was successfully executed.
     */
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
            sender.sendMessage("That is not a supported command!");
            return false;
        }
    }
}

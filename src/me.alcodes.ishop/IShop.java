package me.alcodes.bukkit.iMoney;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
public class IShop extends JavaPlugin implements Listener {
	public static Economy economy = null;
	public int diamondPrice = 55;
	public int ironPrice = 15;
	public int coalPrice = 10;
	public int goldPrice = 20;
	public int emeraldPrice = 75;
    public boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }
    public void onEnable()
    {
    	Bukkit.getServer().getPluginManager().registerEvents(this, this);
    		getLogger().info("Running iMoney by BigAl512");
    	if(!setupEconomy()){
    		getLogger().severe("This plugin requires Vault! Please install vault, then try again!");
    		Bukkit.getPluginManager().disablePlugin(this);
    	}
    }
    public boolean onCommand(CommandSender sender, Command command,  String label, String[] args){
    	if(sender instanceof Player){
    		Player p = (Player) sender;
    		String name = p.getName();
    			if(label.equalsIgnoreCase("buy")){
    				if(args.length == 0){
    					p.sendMessage(ChatColor.YELLOW + "Please use /buy <#>");
    					p.sendMessage("#1 for Iron | Cost: $15");
    					p.sendMessage("#2 for Gold | Cost: $20");
    					p.sendMessage("#3 for Coal | Cost: $10");
    					p.sendMessage("#4 for Diamond | Cost: $55");
    					p.sendMessage("#5 for Emerald | Cost: $75");
    					p.sendMessage(ChatColor.YELLOW + "More Items coming Soon!");
    				}else{
    					if(args[0].equalsIgnoreCase("1")){
    						if(economy.getBalance(name)>= ironPrice){
    							EconomyResponse er = economy.withdrawPlayer(name, ironPrice);
    							if(er.transactionSuccess()){
    								p.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 1));
    								p.sendMessage(ChatColor.YELLOW + "You Purchased 1x Iron Ingot for $15");
    							}
    						}
    						else{
    							p.sendMessage(ChatColor.RED + "You dont have enough money to do this!");
    						}
    				}else if(args[0].equalsIgnoreCase("2")){
						if(economy.getBalance(name)>= goldPrice){
							EconomyResponse er = economy.withdrawPlayer(name, goldPrice);
							if(er.transactionSuccess()){
								p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 1));
								p.sendMessage(ChatColor.YELLOW + "You Purchased 1x Gold Ingot for $20");
							}
						}
						else{
							p.sendMessage(ChatColor.RED + "You dont have enough money to do this!");
						}
    				}else if(args[0].equalsIgnoreCase("3")){
						if(economy.getBalance(name)>= coalPrice){
							EconomyResponse er = economy.withdrawPlayer(name, coalPrice);
							if(er.transactionSuccess()){
								p.getInventory().addItem(new ItemStack(Material.COAL, 1));
								p.sendMessage(ChatColor.YELLOW + "You Purchased 1x Coal for $10");
							}
						}
						else{
							p.sendMessage(ChatColor.RED + "You dont have enough money to do this!");
						}
    				}else if(args[0].equalsIgnoreCase("4")){
						if(economy.getBalance(name)>= diamondPrice){
							EconomyResponse er = economy.withdrawPlayer(name, diamondPrice);
							if(er.transactionSuccess()){
								p.getInventory().addItem(new ItemStack(Material.DIAMOND, 1));
								p.sendMessage(ChatColor.YELLOW + "You Purchased 1x Diamond for $55");
							}
						}
						else{
							p.sendMessage(ChatColor.RED + "You dont have enough money to do this!");
						}
    				}else if(args[0].equalsIgnoreCase("5")){
						if(economy.getBalance(name)>= emeraldPrice){
							EconomyResponse er = economy.withdrawPlayer(name, emeraldPrice);
							if(er.transactionSuccess()){
								p.getInventory().addItem(new ItemStack(Material.EMERALD, 1));
								p.sendMessage(ChatColor.YELLOW + "You Purchased 1x Emerald for $75");
							}
						}
						else{
							p.sendMessage(ChatColor.RED + "You dont have enough money to do this!");
						}
    			}
    	}
		return false;
    }
}
		return false;
    }	
}

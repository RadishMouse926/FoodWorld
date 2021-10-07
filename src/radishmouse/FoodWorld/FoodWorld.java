package radishmouse.FoodWorld;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.requests.GatewayIntent;
import radishmouse.FoodWorld.Commands.Clear;
import radishmouse.FoodWorld.Commands.Help;
import radishmouse.FoodWorld.Commands.List;
import radishmouse.FoodWorld.Commands.Mute;
import radishmouse.FoodWorld.Commands.Rules;
import radishmouse.FoodWorld.Commands.SetStatusChangeTime;
import radishmouse.FoodWorld.Events.GuildMemberJoin;
import radishmouse.FoodWorld.Events.GuildMessageReactionAdd;
import radishmouse.FoodWorld.Events.GuildMessageReceived;

public class FoodWorld {
	public static JDA jda;
	public static String prefix = "-";
	private static String token = "Classified";
	
	//main method
	public static void main(String[] args) throws LoginException {
		jda = JDABuilder.createDefault(token).enableIntents(GatewayIntent.GUILD_MEMBERS).build(); 
		jda.getPresence().setStatus(OnlineStatus.ONLINE);
		
		// set Status
		Status.status();
		
		jda.addEventListener(new Clear());
		jda.addEventListener(new List());
		jda.addEventListener(new Help());
		jda.addEventListener(new Mute());
		jda.addEventListener(new Rules());
		jda.addEventListener(new SetStatusChangeTime());
		jda.addEventListener(new GuildMemberJoin());
		jda.addEventListener(new GuildMessageReceived());
		jda.addEventListener(new GuildMessageReactionAdd());
	}
	
	public static EmbedBuilder sendMessage(String title, String description, String color) {
		EmbedBuilder msg = new EmbedBuilder();
		
		if (title != null)       { msg.setTitle(title); }
		if (description != null) { msg.setDescription(description); }
		if (color != null) {
			if (color == "Blue")   { msg.setColor(0x00bfff); }
			if (color == "Red")    { msg.setColor(0xe00914); }
			if (color == "Orange") { msg.setColor(0xff9100); }
		}
		
		return msg;
	}
}

package radishmouse.FoodWorld.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import radishmouse.FoodWorld.FoodWorld;

public class Rules extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		String pretitle = "Welcome to the `[server]` Discord server";
		String msgtxt = "There aren't that many rules here, just be cool" + "\n \n"
				+ "▫ Be respectfull" + "\n"
				+ "▫ Keep content related to their channels" + "\n"
				+ "▫ Keep chat clean" + "\n"
				+ "▫ Mods and owner of this server have the final say";
		
		if (args[0].equalsIgnoreCase(FoodWorld.prefix + "rules")) {
			String title = pretitle.replace("[server]", event.getGuild().getName());
			
			EmbedBuilder msg = FoodWorld.sendMessage(title, msgtxt, "Blue");
			event.getChannel().sendMessageEmbeds(msg.build()).queue();
		}
	}
}

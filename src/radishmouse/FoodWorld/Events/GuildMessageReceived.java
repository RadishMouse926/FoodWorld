package radishmouse.FoodWorld.Events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import radishmouse.FoodWorld.FoodWorld;

public class GuildMessageReceived extends ListenerAdapter {
	private String[] cuss_words = {
		"Cuss word 1",
		"Cuss word 2"
	};
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		// Cuss check
		String[] words = event.getMessage().getContentRaw().split("\\s+");
		
		if (timesCussed(words, event) != null) {
			EmbedBuilder msg = FoodWorld.sendMessage("Attention Mods", timesCussed(words, event), "Orange");
			event.getChannel().sendMessageEmbeds(msg.build()).queue();
			
			event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRolesByName("Muted", true).get(0)).queue();
		}
		
		/* If the bot ever sends a message, then add a ❌ reaction so users can delete that message */
		if (event.getAuthor().equals(event.getJDA().getSelfUser())) {
			event.getMessage().addReaction("❌").queue();
		}
	}
	
	private String timesCussed (String[] words, GuildMessageReceivedEvent event) {
		int has_cussed = 0;
		
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < cuss_words.length; j++) {
				if (words[i].equalsIgnoreCase(cuss_words[j])) {
					has_cussed++;
				}
			}
		}
		
		if (has_cussed == 0) {
			return null;
		}
		
		String msgtxt = event.getAuthor().getAsMention() + " just cussed `" + has_cussed + "` times. They're now muted.";
		
		if (has_cussed > 0) {
			if (has_cussed == 1) {
				msgtxt = event.getAuthor().getAsMention() + " just cussed `1` time. They're now muted.";
			}			
		}
		
		return msgtxt;
	}
}
